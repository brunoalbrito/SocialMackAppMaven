<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_participante.jsp"/>

<div class="bg-faded p-4 my-4">
   <c:forEach var="p" items="${palestras}">

        <div class="col-sm-12 col-md-4 col-lg-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Palestra ${p.tema}
                </div>
                <div class="panel-body">             
                    <p>Tema da Palestra: ${p.tema}</p>
                </div>
                <div class="panel-footer">
                    <a href='<c:url value="/FrontController?ctrl=InscricaoInteresses&id_palestra=${p.id_palestra}&tema=${p.tema}&codigo=${p.codigo}"></c:url>' class="btn btn-default btn-lg center-block">
                        Inscrever-se
                    </a>
                </div>
            </div>
        </div>

    </c:forEach>
</div>
<c:import url="../template/footer.jsp"/>