/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Servlets;

import com.Utils.Usuarios;
import com.conexion.DBAcciones;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AccionUsuarios", urlPatterns = {"/AccionUsuarios"})
public class AccionUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String idString = request.getParameter("btnSeleccion");
        int id = parseOrDefault(idString, 0);

        ArrayList<Usuarios> usuarios;
        Usuarios usuario = null;
        try {
            usuarios = DBAcciones.ListarUsuarios();
            for (Usuarios pg : usuarios) {
                if (pg.getId() == id) {
                    usuario = pg;
                    break;
                }
            }

            if (usuario != null) {
                // Setear los atributos solo si el producto no es nulo
                request.setAttribute("ID", usuario.getId());
                request.setAttribute("Nombre", usuario.getNomrbe());
                request.setAttribute("Gmail", usuario.getCorreo());
                request.setAttribute("Pass", usuario.getPass());
                request.setAttribute("Acceso", usuario.getAcceso());

                RequestDispatcher dispatcher = request.getRequestDispatcher("AdministracionDeUsuarios.jsp");
                dispatcher.forward(request, response);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("AdministracionDeUsuarios.jsp");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String IDStr = request.getParameter("ID");
        int ID = parseOrDefault(IDStr, 0);

        String Nombre = request.getParameter("Nombre");
        String Gmail = request.getParameter("Gmail");
        String Pass = request.getParameter("Pass");
        String AccesoString = request.getParameter("Acceso");
        short Acceso = parseOrDefaultS(AccesoString, 0);

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Agrega":
                try {
                    DBAcciones.agregarUsuarios(Nombre, Gmail, Pass, Acceso);
                } catch (ClassNotFoundException e) {
                }
            break;

            case "Actualizar":
            
                try {
                     DBAcciones.actualizarUsuario(ID, Nombre, Gmail, Pass, Acceso);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

            break;

            case "Eliminar": {
                try {
                    DBAcciones.eliminarUsuario(ID);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            default:
                throw new AssertionError();
        }
        response.sendRedirect("AdministracionDeUsuarios.jsp");

    }

    private int parseOrDefault(String value, int defaultValue) {
        try {
            return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private short parseOrDefaultS(String value, int defaultValue) {
        try {
            return (short) ((value != null && !value.isEmpty()) ? Short.parseShort(value) : defaultValue);
        } catch (NumberFormatException e) {
            return (short) defaultValue;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
