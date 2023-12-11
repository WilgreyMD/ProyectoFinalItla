package com.Productos;

import com.conexion.ConexionDBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductosGenerales {

    private int id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private double precio;
    private int stock;
    private boolean disponible;
    private short disponibleInt;
    ConexionDBS conexionProductos = new ConexionDBS();

    public ProductosGenerales() {
    }
    
    public ProductosGenerales(int id, String nombre, String descripcion, String urlImagen, double precio, int stock, short disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.stock = stock;
        this.disponibleInt = disponible;

        this.disponible = this.disponibleInt == 1;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isDisponible() {

        if (getStock() == 0) {
            setDisponible(false);
        }

        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public short getDisponibleInt() {
        return disponibleInt;
    }

    public void setDisponibleInt(short disponibleInt) {
        this.disponibleInt = disponibleInt;
    }

    public void restar(int cantidad) {

        if (isDisponible()) {
            String sql = "UPDATE `inventario_Productos`\n"
                    + "SET `stock` = `stock` - " + cantidad + "\n"
                    + "WHERE `Nombre` = '" + getNombre() + "';";
            try {
                Connection cn = conexionProductos.Conectar();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }

        }

    }

    public void venta(int cantidad) {
        setStock(getStock() - cantidad);
        restar(cantidad);

    }

    public String subirProducto() throws ClassNotFoundException {
        ConexionDBS cone = new ConexionDBS();
        try {
            try (Connection cn = cone.Conectar()) {
                if (cn != null) {
                    String sql = "INSERT INTO `producto`( `nom_producto`, `descripcion`, `precio`, `imagen`, `disponible`) VALUES (?,?,?,?)";
                    try (PreparedStatement prepareStatement = cn.prepareStatement(sql)) {
                        prepareStatement.setString(1, getNombre());
                        prepareStatement.setString(2, getDescripcion());
                        prepareStatement.setDouble(3, getPrecio());
                        prepareStatement.setString(4, getUrlImagen());
                        prepareStatement.setShort(5, getDisponibleInt());

                        int filasAfectadas = prepareStatement.executeUpdate();

                        if (filasAfectadas > 0) {
                            return "Producto agregado";
                        } else {
                            return "Error. El producto no fue agregado";
                        }

                    } catch (SQLException ex) {

                    }
                } else {

                    System.out.println("Error 178");

                }

            }
        } catch (SQLException e) {
            return e.toString();

        }
        return null;

    }

}
