
<%@page import="com.Utils.BootstrapIMP"%>
<%@page import="com.conexion.DBAcciones"%>
<%@page import="com.Productos.ProductosGenerales"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        BootstrapIMP bootsIMP = new BootstrapIMP();
    %>
    <head>
        <%= bootsIMP.linkBoost()%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CssAdmin/ProductosCss.css"/>
        <title>Administracion De Productos</title>
    </head>
    <body >

        <nav>
            <%= bootsIMP.navbarBoostAdmin()%>
        </nav>
        <main>
            <div class="izquierda">
                <form action="AccionBoton" method="POST">
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">ID</span>
                        <input type="text" class="form-control" readonly aria-label="Sizing example input" value="<%= (request.getAttribute("ID") != null) ? request.getAttribute("ID") : "" %>" name="ID" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nombre</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Nombre") != null) ? request.getAttribute("Nombre") : "" %>" name="Nombre" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Descripcion</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Descripcion") != null) ? request.getAttribute("Descripcion") : "" %>" name="Descripcion" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Cantidad</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Cantidad") != null) ? request.getAttribute("Cantidad") : "" %>" name="Cantidad" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Precio Por Unidad</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" name="Precio" input" value="<%= (request.getAttribute("Precio") != null) ? request.getAttribute("Precio") : "" %>" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">URL Imagen</span>
                        <input type="text" class="form-control" aria-label="Sizing example input"  name="imagen" input" value="<%= (request.getAttribute("imagen") != null) ? request.getAttribute("imagen") : "" %>" aria-describedby="inputGroup-sizing-default">
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="Disponible" id="flexRadioDefault1" value="false">
                        <label class="form-check-label" for="flexRadioDefault1">
                            No disponible
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="Disponible" id="flexRadioDefault2" checked value="true">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Disponible
                        </label>
                    </div>

                    <div class="botones ">
                        <button type="submit" class="btn btn-primary" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" class="btn btn-success" name="accion" value="Actualizar">Actualizar</button>
                        <button type="submit" class="btn btn-danger" name="accion" value="Eliminar" >Eliminar</button>
                    </div>
                </form>


            </div>
            <div class="derecha">
                <form action="AccionBoton" method="GET">
                    <table class="table table-success table-striped">
                        <!-- Encabezados de la tabla -->
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Imagen</th>
                                <th scope="col">Disponible</th>

                            </tr>
                        </thead>
                        <tbody>
                            <!-- Filas de la tabla -->
                            <% ArrayList<ProductosGenerales> listaProductos = DBAcciones.ListarProductos();
                                for (ProductosGenerales pg : listaProductos) {%>
                            <tr>
                                <th scope="row"><button value="<%=pg.getId()%>" class="btn btn-primary" type="submit" name="btnSeleccion"><%=pg.getId()%></button></th>
                                <td><%=pg.getNombre()%></td>
                                <td><%=pg.getDescripcion()%></td>
                                <td><%=pg.getPrecio()%></td>
                                <td><%=pg.getStock()%></td>
                                <td><img class="img-thumbnail" src="<%=pg.getUrlImagen()%>" alt="<%=pg.getDescripcion()%>"/></td>
                                <td><%=pg.isDisponible()%></td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                    <!-- Botón Seleccionar fuera de la tabla -->
                </form>
            </div>
        </main>
    </body>
</html>
