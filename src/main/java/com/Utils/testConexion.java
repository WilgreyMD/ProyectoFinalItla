/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Utils;

/**
 *
 * @author wilgrey-MD
 */
public class testConexion {

    public static String dependencesForTest() {
        return "<%@page import=\"java.sql.Connection\"%>\n"
                + "<%@page import=\"java.sql.SQLException\"%>\n"
                + "<%@page import=\"java.sql.Statement\"%>\n"
                + "<%@page import=\"java.sql.ResultSet\"%>\n"
                + "<%@page import=\"com.conexion.ConexionDBS\"%>\n"
                + "<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>";
    }

    public static String testConexionDBS() {
        return "<%\n"
                + "    Connection conexion = null;\n"
                + "    try {\n"
                + "        // Intenta establecer la conexión\n"
                + "        conexion = ConexionDBS.Conectar();\n"
                + "        out.println(\"<p>Conexión exitosa.</p>\");\n"
                + "\n"
                + "        // Aquí puedes realizar operaciones con la base de datos, si es necesario\n"
                + "\n"
                + "    } catch (ClassNotFoundException | SQLException e) {\n"
                + "        // Maneja cualquier excepción\n"
                + "        out.println(\"<p>Error de conexión: \" + e.getMessage() + \"</p>\");\n"
                + "    } finally {\n"
                + "        // Cierra la conexión al finalizar\n"
                + "        if (conexion != null) {\n"
                + "            try {\n"
                + "                conexion.close();\n"
                + "            } catch (SQLException e) {\n"
                + "                out.println(\"<p>Error al cerrar la conexión: \" + e.getMessage() + \"</p>\");\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "%>";
    }

}
