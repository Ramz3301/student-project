package edu.student_order.dao;

import edu.student_order.config.Config;
import edu.student_order.domain.*;
import edu.student_order.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentOrderDaoImpl implements StudentOrderDao {

    private static final String INSERT_ORDER =
            "INSERT INTO student_order(" +
                    " student_order_status, student_order_date, h_sur_name, " +
                    " h_given_name, h_patronymic, h_date_of_birth, h_passport_series, " +
                    " h_passport_number, h_passport_date, h_passport_office_id, h_post_index, " +
                    " h_street_code, h_building, h_extension, h_apartment, w_sur_name, " +
                    " w_given_name, w_patronymic, w_date_of_birth, w_passport_series, " +
                    " w_passport_number, w_passport_date, w_passport_office_id, w_post_index, " +
                    " w_street_code, w_building, w_extension, w_apartment, certificate_id, " +
                    " register_office_id, marriage_date)" +
                    " VALUES (?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, ?, " +
                    " ?, ?);";

    private static final String INSERT_CHILD =
            "INSERT INTO jc_student_child(" +
                    " student_order_id, c_sur_name, c_given_name, " +
                    " c_patronymic, c_date_of_birth, c_certificate_number, c_certificate_date, " +
                    " c_register_office_id, c_post_index, c_street_code, c_building, " +
                    " c_extension, c_apartment)" +
                    " VALUES (?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?)";

    //TODO make one method
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
        return connection;
    }

    @Override
    public Long saveStudentOrder(StudentOrder studentOrder) throws DaoException {
        Long result = -1L;

        try (Connection connection = getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(INSERT_ORDER, new String[]{"student_order_id"})) {
            statement.setInt(1, StudentOrderStatus.START.ordinal());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            Adult husband = studentOrder.getHusband();
            setParamsForAdult(statement, 3, husband);

            Adult wife = studentOrder.getWife();
            setParamsForAdult(statement, 16, wife);

            // Marriage
            statement.setString(29, studentOrder.getMarriageCertificateId());
            statement.setLong(30, studentOrder.getMarriageOffice().getOfficeId());
            statement.setDate(31, Date.valueOf(studentOrder.getMarriageDate()));

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = generatedKeys.getLong(1);
            }
            generatedKeys.close();

            saveChildren(connection, studentOrder, result);

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return result;
    }

    private void saveChildren(Connection connection, StudentOrder studentOrder, Long studentOrderId)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CHILD)) {
            for (Child child : studentOrder.getChildren()) {
                statement.setLong(1, studentOrderId);
                setParamsForChild(statement, child);
                statement.executeUpdate();
            }
        }
    }

    private void setParamsForChild(PreparedStatement statement, Child child)
            throws SQLException {
        setParamsForPerson(statement, 2, child);
        statement.setString(6, child.getCertificateNumber());
        statement.setDate(7, Date.valueOf(child.getIssueDate()));
        statement.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamsForAddress(statement, 9, child);
    }

    private void setParamsForAdult(PreparedStatement statement, int start, Adult adult)
            throws SQLException {
        setParamsForPerson(statement, start, adult);
        statement.setString(start++, adult.getPassportSeries());
        statement.setString(start++, adult.getPassportNumber());
        statement.setDate(start++, Date.valueOf(adult.getIssueDate()));
        statement.setLong(start++, adult.getIssueDepartment().getOfficeId());
        setParamsForAddress(statement, start + 8, adult);
    }

    private void setParamsForAddress(PreparedStatement statement, int start, Person person)
            throws SQLException {
        Address address = person.getAddress();
        statement.setString(start, address.getPostCode());
        statement.setLong(start++, address.getStreet().getStreetCode());
        statement.setString(start++, address.getBuilding());
        statement.setString(start++, address.getExtension());
        statement.setString(start++, address.getApartment());
    }

    private int setParamsForPerson(PreparedStatement statement, int start, Person person)
            throws SQLException {
        statement.setString(start++, person.getSurname());
        statement.setString(start++, person.getFirstName());
        statement.setString(start++, person.getPatronymic());
        statement.setDate(start++, Date.valueOf(person.getDateOfBirth()));
        return start;
    }
}
