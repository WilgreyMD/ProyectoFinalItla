
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Utils.Componentes"%>
<%@page import="com.Utils.Sesion"%>
<%@page import="com.Utils.BootstrapIMP"%>


<%  if (Sesion.comprobarSesion()) {%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <% 
        BootstrapIMP boosIMP = new BootstrapIMP();
    %>
    <%= boosIMP.linkBoost() %>
    <link rel="stylesheet" href="CSS/normalize.css" />
    <link rel="stylesheet" href="CSS/style.css" />
    <link rel="stylesheet" href="CSS/itemsContenedores.css" />
    <link rel="stylesheet" href="CSS/EstilosGenerales.css" />
    <title>Document</title>
</head>
<body>
    <% out.println(Componentes.header("Catalogo")); %>
    <main>
        <section class="productos">
            
        </section>
    </main>
</body>
</html>
<% } else response.sendRedirect("login"); %>