<%@page import="com.conexion.DBAcciones"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Utils.Usuarios"%>
<%@page import="com.Utils.BootstrapIMP"%>

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
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <%= bootsIMP.navbarBoostAdmin()%>
        </nav>
        <main>
            <div class="izquierda">
                <form action="AccionUsuarios" method="POST">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">ID</span>
                        <input type="text" class="form-control" readonly aria-label="Sizing example input" value="<%= (request.getAttribute("ID") != null) ? request.getAttribute("ID") : ""%>" name="ID" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nombre</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Nombre") != null) ? request.getAttribute("Nombre") : ""%>" name="Nombre" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Gmail</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Gmail") != null) ? request.getAttribute("Gmail") : ""%>" name="Gmail" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Pass</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" input" value="<%= (request.getAttribute("Pass") != null) ? request.getAttribute("Pass") : ""%>" name="Cantidad" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nivel De Acceso</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" name="Acceso" input" value="<%= (request.getAttribute("Acceso") != null) ? request.getAttribute("Acceso") : ""%>" name="Acceso" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="botones">
                        <button type="submit" class="btn btn-primary" name="accion" value="Agrega">Agregar</button>
                        <button type="submit" class="btn btn-success" name="accion" value="Actualizar">Actualizar</button>
                        <button type="submit" class="btn btn-danger" name="accion" value="Eliminar" >Eliminar</button>
                    </div>
                </form>
            </div>
            <div class="derecha">
                <form action="AccionUsuarios" method="GET">
                    <table class="table table-success table-striped">
                        <!-- Encabezados de la tabla -->
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Contraseña</th>
                                <th scope="col">Nivel De acceso</th>
                            </tr>
                        </thead>
                        <tbody>                           
                            <% ArrayList<Usuarios> listaDeUsuarios = DBAcciones.ListarUsuarios();
                                for (Usuarios pg : listaDeUsuarios) {%>
                            <tr>
                                <th scope="row"><button value="<%=pg.getId()%>" class="btn btn-primary" type="submit" name="btnSeleccion"><%=pg.getId()%></button></th>
                                <td><%=pg.getNomrbe()%></td>
                                <td><%=pg.getCorreo()%></td>
                                <td><%=pg.getPass()%></td>
                                <td><%=pg.getAcceso()%></td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>                   
                </form>
            </div>
        </main>
    </body>
</html>
