<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_organizador.jsp"/>

<div class="bg-faded p-4 my-4">
    <center><h1>Palestras</h1></center>
 <c:forEach var="p" items="${palestras}">
 <center>
     <div class="col-md-4">
         <fieldset style="border: solid 1px; border-radius: 5px; padding: 1em;" >
             <legend>${p.tema}</legend>
             <hr>
             <p>Código: ${p.codigo}</p>
             <hr>
             <a href="<c:url value="/FrontController?ctrl=ListarUsuariosPalestra&idPalestra=${p.id_palestra}"/>" class="btn btn-primary center-block">
                Participantes
            </a>
            <a href="<c:url value="/organizador_area/editar_palestra.jsp?idPalestra=${p.id_palestra}&codigo=${p.codigo}&tema=${p.tema}"/>" class="btn btn-primary center-block">Editar</a> 
        </fieldset> 
    </div>
    <center>
        <br>

    </c:forEach>
</div>

<c:import url="../template/footer.jsp"/>