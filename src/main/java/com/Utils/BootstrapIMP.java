package com.Utils;

public class BootstrapIMP {

    public String linkBoost() {

        return "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\n";

    }

    public String alertBoost(String mensaje) {
        return "<div class=\"alert alert-primary\" role=\"alert\">\n"
                + "\n"
                + "     " + mensaje + "\n"
                + "</div>";
    }

    public String navbarBoostAdmin() {
        return "<nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\n"
                + "            <div class=\"container-fluid\">\n"
                + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarTogglerDemo03\" aria-controls=\"navbarTogglerDemo03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                    <span class=\"navbar-toggler-icon\"></span>\n"
                + "                </button>\n"
                + "                <a class=\"navbar-brand\" href=\"admin.jsp\">Administracion</a>\n"
                + "                <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo03\">\n"
                + "                    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"catalogo.jsp\">Tienda</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"AdministracionDeUsuarios.jsp\">Usuarios</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"Productos.jsp\">Productos</a>\n"
                + "                        </li>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </nav>";
    }

    public String navBarBoost() {
        return " <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\n"
                + "            <div class=\"container-fluid\">\n"
                + "                <a class=\"navbar-brand\" href=\"#\">Navbar</a>\n"
                + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                    <span class=\"navbar-toggler-icon\"></span>\n"
                + "                </button>\n"
                + "                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link\" href=\"#\">Link</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item dropdown\">\n"
                + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
                + "                                Dropdown\n"
                + "                            </a>\n"
                + "                            <ul class=\"dropdown-menu\">\n"
                + "                                <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\n"
                + "                                <li><a class=\"dropdown-item\" href=\"#\">Another action</a></li>\n"
                + "                                <li><hr class=\"dropdown-divider\"></li>\n"
                + "                                <li><a class=\"dropdown-item\" href=\"#\">Something else here</a></li>\n"
                + "                            </ul>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link disabled\" aria-disabled=\"true\">Disabled</a>\n"
                + "                        </li>\n"
                + "                    </ul>\n"
                + "                    <form class=\"d-flex\" role=\"search\">\n"
                + "                        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n"
                + "                        <button class=\"btn btn-outline-success\" type=\"submit\">Busacar!</button>\n"
                + "                    </form>\n"
                + "                </div>";
    }

}
