/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Conector {

    private static String driver = "com.mysql.cj.jdbc.Driver"; //Ultimo Driver conexión al motor BD
    private static String user = "Miguel"; //usuario del servidor de BD
    private static String pass = "Abc123"; //contraseña del usuario BD
    private static String url = "jdbc:mysql://localhost:3306/dbpetcare"; //ubicación del servidor y nombre de BD
    private static Connection conn;

    public Conector() {

    }

    public Connection getConexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar " + e);
        }
        return conn;
    }

    public void close() {
        conn = null;
        if (conn == null) {
           
        }
    }

}
