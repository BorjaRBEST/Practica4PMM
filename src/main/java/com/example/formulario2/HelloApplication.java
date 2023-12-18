package com.example.formulario2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // El método start es el punto de entrada para todas las aplicaciones JavaFX.
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML utilizando FXMLLoader desde la ruta proporcionada.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("vista-formulario.fxml"));

        // Cargar la escena con el contenido del archivo FXML y establecer dimensiones.
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Establecer el título de la ventana.
        stage.setTitle("Formulario con Conexión a BBDD");

        // Establecer la escena en el escenario y mostrar la ventana.
        stage.setScene(scene);
        stage.show();
    }

    // Método main que inicia la aplicación JavaFX.
    public static void main(String[] args) {
        launch();
    }
}
