package edu.student_order.dao;

import edu.student_order.domain.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao {

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student_order",
                "postgres",
                "1"
        );
        return connection;
    }

    public List<Street> findStreet(String pattern) throws SQLException {
        List<Street> streetsList = new LinkedList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * " +
                "FROM street " +
                "WHERE street_name LIKE '%" + pattern + "%'";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Street street =
                    new Street(resultSet.getLong("street_code"), resultSet.getString("street_name"));
            streetsList.add(street);
        }

        return streetsList;
    }
}
