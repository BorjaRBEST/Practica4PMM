package com.example.formulario2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaController {

    @FXML
    private ListView<String> listViewClientes;

    @FXML
    public void volverFormulario() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("vista-formulario.fxml"));
            Stage stage = (Stage) listViewClientes.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarLista() {
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios"); // Ajusta la consulta según tu base de datos

            List<String> clientes = new ArrayList<>();
            while (rs.next()) {
                // Suponiendo que quieres mostrar nombre y apellidos
                clientes.add(rs.getString("Nombre") + " " + rs.getString("Apellidos"));
            }

            listViewClientes.getItems().setAll(clientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
