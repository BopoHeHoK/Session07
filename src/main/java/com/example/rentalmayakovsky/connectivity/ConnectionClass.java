package com.example.rentalmayakovsky.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String DB_NAME = "";
        String DB_USER = "root";
        String DB_PASSWORD = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("mysql:jdbc://localhost/" + DB_NAME, DB_USER, DB_PASSWORD);


        return connection;
    }
}
