package com.example.rentalmayakovsky;

import com.example.rentalmayakovsky.connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorizationController {
    public TextField textLogin;
    public TextField textPassword;
    public PasswordField password;
    public CheckBox cbPassword;
    public Label labelError;
    public Button btnLogin;

    public void onCheckboxPasswordClick(ActionEvent actionEvent) {
        if (cbPassword.isSelected()) {
            textPassword.setText(password.getText());
            textPassword.setVisible(true);
            password.setVisible(false);
            return;
        }
        password.setText(textPassword.getText());
        password.setVisible(true);
        textPassword.setVisible(false);
    }

    public void onButtonLoginClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String resultPassword = "";
        if (password.isVisible()) {
            resultPassword = password.getText();
        } else {
            resultPassword = textPassword.getText();
        }
        String sql = "SELECT * FROM employees WHERE login = '" + textLogin.getText() + "' AND password = '" + resultPassword + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            loadMainWindow();
        } else {
            labelError.setVisible(true);
        }
    }

    public void loadMainWindow() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.getIcons().add(new Image("file:src/images/logo.png"));
        stage.setTitle("Главная");
        stage.setScene(scene);
        stage.show();
        Stage thisWindow = (Stage) textLogin.getScene().getWindow();
        thisWindow.close();
    }
}