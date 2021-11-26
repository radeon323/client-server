package com.luxoft.oleksandr_shevchenko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        String jdbcUser = "postgres";
        String jdbcPass = "postgres";
        Statement statement = null;

        Connection connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPass);
        System.out.println("Connected successfully!");

        statement = connection.createStatement();

        String SQL = "CREATE TABLE goods " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(50), " +
                " price VARCHAR (50))";

        statement.executeUpdate(SQL);
        System.out.println("Table successfully created...");


    }
}
