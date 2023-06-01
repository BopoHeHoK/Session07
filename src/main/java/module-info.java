module com.example.rentalmayakovsky {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.rentalmayakovsky to javafx.fxml;
    exports com.example.rentalmayakovsky;
}