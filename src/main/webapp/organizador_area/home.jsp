<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_organizador.jsp"/>

<div class="bg-faded p-4 my-4">

    <center>
        <h2>Bem-vindo, organizador </h2>     

        <img src="../img/mackenzie.png">
        <br>

        <a href="cadastro_palestra.html" class="btn btn-warning">Criar palestra</a>

        <a href="lista_palestras.html" class="btn btn-warning">Listar palestras</a>

    </center>

</div>

<c:import url="../template/footer.jsp"/>