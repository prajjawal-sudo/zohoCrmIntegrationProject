package com.ui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/future_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection connection;

    public DBUtil() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> executeQuery(String query) {
        List<String[]> resultList = new ArrayList<>();

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getString(i);
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
