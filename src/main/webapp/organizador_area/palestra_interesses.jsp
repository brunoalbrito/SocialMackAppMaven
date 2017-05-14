<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_organizador.jsp"/>

<div class="bg-faded p-4 my-4">
    <div class="col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2 center">


        <c:if test="${error_message != null}">
        <div class="alert alert-danger alert-dismissable">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>ERRO!</strong> ${error_message}
        </div>
    </c:if>
    

    <div class="panel panel-default">
        <div class="panel-heading">
            <center>
                <h2>
                    Interesses da Palestra "${palestra_pendente.tema}"
                </h2>
            </center>
        </div>
        <br>
        <div class="panel-body">

            <form class="form-inline" method="post" action="${pageContext.request.contextPath}/FrontController">
                <div class="col-lg-12">
                    <div class="input-group" style="margin-bottom: 3em; ">
                        <input type="text" class="form-control"  title="Interesse" placeholder="Interesse" required="required" name="novo_interesse">
                        <input type="submit" style="margin-left: 1em;" value="Adicionar" title="Adicionar interesse..." class="btn btn-primary center-block">
                    </div>
                    <input type="hidden" name="ctrl" value="AddInteresse">                            
                </div>
            </form>

            <form method="POST" action="${pageContext.request.contextPath}/FrontController">

                <c:forEach items="${interesses}" var="i">
                    <div class="col-md-12 input-group" style="margin-bottom: 1em;">
                         <span class="input-group-addon">
                        <input type="checkbox" aria-label="..." name="interesse" value="${i.id}">
                         </span>
                         <input type="text" class="form-control" readonly="readonly" disabled="disabled" value="${i.descricao}" title="Interesse">
                        </div><!-- /input-group -->
                    <!-- /.col-lg-6 -->                      
                </c:forEach>      

            <center>
                <div class="col-md-6">
                    <input type="hidden" name="ctrl" value="RegistrarPalestra"/>
                    <input type="submit" class="btn btn-block btn-warning" value="SALVAR">     
                </div>                   
            </center>
        </form>
    </div>
</div>
</div>
</div>

<c:import url="../template/footer.jsp"/>