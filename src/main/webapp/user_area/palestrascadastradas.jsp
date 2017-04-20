<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login.jsp"/>
<div class="row">

    <c:forEach var="i" items="${palestras}">
            <a href="FrontController?ctrl=Inscricao&id_palestra=${i.id_palestra}">
                <c:out value="${i}"></c:out>
            </a>
        </c:forEach>

</div>

<c:import url="../template/footer_post_login.jsp"/>