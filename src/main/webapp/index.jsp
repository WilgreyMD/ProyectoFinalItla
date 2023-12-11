<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Utils.Componentes" %>
<%@page import="com.Utils.Sesion" %>

<%

    if (request.getParameter("txtUser") != null && request.getParameter("txtPassword") != null) {
        Sesion.iniciarSesion(request.getParameter("txtUser"), request.getParameter("txtPassword"));
    }

    if (Sesion.comprobarSesion()) { %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="CSS/normalize.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <link rel="stylesheet" href="CSS/itemsContenedores.css" />
        <link rel="stylesheet" href="CSS/EstilosGenerales.css" />
        <title>Inicio</title>
    </head>
    <body>
        <% out.println(Componentes.header()); %>
        <!---<header>

            <div class="logo">
                <h1><a href="index.jsp">Tienda Virtual</a></h1>
            </div>
            <div class="lupa">
                <input type="search" placeholder="Buscar en Tienda Virtual" />
                <button>Buscar</button>
            </div>
            <form> 
                <ul class="menu">
                    <li class="current-page"><a href="index.jsp">Inicio</a></li>
                    <li><a href="Carrito.jsp">Catalogo P</a></li>
                    <li><a href="usuario.jsp">Usuario</a></li>
                    <li><a href="CarritoCompra?accion=Carrito">Carrito A</a></li>
                </ul>
            </form>
        </header>-->

        <% ArrayList<String> fotosUrl = new ArrayList<>();
fotosUrl.add("https://www.zonanegativa.com/imagenes/2019/07/ASM201828_RamosVar.jpg");
fotosUrl.add("https://www.geekmi.news/export/sites/debate/img/2022/07/22/batman.png_1985637752.png ");
fotosUrl.add("https://www.savepoint.do/cdn/shop/products/PLAYSTATION5_1024x1024.jpg?v=1607207604");
fotosUrl.add("https://www.ubuy.do/productimg/?image=aHR0cHM6Ly9pNS53YWxtYXJ0aW1hZ2VzLmNvbS9zZW8vWGJveC1TZXJpZXMtWC1WaWRlby1HYW1lLUNvbnNvbGUtQmxhY2tfOWY4YzA2ZjUtNzk1My00MjZkLTliNjgtYWI5MTQ4MzljZWY0LjVmMTViZTQzMDgwMGNlNGQ3YzNiYjU2OTRkNGFiNzk4LmpwZWc.jpg");
fotosUrl.add("https://locosphone.com/wp-content/uploads/2023/03/51l2sun2aOL.jpg");
fotosUrl.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1675201006-steam-deck-1-1675199434.jpg?crop=0.944xw:0.944xh;0.0120xw,0.00800xh&resize=980:*");
fotosUrl.add("https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/71rNy46qL9L.jpg");
fotosUrl.add("https://images.thdstatic.com/productImages/a62b4338-d21f-4e9f-af99-9b786e2441c5/svn/dove-hand-soaps-uni61073ct-64_600.jpg");
fotosUrl.add("https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81OQHXYinzL._AC_UF1000,1000_QL80_.jpg");
fotosUrl.add("https://farmazara.es/1985-home_default/la-roche-posay-effaclar-mat-40-ml.jpg");
fotosUrl.add("https://cdn.outsideonline.com/wp-content/uploads/2022/09/AIRPODS_PRO2_s.jpg");
fotosUrl.add("https://cdn.outsideonline.com/wp-content/uploads/2022/09/AIRPODS_PRO2_s.jpg");
fotosUrl.add("https://mac-center.com.do/cdn/shop/files/iPhone_14_Pro_Max_Space_Black_PDP_Image_Position-1a_COES_823x.jpg?v=1684522517");

        %>

        <main id="main-inicio">
            <article class="banner">
                <div class="caja-texto">
                    <h2>Ofertas de Navidad</h2>
                    <p>Se participe de nuestras ofertas en Productos Navideños</p>
                    <p>este invierno en la <span>Tienda Virtual</span>.</p>
                    <a href="Carrito.jsp"><button>Ver Catalogo</button></a>
                </div>
                <image src="IMAGENES/canasta.jpg" alt="una cesta con productos" />
            </article>

            <section class="ofertas">
                <h3>Ofertas de Navidad</h3>
                <div class="contenedor-cajas">
                    <div class="cajas">
                        <p><strong>Canasta Surtida</strong></p>
                        <img src="https://i.pinimg.com/736x/a8/80/50/a88050dec871f135bed331faee64a79f.jpg" alt="foto del producto" />
                    </div>

                    <div class="cajas">
                        <p><strong>Dulces Navideños</strong></p>
                        <img src="https://previews.123rf.com/images/petro/petro1710/petro171000029/87964700-una-variedad-de-dulces-navide%C3%B1os-durante-la-venta.jpg" alt="foto del producto" />
                    </div>
                    <div class="cajas">
                        <p><strong>Bebidas Celebrativas</strong></p>
                        <img src="https://mmedia.eluniversal.com/18624/ponche-crema-65642.jpg" alt="foto del producto" />
                    </div>
                </div>
            </section>

            <div class="items-lista-contenedor">
                <h3>Items que te podrian gustar</h3>

                <ul class="items-lista">

                    <% for (String url : fotosUrl) {

                    %>

                    <li><img src="<%= url%>" alt="" /></li>


                    <%
                        }
                    %>

                </ul>
            </div>
        </main>

        <footer class="footer">
            <p>©2023-Tienda Virtual || Todos los derechos reservados</p>
        </footer>
    </body>
</html>

<% } else
        response.sendRedirect("login");%>