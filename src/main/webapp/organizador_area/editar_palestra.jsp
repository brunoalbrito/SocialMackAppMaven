<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Palestra</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/FrontController" method="POST" enctype="multipart/form-data">
            <p>
                <label for="id">id:</label><br>
                <input type="text" id="id" name="id" value="${p.id_palestra}" readonly/>
            </p>
            <p>
                <label for="tema">Tema</label><br>
                <input type="text" id="tema" name="tema" value="${p.tema}"/>
            </p>

            <p>
                <label for="codigo">Codigo:</label><br>
                <input type="codigo" id="codigo" name="codigo" value="${p.codigo}"/>
            </p>

            <input type="hidden" name="ctrl" value="AlterarPalestra"/>
            <p>
                <input type="submit" value="Alterar"/>
            </p>
        </form>
    </body>
</html>