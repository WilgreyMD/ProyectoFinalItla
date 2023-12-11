
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../CSS/EstilosGenerales_1.css"/>
        <link rel="stylesheet" href="../CSS/EstilosLogin_1.css">
        <title>Inicio De sesión</title>

    </head>
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
      <main class="form-signin w-100 m-auto">
        <form action="../">
          <h1 class="h3 mb-3 fw-normal titulo">Iniciar sesion</h1>
      
          <div class="form-floating">
            <input type="text" class="form-control" name="txtUser" id="txtUser" placeholder="userName">
            <label for="floatingInput">Nombre de usuario</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" name="txtPassword" id="txtPassword" placeholder="Password">
            <label for="floatingPassword">Contraseña</label>
          </div>
      
          <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
          <div class="crear-cuenta">
            <p>Tu no tienes una cuenta? <a href="../Crear_cuenta.jsp" class="underline">Click aqui para crear una!!</a></p>
        </div>
        </form>
      </main>
    </body>
</html>