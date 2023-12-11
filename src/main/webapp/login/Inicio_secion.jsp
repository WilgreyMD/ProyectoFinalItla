
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="../CSS/EstilosGenerales.css"/>
        <link rel="stylesheet" href="../CSS/EstilosLogin.css">
        <title>Inicio De sesión</title>
    </head>
    <body>
        <main>
            <section class="login-header">
                <!--<h2>Inicio de sesión</h2>-->
            </sect>
            <section>
                <form action="../index.jsp">
                    <label for="txtUser">
                        <input type="text" name="txtUser" id="txtUser" class="Recipiente" placeholder="Nombre De Usuario" required>
                        <i class='bx bxs-user'></i>                   
                    </label>

                    <label for="txtPass">
                        <input type="password" name="txtPassword" id="txtPassword" class="Recipiente" placeholder="Inrgese Su contraseña" required>
                        <i class='bx bxs-lock-alt' ></i>
                    </label>

                    <label class="recordar-pass" for="recordar-pass">
                        <input type="checkbox" class="rmp" name="recordar-pass"> <p class="underline">Recordar tu contraseña ?</p>
                    </label>

                    <input class="bt" type="submit" placeholder="Login"/> 
                </form>
            </section>
            <section class="login-footer">
                <div class="crear-cuenta">
                    <p>Tu no tienes una cuenta? <a href="../Crear_cuenta.jsp" class="underline">Click aqui para crear una!!</a></p>
                </div>
            </section>
        </main>
    </body>
</html>
