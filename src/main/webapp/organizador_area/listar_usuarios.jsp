<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_organizador.jsp"/>
<div class="bg-faded p-4 my-4">

    <c:forEach var="i" items="${participantes}">
        <p>Participante => <c:out value="${i.nome}"></c:out><p>
    </c:forEach>

</div>

<c:import url="../template/footer.jsp"/>
