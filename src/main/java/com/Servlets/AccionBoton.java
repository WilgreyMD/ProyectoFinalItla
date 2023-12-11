package com.Servlets;

import com.Productos.ProductosGenerales;
import com.Utils.BootstrapIMP;
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

@WebServlet(name = "AccionBoton", urlPatterns = {"/AccionBoton"})
public class AccionBoton extends HttpServlet {

    BootstrapIMP bossIMP = new BootstrapIMP();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

@Override
    @SuppressWarnings("null")
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String idString = request.getParameter("btnSeleccion");
    int id = parseOrDefault(idString, 0);
    
    ArrayList<ProductosGenerales> productos;
    ProductosGenerales producto = null;
    try {
        productos = DBAcciones.ListarProductos();
        for (ProductosGenerales pg : productos) {
            if (pg.getId() == id) {
                producto = pg;
                break;
            }
        }

        
        if (producto != null) {
            // Setear los atributos solo si el producto no es nulo
            request.setAttribute("ID", producto.getId());
            request.setAttribute("Nombre", producto.getNombre());
            request.setAttribute("Descripcion", producto.getDescripcion());
            request.setAttribute("Cantidad", producto.getStock());
            request.setAttribute("Precio", producto.getPrecio());
            request.setAttribute("imagen", producto.getUrlImagen());
            request.setAttribute("Disponible", producto.isDisponible());            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Productos.jsp");
            dispatcher.forward(request, response);
        }

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Productos.jsp");
        dispatcher.forward(request, response);

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String idString = request.getParameter("btnSeleccion");
            int id = parseOrDefault(idString, 0);
        ArrayList<ProductosGenerales> productos;  
        ProductosGenerales producto = null;
        try {
            
            productos = DBAcciones.ListarProductos();
            for(ProductosGenerales pg : productos){
                if (pg.getId() == id){
                    producto = pg;
                    break;
                }  
            }
            
            HttpSession misession = request.getSession();
            misession.setAttribute("Producto", producto);
            response.sendRedirect("Productos.jsp");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String IDStr = request.getParameter("ID");
        int ID = parseOrDefault(IDStr, 0);

        String Nombre = request.getParameter("Nombre");

        String Descripcion = request.getParameter("Descripcion");

        String PrecioStr = request.getParameter("Precio");
        double Precio = parseOrDefaultDouble(PrecioStr, 0.0);

        String cantidadParam = request.getParameter("Cantidad");
        int Cantidad = parseOrDefault(cantidadParam, 1);

        String UrlImagen = request.getParameter("imagen");

        String disponibleStr = request.getParameter("Disponible");

        boolean Disponible = parseOrDefault(disponibleStr, true);

        Short disponibleShort;
        if (!Disponible){
            disponibleShort = 0;
        }
        disponibleShort = 1;
        
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Agregar":
            {
                try {
                    DBAcciones.agregarProducto(Nombre,Descripcion,Precio,Cantidad,UrlImagen,disponibleShort);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "Actualizar":
            {
                try {
                    DBAcciones.actualizarProducto(ID, Nombre,Descripcion,Precio,Cantidad,UrlImagen,disponibleShort);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                break;

            case "Eliminar":
            {
                try {
                    DBAcciones.eliminarProducto(ID);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccionBoton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            default:
                throw new AssertionError();
        }
        response.sendRedirect("Productos.jsp");

    }

    private int parseOrDefault(String value, int defaultValue) {
        try {
            return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private boolean parseOrDefault(String value, boolean valor) {

        try {
            return (value != null && !value.isEmpty()) ? Boolean.parseBoolean(value) : valor;

        } catch (Exception e) {
            return valor;

        }
    }

    private double parseOrDefaultDouble(String value, double defaultValue) {
        try {
            return (value != null && !value.isEmpty()) ? Double.parseDouble(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
