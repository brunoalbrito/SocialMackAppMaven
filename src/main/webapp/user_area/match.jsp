<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Match</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var="i" items="${participantes}">
            <c:out value="${i.nome}"/> --- <c:out value="${i.curso}"/> --- <c:out value="${i.celular}"/></br>
        </c:forEach>
    </body>
</html>
