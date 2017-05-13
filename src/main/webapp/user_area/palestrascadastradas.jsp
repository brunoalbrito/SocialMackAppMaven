<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_participante.jsp"/>

<div class="bg-faded p-4 my-4">
    <center><h3>Palestras cadastradas</h3></center><br>
    <center>
        <ul class="list-group col-md-6 ">
            <c:forEach var="p" items="${palestras}">
            <li class="list-group-item"><a href="#" style="text-decoration: none; color: black">Palestra ${p.tema}</a></li>
            </c:forEach>
        </ul>
    </center>
</div>
        

<c:import url="../template/footer.jsp"/>