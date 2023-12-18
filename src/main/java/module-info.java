module com.example.formulario2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.formulario2 to javafx.fxml;
    exports com.example.formulario2;
}