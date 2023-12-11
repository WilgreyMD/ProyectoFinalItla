<%@page import="com.Utils.Usuarios"%>
<%

String userName = request.getParameter("User");
String email = request.getParameter("Email");
String password = request.getParameter("Password");

String comprobar = Usuarios.comprobarUsuarios(userName, email);

if (!comprobar.isEmpty()) {
    String mensaje = "<div class='error'><h5>" + comprobar + "</h5></div>";
    response.sendRedirect("Crear_cuenta.jsp?mensaje=" + mensaje);

} else {
    Usuarios.agregarUsuarios(userName, password, email);
    response.sendRedirect("login/");
}%>