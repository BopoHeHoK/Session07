package com.example.rentalmayakovsky;

import com.example.rentalmayakovsky.connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws SQLException, ClassNotFoundException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        }

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}