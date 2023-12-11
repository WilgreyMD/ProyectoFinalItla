<%-- 
    Document   : usuario
    Created on : Dec 9, 2023, 10:30:19 AM
    Author     : jemsw
--%>

<%@page import="com.Utils.Sesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Utils.Componentes" %>

<% if (Sesion.comprobarSesion()) { %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
              <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
      
    <link rel="stylesheet" href="CSS/normalize.css" />
    <link rel="stylesheet" href="CSS/styleUsuario.css" />
    <link rel="stylesheet" href="CSS/itemsContenedores.css" />
    <link rel="stylesheet" href="CSS/EstilosGenerales.css" />
    
    <title>Document</title>
  </head>
  <body>
      <% out.println(Componentes.header()); %>
    <main id="main-usuario">
      <div class="perfil-cuadrilla">
        <img src="IMAGENES/canasta.jpg" alt="foto de perfil" />
        <div>
          <h3>ADMIN</h3>
          <p>Anakin Skywalker</p>
          <p>Anakin@gmail.com</p>
        </div>
      </div>

      <section class="productos-comprados">
        <h2>Pedidos que ha hecho</h2>

        <div class="contenedor-cajas">
          <div class="cajas">
            <p><strong>Canasta Surtida</strong></p>
            <img src="IMAGENES/canasta.jpg" alt="foto del producto" />
          </div>

          <div class="cajas">
            <p><strong>Canasta Surtida</strong></p>
            <img src="IMAGENES/canasta.jpg" alt="foto del producto" />
          </div>
          <div class="cajas">
            <p><strong>Canasta Surtida</strong></p>
            <img src="IMAGENES/canasta.jpg" alt="foto del producto" />
          </div>
          <div class="cajas">
            <p><strong>Canasta Surtida</strong></p>
            <img src="IMAGENES/canasta.jpg" alt="foto del producto" />
          </div>
        </div>
      </section>
    </main>

    <footer class="footer">
      <p>©2023-Tienda Virtual || Todos los derechos reservados</p>
    </footer>
  </body>
</html>

<% } else
        response.sendRedirect("login");%>
