package edu.student_order.dao;

import edu.student_order.domain.Street;
import edu.student_order.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    public static final String GET_STREET = "SELECT * " +
            "FROM street " +
            "WHERE street_name LIKE ?";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student_order",
                "postgres",
                "1"
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
                        new Street(resultSet.getLong("street_code"), resultSet.getString("street_name"));
                streetsList.add(street);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return streetsList;
    }
}
