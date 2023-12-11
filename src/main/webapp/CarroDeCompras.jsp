<%@page import="java.util.List"%>
<%@page import="com.Utils.Carrito"%>
<%@page import="com.Utils.Componentes" %>
<%@page import="com.Utils.BootstrapIMP"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (Sesion.comprobarSesion()) { %>
<!DOCTYPE html>
<html>
    <%
        BootstrapIMP boosIMP = new BootstrapIMP();
    %>
    <head>
        <%= boosIMP.linkBoost()%>
        <link rel="stylesheet" href="CSS/normalize.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <link rel="stylesheet" href="CSS/itemsContenedores.css" />
        <link rel="stylesheet" href="CSS/EstilosGenerales.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.println(Componentes.header()); %>
        <!-- <header>
            <div class="logo">
                <h1><a href="index.jsp">Tienda Virtual</a></h1>
            </div>
            <div class="lupa">
                <input type="search" placeholder="Buscar en Tienda Virtual" />
                <button>Buscar</button>
            </div>
            <ul class="menu">
                <li class="current-page"><a href="index.jsp">Inicio</a></li>
                <li><a href="CarritoCompra?accion=home">Catalogo P</a></li>
                <li><a href="usuario.jsp">Usuario</a></li>
                <li><a href="CarroDeCompras.jsp">Carrito A</a></li>
            </ul>
        </header> -->
        
       
        
        <div class="container mt-4">
            <div class="row">
               
                
                <div class="col-sm-8">
                    <table border="1" class="table table-success table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cant</th>
                                <th>SubTotal</th>
                                <th>Action</th>
                                
                            </tr>
                        </thead>
          <form action="CarritoCompra" method="post">
        <%
            
            List<Carrito> listaCarrito = (List<Carrito>) request.getAttribute("carro");
            if (listaCarrito != null) {
            out.print("Tiene algo dentro...");
                for (Carrito car : listaCarrito) {
            %>
                        <tbody>
                            <tr>
                                <td><%= car.getItem()%></td>
                                <td><%= car.getNombreP() %></td>
                                <td><%= car.getDescripcion()%> </td>
                                <td><%= car.getPrecio()%></td>
                                <td><%= car.getCantidad()%></td>
                                <td><%= car.getTotal()%></td>
                                
                                <td>xd</td>
                            </tr>
                        </tbody>
                       <% 
                           }
                           }else{
                            out.print("Estoy vacio");
                        }
                             %>
                    </table>
                    
                </div>
                    <div class="col-sm-4">
                <div class="card">
                     <div class="card-header">
                            <h4>Generar Compra</h4>
                        </div>
                        <div class="card-body">
                            <label>text</label>
                            <input type="text" readonly="" class="form-control">
                            <label>text</label>
                            <input type="text" readonly="" class="form-control">
                            <label>text</label>
                            <input type="text" readonly="" class="form-control">
                            <label>text</label>
                            <input type="text" readonly="" class="form-control">
                        </div>
                        <div class="card-footer text-center">
                            <label><p></p></label>
                            <a class="btn btn-outline-info btn-block" href="#">Realizar Pago</a>
                            <a class="btn btn-danger btn-block" href="#">Generar Compra</a>
                        </div>
                </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>

<% } else
        response.sendRedirect("login");%>
