module com.example.rentalmayakovsky {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.rentalmayakovsky to javafx.fxml;
    exports com.example.rentalmayakovsky;
}