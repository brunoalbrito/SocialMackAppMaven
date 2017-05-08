<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>
<div class="row">

    <c:forEach var="i" items="${participantes}">
                <p>Participante => <c:out value="${i.nome}"></c:out><p>
        </c:forEach>

</div>

<c:import url="../template/footer_post_login.jsp"/>
