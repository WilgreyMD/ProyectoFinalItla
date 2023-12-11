<%-- 
    Document   : Carrito
    Created on : 10 dic 2023, 6:05:44 p. m.
    Author     : wilgrey-MD
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Productos.ProductosGenerales"%>
<%@page import="com.Utils.Componentes"%>
<%@page import="com.Utils.BootstrapIMP"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%BootstrapIMP boosIMP = new BootstrapIMP();%>
        <%= boosIMP.linkBoost()%>

        <link rel="stylesheet" href="CSS/normalize.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <link rel="stylesheet" href="CSS/itemsContenedores.css" />
        <link rel="stylesheet" href="CSS/EstilosGenerales.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.println(Componentes.header()); %>
        <div class="container mt-2">
            <div class="row">

                <%
                    ArrayList< ProductosGenerales> listaProductos = (ArrayList<ProductosGenerales>) request.getAttribute("productos");
                    if (listaProductos != null) {
                        for (ProductosGenerales pg : listaProductos) {
                %>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h4><%= pg.getNombre()%></h4>
                        </div>
                        <div class="card-body">
                            <p><%= pg.getPrecio()%></p>
                            <img src="<%= pg.getUrlImagen()%>" alt="Imagen del producto" width="200" height="180"/>
                        </div>
                        <div class="card-footer text-center">
                            <label><p><%= pg.getDescripcion()%></p></label>
                            <a class="btn btn-outline-info" href="CarritoCompra?accion=AgregarCarrito&id<%= pg.getId()%>">Agregar al carrito</a>
                            <a class="btn btn-danger" href="#">Comprar</a>
                        </div>
                    </div>
                </div>
                <%
                        }
                    } else {
                        out.println("No hay productos disponibles.");
                    }
                %>

            </div>

        </div>

    </body>
</html>
