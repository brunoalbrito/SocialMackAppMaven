<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todas Palestras</title>
    </head>
    <body>
        <c:forEach var="i" items="${palestras}">
            <a href="FrontController?ctrl=RegistrarPalestra&idPalestra=${i.id_palestra}">
                <c:out value="${i}"></c:out>
            </a>
        </c:forEach>
    </body>
</html>
