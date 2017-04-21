<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>
${participante}
<div class="row">

    <c:out value="${organizador}"></c:out>

    Página inicial do organizador

</div>

<c:import url="../template/footer_post_login.jsp"/>