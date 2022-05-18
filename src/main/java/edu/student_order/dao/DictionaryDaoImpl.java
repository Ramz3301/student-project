package edu.student_order.dao;

import edu.student_order.config.Config;
import edu.student_order.domain.PassportOffice;
import edu.student_order.domain.RegisterOffice;
import edu.student_order.domain.Street;
import edu.student_order.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    public static final String GET_STREET =
            "SELECT * " +
                    "FROM street " +
                    "WHERE street_name LIKE ?";

    public static final String GET_PASSPORT_OFFICE =
            "SELECT * " +
                    "FROM passport_office " +
                    "WHERE pass_office_area_id LIKE ?";

    public static final String GET_REGISTER_OFFICE =
            "SELECT * " +
                    "FROM register_office " +
                    "WHERE reg_office_area_id LIKE ?";



    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
        return connection;
    }

    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streetsList = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_STREET)) {
            statement.setString(1, "%" + pattern + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Street street =
                        new Street(resultSet.getLong("street_code"),
                                resultSet.getString("street_name"));
                streetsList.add(street);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return streetsList;
    }

    @Override
    public List<PassportOffice> findPassportOffice(String areaId) throws DaoException {
        List<PassportOffice> passportOfficeList = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PASSPORT_OFFICE)) {
            statement.setString(1, "%" + areaId + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PassportOffice passportOffice =
                        new PassportOffice(resultSet.getLong("pass_office_id"),
                                resultSet.getString("pass_office_area_id"),
                                resultSet.getString("pass_office_name"));
                passportOfficeList.add(passportOffice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return passportOfficeList;
    }

    @Override
    public List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException {
        List<RegisterOffice> registerOfficeList = new LinkedList<>();

        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_REGISTER_OFFICE)) {
            statement.setString(1, areaId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
             RegisterOffice registerOffice = new RegisterOffice(
                     resultSet.getLong("reg_office_id"),
                     resultSet.getString("reg_office_area_id"),
                     resultSet.getString("reg_office_name")
                     );
                registerOfficeList.add(registerOffice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return registerOfficeList;
    }
}



