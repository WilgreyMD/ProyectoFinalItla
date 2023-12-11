<%@page import="com.Utils.Sesion"%>
<%
    Sesion.cerrarSesion();
    response.sendRedirect("../");
%>