<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/template/header_pos_login_organizador.jsp"/> 

<div class="row"> 
    <c:forEach items="${palestras}" var="p">     

        <div class="col-sm-12 col-md-4 col-lg-3"> 
            <div class="panel panel-default"> 
                <div class="panel-body">              
                    ${p.tema} 
                </div> 
                <div class="panel-footer">
                    <a href="<c:url value="/FrontController?ctrl=ListarUsuariosPalestra&idPalestra=${p.id_palestra}"/>" class="btn btn-default btn-lg center-block"> 
                        Listar Participantes 
                    </a>               
                </div> 
                <div class="panel-footer">
                    <a href="<c:url value="editar_palestra.jsp?idPalestra=${p.id_palestra}&tema=${p.tema}&codigo=${p.codigo}"/>" class="btn btn-default btn-lg center-block"> 
                        Alterar Palestra 
                    </a>               
                </div> 
                <div class="panel-footer">
                    <a href="<c:url value="/FrontController?ctrl=DeletarPalestra&idPalestra=${p.id_palestra}"/>" class="btn btn-default btn-lg center-block"> 
                        Deletar Palestra 
                    </a>              
                </div> 
            </div> 
        </div> 

    </c:forEach> 

    <!--PARTE PARA INCLUIR NOVA PALESTRA-->
    <div class="col-sm-12 col-md-4 col-lg-3"> 
        <div class="panel panel-default"> 
            <div class="panel-body">Add new Palestra</div>                 
        </div>
        <div class="panel-footer">
            <a href="<c:url value="cadastro_palestra.jsp"/>" class="btn btn-default btn-lg center-block"> 
                ADD NEW
            </a>               
        </div> 
    </div>

</div> 

<c:import url="../template/footer.jsp"/> 
