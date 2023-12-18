package com.example.formulario2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class FormularioController {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidos;
    @FXML
    private DatePicker datePicker;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private CheckBox cbAceptar;


    // Método para registrar usuario y mostrar un mensaje de confirmación.
    public void registrarUsuario() {
        // Obtener los valores del formulario
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        String fechaNacimiento = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String sexo = rbMasculino.isSelected() ? "M" : "F";
        boolean consentimiento = cbAceptar.isSelected();

        try {
            // Obtener la conexión a la base de datos
            Connection conn = Conexion.getConnection();

            // Crear la declaración SQL
            String sql = "INSERT INTO Usuarios (Nombre, Apellidos, FechaNacimiento, Sexo, ConsentimientoNewsletter) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Establecer los parámetros
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, fechaNacimiento);
            statement.setString(4, sexo);
            statement.setBoolean(5, consentimiento);

            // Ejecutar la inserción
            statement.executeUpdate();

            // Mostrar un mensaje de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Datos guardados en la base de datos.");
            alert.showAndWait();

            // Limpia los campos del formulario
            tfNombre.clear();
            tfApellidos.clear();
            datePicker.setValue(null); // Establece a null o a una fecha predeterminada
            rbMasculino.setSelected(false);
            rbFemenino.setSelected(false);
            cbAceptar.setSelected(false);

        } catch (SQLException e) {
            e.printStackTrace();
            // Mostrar un mensaje de error en caso de fallo
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo guardar en la base de datos.");
            alert.showAndWait();
        }
    }
    // Método que nos manda a la siguiente vista para mostrar la lista de clientes
    public void mostrarCLientes() {
        try {
            // Cargar el archivo FXML para la vista de lista de clientes
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista-lista.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual y establecer la nueva vista
            Stage stage = (Stage) tfNombre.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
