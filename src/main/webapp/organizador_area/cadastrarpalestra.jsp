<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Palestra</title>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/FrontController">
            <p>
                <input type="text" id="tema" name="tema" placeholder="tema">
            </p>
            <p>
                <input type="text" id="codigo" name="codigo" placeholder="codigo">
            </p>
            <input type="hidden" name="ctrl" value="RegistrarPalestra"/>
            <p>
                <input type="submit" value="Registrar"/>
            </p>
        </form>
    </body>
</html>
