
package com.Utils;


public class Carrito {
  private int item;  
  private int idProducto;  
  private String nombreP;  
  private String Descripcion;  
  private double precio;  
  
  private int cantidad;
  private double total; 

    public Carrito() {
    }

    public Carrito(int item, int idProducto, String nombreP, String Descripcion, double precio, int cantidad, double total) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombreP = nombreP;
        this.Descripcion = Descripcion;
        this.precio = precio;
        
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
  
}
