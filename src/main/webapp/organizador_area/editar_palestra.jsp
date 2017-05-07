<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    EDITAR PALESTRA
                </div>
                    
                <%
                    String idPalestra = request.getParameter("idPalestra"); 
                    String tema = request.getParameter("tema"); 
                    String codigo = request.getParameter("codigo"); 
                %>

                <div class="panel-body">
                    <form method="POST" action="${pageContext.request.contextPath}/FrontController">
                        <!--/FrontController?ctrl=AlterarPalestra-->
                        <input type="text" value="${param.tema}" title="Digite o tema." name="tema" placeholder="${param.tema}" required="required" class="form-control input-lg">
                        <br/>
                        <input type="number" value="${param.codigo}" title="Digite o código." name="codigo" placeholder="${param.codigo}" required="required" class="form-control input-lg">
                        <br/>
                        
                        <input type="hidden" name="id_palestra" value="${param.idPalestra}"/>
                        
                        <input type="hidden" value="AlterarPalestra" name="ctrl">
                        
                        <inout type="submit" value="Alterar" class="btn btn-default btn-lg center-block">
                         
                    </form>   
                </div>
            </div>
        </div>
    </div>

<c:import url="../template/footer_post_login.jsp"/>
