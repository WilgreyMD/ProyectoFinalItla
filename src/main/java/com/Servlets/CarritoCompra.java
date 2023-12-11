/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Servlets;

import com.Productos.ProductosGenerales;
import com.Utils.Carrito;
import com.conexion.DBAcciones;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarritoCompra", urlPatterns = {"/CarritoCompra"})
public class CarritoCompra extends HttpServlet {
    
    List<Carrito> listaCarrito = new ArrayList<>();
    int item ;
    double total = 0.0;
    int cantidad = 1;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        ArrayList<ProductosGenerales> listaProductos = DBAcciones.ListarProductos();
        ProductosGenerales p = new  ProductosGenerales();
        String accion = request.getParameter("accion");
        switch (accion) {
            case "AgregarCarrito":
                int idp= Integer.parseInt(request.getParameter("id"));
                p = DBAcciones.seleccionarProductoPorId(idp);
                item = item+1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setDescripcion(p.getDescripcion());
                car.setPrecio(p.getPrecio());
                car.setPrecio(cantidad);
                car.setTotal(cantidad * p.getPrecio());
                listaCarrito.add(car);
                request.getSession().setAttribute("Contador", listaCarrito.size());
                request.getRequestDispatcher("CarritoCompra?accion=Catalogo").forward(request, response);
                break;
            case "Carrito":
                 total =0.0;
                 request.setAttribute("carrito", listaCarrito);
                 request.getRequestDispatcher("Carritov2.jsp").forward(request, response);
                break;
            default:
                if (listaProductos != null) {
                    request.setAttribute("productos", listaProductos);
                }
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);

        }
        if (listaProductos != null) {
            request.setAttribute("productos", listaProductos);
        }
        request.getRequestDispatcher("Carrito.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<ProductosGenerales> listaProductos = DBAcciones.ListarProductos();
            request.setAttribute("productos", listaProductos);
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            // Manejar la excepción según sea necesario
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarritoCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CarritoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
