package com.Utils;
import com.conexion.ConexionDBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuarios {
    
    private int id;
    private String nomrbe;
    private String correo;
    private String pass;
    private short  acceso;

    
    
    public Usuarios(String nombre, String pass) {
        this.nomrbe = nombre;
        // this.correo = correo;
        this.pass = pass;
    }

    
    public Usuarios(String nomrbe, String correo, String pass) {
        this.nomrbe = nomrbe;
        this.correo = correo;
        this.pass = pass;
        this.acceso = 0;
    }
    
    public Usuarios(int id,String nomrbe, String correo, String pass, short acceso) {
        this.id = id;
        this.nomrbe = nomrbe;
        this.correo = correo;
        this.pass = pass;
        this.acceso = acceso;
    }

    public Usuarios() {
        this.nomrbe = "";
        this.pass = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public String getNomrbe() {
        return nomrbe;
    }

    public void setNomrbe(String nomrbe) {
        this.nomrbe = nomrbe;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public short getAcceso() {
        return acceso;
    }

    public void setAcceso(short acceso) {
        this.acceso = acceso;
    }
    
    public static void agregarUsuarios(String userName, String password, String email) {
        
        try {
            Connection conexion = Conexion.crearConexion();
            if(conexion != null){
              Statement statement = conexion.createStatement();

                String query = "INSERT INTO clientes (name, pass, CorreoElectronico, acceso) VALUES ('" + userName + "', '" + password + "', '" + email+"', 0)";
                statement.executeUpdate(query);
            
            conexion.close();  
            }
            

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

      public static String comprobarUsuarios(String userName, String email) {

		try {
			Connection conexion = Conexion.crearConexion();
			Statement statement = conexion.createStatement();

			String query = "SELECT name, CorreoElectronico FROM clientes;";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				if (resultSet.getString("name").equals(userName)) {
					return "Ya existe ese nombre de usuario";
				} 
				
				if (resultSet.getString("CorreoElectronico").equals(email)) {
					return "Ya existe ese correo";
				}
			}
            conexion.close();

		} catch (SQLException e) {

		}
		return "";
	}
    
    public void agregarUs() throws ClassNotFoundException, SQLException {
        ConexionDBS conexionDBS = new ConexionDBS();
        try (Connection conexion = conexionDBS.Conectar()) {
            if (conexion != null) {
                String query = "INSERT INTO clientes (name, pass, CorreoElectronico,acceso) VALUES (?, ?, ?,0)";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                    
                    preparedStatement.setString(1, nomrbe);
                    preparedStatement.setString(2, pass);
                    preparedStatement.setString(3, correo);

                    
                    int filasAfectadas = preparedStatement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Usuario agregado exitosamente");
                    } else {
                            System.out.println("Error al agregar el usuario");
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

