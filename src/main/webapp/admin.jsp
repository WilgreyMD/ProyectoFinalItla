<%-- 
    Document   : admin
    Created on : 9 dic 2023, 8:15:13 a. m.
    Author     : wilgrey-MD
--%>
<%@page import="com.Utils.BootstrapIMP"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BootstrapIMP bootsIMP = new BootstrapIMP();
%>
<html>
    <head>
        <%= bootsIMP.linkBoost()%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= bootsIMP.navbarBoostAdmin()  %>
       
</body>
</html>
