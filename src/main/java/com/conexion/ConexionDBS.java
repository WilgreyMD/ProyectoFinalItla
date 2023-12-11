/*
    La conexion ala base de datos se hara aqui

 */
package com.conexion;

/**
 *
 * @author wilgrey-MD
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDBS {

    public ConexionDBS() {

    }

    private static final String URL = "jdbc:mysql://localhost:3306/tiendavirtual";
    private static final String USUARIO = "root";
    private static final String PASS = "1234";

    public Connection Conectar() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, PASS);
        } catch (ClassNotFoundException | SQLException e) {
        
        }
        return null;

    }
}
