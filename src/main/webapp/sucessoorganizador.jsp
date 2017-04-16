<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo organizador</title>
    </head>
    <body>
        ${organizador}
        ${organizador.id_pessoa}
        <h1>Olá organizador</h1>
        <a href="cadastrarpalestra.jsp"><button type="hidden" name="ctrl" value="Cadastrar Palestra"/>Cadastrar Palestra</a>
    </body>
</html>
