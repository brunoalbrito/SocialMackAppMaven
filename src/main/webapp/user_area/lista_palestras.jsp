<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/template/header_post_login.jsp"/>

<div class="row">


    <c:forEach var="p" items="${palestras}">

        <div class="col-sm-12 col-md-4 col-lg-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Palestra 1
                </div>
                <div class="panel-body">             
                    <p>Tema da Palestra: teste</p>
                </div>
                <div class="panel-footer">
                    <a href='<c:url value="/FrontController?ctrl=Inscricao&id_palestra=${p.id_palestra}&codigo=${p.codigo}&tema=${p.tema}"></c:url>' class="btn btn-default btn-lg center-block">
                            Inscrever-se
                        </a>   
                    <a href='<c:url value="/FrontController?ctrl=CancelInscricao&id_palestra=${p.id_palestra}"></c:url>' class="btn btn-default btn-lg center-block">
                            Cancelar Inscricao
                        </a> 
                    </div>
                </div>
            </div>

    </c:forEach>


</div>

<c:import url="../template/footer_post_login.jsp"/>
