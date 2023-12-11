/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Utils;

/**
 *
 * @author Manuel Jose
 */
public abstract class Componentes {


    public static String header () {

      String url = "/TiendaWeb/";

      String header =
      "<header>" +
        "<div class='logo'>" +
            "<h1><a href='" + url +"'>Tienda Virtual</a></h1>" +
        "</div>" +
        "<div class='lupa'>" +
          "<input type='search' placeholder='Buscar en Tienda Virtual' />" +
          "<button>Buscar</button>" +
        "</div>" +
        "<ul class='menu'>" +
          "<li class=\"current-page\"><a href='" + url +"'>Inicio</a></li>" +
          "<li><a href='" + url + "Carrito.jsp'>Carrito</a></li>" +
          "<li><a href='" + url + "CarritoCompra?accion=Carrito'>Catalogo</a></li>" +
              
          "<li class='nav-item dropdown'>" +
            "<a class='nav-link dropdown-toggle' href='#' role='button' data-bs-toggle='dropdown' aria-expanded='false'>Usuario</a>" +
            "<ul class='dropdown-menu'>" +
              "<li><a class='dropdown-item' href='" + url + "usuario.jsp'>Perfil</a></li>" +
              "<li>" +
                "<hr class='dropdown-divider'>" +
              "</li>" +
              "<li><a class='dropdown-item' href='" + url +"cerrar_sesion.jsp'>Cerrar sesión</a></li>" +
            "</ul>" +
          "</li>" +
        "</ul>" +
      "</header>";

     return header;
    }

    public static String menuTienda() {
        return "      <div class=\"logo\">\n"
                + "        <h1><a href=\"index.jsp\">Tienda Virtual</a></h1>\n"
                + "      </div>\n"
                + "      <div class=\"lupa\">\n"
                + "        <input type=\"search\" placeholder=\"Buscar en Tienda Virtual\" />\n"
                + "        <button>Buscar</button>\n"
                + "      </div>\n"
                + "      <ul class=\"menu\">\n"
                + "        <li class=\"current-page\"><a href=\"index.jsp\">Inicio</a></li>\n"
                + "        <li><a href=\"CarritoCompra?accion=Catalogo\">Catalogo</a></li>\n"
                + "        <li><a href=\"usuario.jsp\">Usuario</a></li>\n"
                + "        <li><a href=\"#\">(<label><%= session.getAttribute(\"Contador\") %></label>)Carrito</a></li>\n"
                + "      </ul>\n"
                + "    </header>";
    }
}
