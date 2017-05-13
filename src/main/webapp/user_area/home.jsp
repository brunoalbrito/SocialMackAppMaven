<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_participante.jsp"/>

<div class="bg-faded p-4 my-4">

    <center>
        <h2>Olá, <c:out value="${participante}"></c:out></h2>       

        <img src="../img/mackenzie.png">
        <br>

        <a href="${pageContext.request.contextPath}/FrontController?ctrl=ListarPalestra" class="btn btn-warning">Palestras</a>

        <a href="${pageContext.request.contextPath}/FrontController?ctrl=PalestraInscrito" class="btn btn-warning">Agenda</a>

        <a href="${pageContext.request.contextPath}/FrontController?ctrl=AlterarParticipante" class="btn btn-warning">Perfil</a>

    </center>

</div>
</div>

<c:import url="../template/footer.jsp"/>