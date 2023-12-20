package com.example.formulario2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Conexion {
    private static Connection connection = null;
    // Método que primero lee el fichero properties y después captura los diferentes campos para iniciar la conexión
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                InputStream inputStream = new FileInputStream("src/main/resources/properties");
                properties.load(inputStream);

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
