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
            setParamForAdult(statement, 3, husband);

            Adult wife = studentOrder.getWife();
            setParamForAdult(statement, 16, wife);

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
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return result;
    }

    private void setParamForAdult(PreparedStatement statement, int start, Adult adult) throws SQLException {
        statement.setString(start++, adult.getSurname());
        statement.setString(start++, adult.getFirstName());
        statement.setString(start++, adult.getPatronymic());
        statement.setDate(start++, Date.valueOf(adult.getDateOfBirth()));
        statement.setString(start++, adult.getPassportSeries());
        statement.setString(start++, adult.getPassportNumber());
        statement.setDate(start++, Date.valueOf(adult.getIssueDate()));
        statement.setLong(start++, adult.getIssueDepartment().getOfficeId());
        Address address = adult.getAddress();
        statement.setString(start++, address.getPostCode());
        statement.setLong(start++, address.getStreet().getStreetCode());
        statement.setString(start++, address.getBuilding());
        statement.setString(start++, address.getExtension());
        statement.setString(start++, address.getApartment());
    }
}
