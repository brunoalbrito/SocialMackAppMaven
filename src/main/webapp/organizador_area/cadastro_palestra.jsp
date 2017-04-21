<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    REGISTRO DE PALESTRA
                </div>
                <div class="panel-body">
                    <form method="POST" action="${pageContext.request.contextPath}/FrontController">
                        <input type="text" title="Digite o tema." name="tema" placeholder="Tema" required="required" class="form-control input-lg">
                        <br/>
                        <input type="number" title="Digite o código." name="codigo" placeholder="Código" required="required" class="form-control input-lg">
                        <br/>
                        <input type="hidden" value="ValidaRegistro" name="ctrl">
                        <input type="submit" value="PRÓXIMO" class="btn btn-default btn-lg center-block">
                    </for    
                </div>
            </div>
        </div>
    </div>

<c:import url="../template/footer_post_login.jsp"/>
