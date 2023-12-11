package com.conexion;

import com.Productos.ProductosGenerales;
import com.Utils.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAcciones {

    public static ArrayList<ProductosGenerales> ListarProductos() throws ClassNotFoundException, SQLException {
        ArrayList<ProductosGenerales> listaProductos = new ArrayList<>();
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM producto");
                while (rs.next()) {

                    int id = rs.getInt("productolD");
                    String nombre = rs.getString("nom_producto");
                    String descripcion = rs.getString("descripcion");
                    double precio = rs.getDouble("precio");
                    int Cantidad = rs.getInt("Cantidad");
                    String imagen = rs.getString("imagen");
                    short disponible = rs.getShort("disponible");
                    listaProductos.add(new ProductosGenerales(id, nombre, descripcion, imagen, precio, Cantidad, disponible));

                }
            }
            return listaProductos;
        }
    }
    public static ProductosGenerales seleccionarProductoPorId(int ida) throws ClassNotFoundException, SQLException {
        ProductosGenerales Producto = new  ProductosGenerales();
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM producto where productolD = "+ida);
                while (rs.next()) {

                    Producto.setId(rs.getInt("productolD"));
                    Producto.setNombre(rs.getString("nom_producto"));
                    Producto.setDescripcion(rs.getString("descripcion"));
                    Producto.setPrecio(rs.getDouble("precio"));
                    Producto.setStock(rs.getInt("Cantidad"));
                    Producto.setUrlImagen(rs.getString("imagen"));
                    Producto.setDisponibleInt(rs.getShort("disponible"));
                }
                return Producto;
            }
            
        }
        return null;
    }

    public static void agregarProducto(String Nombre, String descipcion, double precio, int cantidad, String imagen, short disponible) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "INSERT INTO `producto`( `nom_producto`, `descripcion`, `precio`, `Cantidad`, `imagen`, `disponible`) VALUES (?,?,?,?,?,?)";
                try (PreparedStatement prepareStatement = cn.prepareCall(sql)) {
                    prepareStatement.setString(1, Nombre);
                    prepareStatement.setString(2, descipcion);
                    prepareStatement.setDouble(3, precio);
                    prepareStatement.setInt(4, cantidad);
                    prepareStatement.setString(5, imagen);
                    prepareStatement.setShort(6, disponible);
                    prepareStatement.executeUpdate();
                }
            }
        }
    }

    public static void actualizarProducto(int id, String Nombre, String descripcion, double precio, int cantidad, String imagen, short disponible) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "UPDATE `producto` SET `nom_producto`=?, `descripcion`=?, `precio`=?, `Cantidad`=?, `imagen`=?, `disponible`=? WHERE `productolD` = ?";
                try (PreparedStatement prepareStatement = cn.prepareStatement(sql)) {
                    prepareStatement.setString(1, Nombre);
                    prepareStatement.setString(2, descripcion);
                    prepareStatement.setDouble(3, precio);
                    prepareStatement.setInt(4, cantidad);
                    prepareStatement.setString(5, imagen);
                    prepareStatement.setShort(6, disponible);
                    prepareStatement.setInt(7, id);

                    prepareStatement.executeUpdate();
                }
            }
        }
    }

    public static void eliminarProducto(int id) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "DELETE FROM `producto` WHERE productolD = ?";
                try (PreparedStatement prepareStatement = cn.prepareCall(sql)) {
                    prepareStatement.setInt(1, id);
                    prepareStatement.executeUpdate();
                }
            }
        }
    }

    public static ProductosGenerales obtenerProductoPorID(int idProducto) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "SELECT * FROM producto WHERE productolD = ?";
                try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, idProducto);
                    ResultSet rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        int id = rs.getInt("productolD");
                        String nombre = rs.getString("nom_producto");
                        String descripcion = rs.getString("descripcion");
                        double precio = rs.getDouble("precio");
                        int cantidad = rs.getInt("Cantidad");
                        String imagen = rs.getString("imagen");
                        short disponible = rs.getShort("disponible");
                        return new ProductosGenerales(id, nombre, descripcion, imagen, precio, cantidad, disponible);
                    }
                }
            }
        }

        // Si no se encuentra el producto, devuelve null
        return null;
    }
    //--------------------------------------------------------------------------------

    public static ArrayList<Usuarios> ListarUsuarios() throws ClassNotFoundException, SQLException {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM `clientes`");
                while (rs.next()) {

                    int id = rs.getInt("clientelD");
                    String nombre = rs.getString("name");
                    String pass = rs.getString("pass");
                    String CorreoElectronico = rs.getString("CorreoElectronico");
                    short acceso = rs.getShort("acceso");

                    listaUsuarios.add(new Usuarios(id, nombre, nombre, pass, acceso));

                }
            }
            return listaUsuarios;
        }
    }

    public static void agregarUsuarios(String Nombre, String Gmail, String pass, short acceso) throws ClassNotFoundException {

        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "INSERT INTO `clientes`(`name`, `pass`, `CorreoElectronico`, `acceso`) VALUES (?,?,?,?)";
                try (PreparedStatement prepareStatement = cn.prepareCall(sql)) {
                    
                    prepareStatement.setString(1, Nombre);
                    prepareStatement.setString(3, Gmail);
                    prepareStatement.setString(2, pass);
                    prepareStatement.setShort(4, acceso);

                    prepareStatement.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAcciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void actualizarUsuario(int id, String Nombre, String Gmail, String pass, short acceso) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "UPDATE `clientes` SET `name`=?,`pass`=?,`CorreoElectronico`=?,`acceso`=? WHERE  `clientelD` = ?";
                try (PreparedStatement prepareStatement = cn.prepareStatement(sql)) {
                    prepareStatement.setString(1, Nombre);
                    prepareStatement.setString(2, Gmail);
                    prepareStatement.setString(3, pass);
                    prepareStatement.setShort(4, acceso);
                    prepareStatement.setInt(5, id);

                    prepareStatement.executeUpdate();
                }
            }
        }
    }

    public static void eliminarUsuario(int id) throws ClassNotFoundException, SQLException {
        ConexionDBS cone = new ConexionDBS();
        try (Connection cn = cone.Conectar()) {
            if (cn != null) {
                String sql = "DELETE FROM `clientes` WHERE clientelD = ?";
                try (PreparedStatement prepareStatement = cn.prepareCall(sql)) {
                    prepareStatement.setInt(1, id);
                    prepareStatement.executeUpdate();
                }
            }
        }
    }

}
