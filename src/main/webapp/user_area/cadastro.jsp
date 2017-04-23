<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../template/header_pre_login.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="row">
    <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                CADASTRO
            </div>
            <div class="panel-body">
                <form action="${pageContext.request.contextPath}/FrontController" method="post">
                    <input type="text" name="name" title="Digite seu nome." placeholder="Nome" required="required" class="form-control input-lg">
                    <br/>
                    <input type="email" name="email" title="Digite o endereço de e-mail." placeholder="E-mail" required="required" class="form-control input-lg">
                    <br/>
                    <input type="hidden" value="Cadastro" name="ctrl">
                    <input type="submit" value="CADASTRAR" class="btn btn-default btn-lg center-block">
                </form>

                <br/>
            </div>
        </div>
    </div>
    </body>
</html>