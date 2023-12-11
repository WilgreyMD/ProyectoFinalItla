/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.conexion;

import com.Productos.ProductosGenerales;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wilgrey-MD
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<ProductosGenerales> lista =  DBAcciones.ListarProductos();
        if(lista.isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
           for(ProductosGenerales pg: lista){
            System.out.println("ID " +pg.getId());
            System.out.println("Nombre " + pg.getNombre());
            System.out.println("Descripcion "+ pg.getDescripcion());
            System.out.println("Cantidad "+ pg.getStock());
            System.out.println("Imagen "+ pg.getUrlImagen());
            System.out.println("Pprecio "+ pg.getPrecio());
            
        } 
        }
        
    }
    
}
