package com.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Sesion {
    
    public static Usuarios usuario = new Usuarios();

    public static void iniciarSesion (String userName, String password) {

        try {
            Connection conexion = Conexion.crearConexion();
            Statement statement = conexion.createStatement();
    
            String query = "SELECT name, pass FROM clientes;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String user = resultSet.getString("name");
                String pass = resultSet.getString("pass");

                if (userName.equals(user) && password.equals(pass)) {
                    usuario = new Usuarios(user, pass);
                }
            }

        } catch (SQLDataException e) {
            
        } catch (SQLException ex) { 
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean comprobarSesion () {

        boolean testUserName = !usuario.getNomrbe().isBlank() && !usuario.getNomrbe().isEmpty();
        boolean testPassword = !usuario.getPass().isBlank() && !usuario.getPass().isEmpty();

        return testUserName && testPassword;
    }

    public static void cerrarSesion() {
        usuario = new Usuarios();
    }

    public static String getUserName () {
        return usuario.getNomrbe();
    }
}