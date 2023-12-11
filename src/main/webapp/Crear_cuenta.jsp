<di%-- 
    Document   : Crear_cuenta
    Created on : 3 dic 2023, 11:29:16?a. m.
    Author     : wilgrey-MD
--%>

<!DOCTYPE html>
<html lang="es-Do">
<head>
  
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="CSS/EstilosCrearCuenta.css">
    <link rel="stylesheet" href="CSS/normalize.css">
    <title>Crear Cuenta</title>
</head>
<body>
    <main>
        <form action="comprobacion.jsp">
            <div class="form-header">
                <h1>Crear cuenta</h1>
            </div>
            <div class="form-body">
                <div class="input-form textuse">
                    <input type="text" name="User" id="User" class="Recipiente" placeholder="Ingresa tu nombre de usuario" required>
                    <label for="User">
                        <i class='bx bxs-user'></i>                   
                    </label>
                </div>
    
                <div class="input-form gmailUser">
                    <input type="email" name="Email" id="Email" class="Recipiente" placeholder="Ingresa tu correo electrónico" required>
                    <label for="Email">
                        <i class='bx bx-envelope'></i>
                    </label>
                </div>
    
                <div class="input-form txtPass">
                    <input type="password" name="Password" id="Password" class="Recipiente" placeholder="Ingresa tu contraseña" required>
                    <label for="Password">
                        <i class='bx bxs-lock-alt'></i>
                    </label>
                </div>

                <%if (request.getParameter("mensaje") != null) {
                    out.println(request.getParameter("mensaje"));
                }%>
            </div>
            <div class="form-footer">
                <button class="btn-create" type="submit">Crear</button>
            </div>
        </form>
    </main>
</body>
</html>
