package com.example.formulario2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaController {

    @FXML
    private ListView<String> lvListaClientes;


    @FXML
    private Button btBack;

    public void volverFormulario() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("vista-formulario.fxml")));
            Stage stage = (Stage) btBack.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarListado() {

        Connection conn = Conexion.getConnection();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios");

            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Sexo"),
                        rs.getBoolean("ConsentimientoNewsletter")
                ));
            }

            // Limpia los elementos existentes en la ListView
            lvListaClientes.getItems().clear();

            // Añade cada cliente a la ListView
            for (Cliente cliente : clientes) {
                lvListaClientes.getItems().add(cliente.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
