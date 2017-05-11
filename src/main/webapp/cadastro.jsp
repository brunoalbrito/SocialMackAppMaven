<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="<c:url="template/header_pre_login.jsp"/>"/>

<div class="bg-faded p-4 my-4">
    <hr class="divider">
    <h2 class="text-center text-lg text-uppercase my-0">Cadastro <strong>SocialMack</strong></h2>
    <hr class="divider">
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4 center">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/FrontController" method="post">
                        <input type="text" name="name" title="Digite seu nome." placeholder="Nome" required="required" class="form-control input-lg">
                        <br/>
                        <input type="email" name="email" title="Digite o endereço de e-mail." placeholder="E-mail" required="required" class="form-control input-lg">
                        <br/>
                        <input type="hidden" value="Cadastro" name="ctrl">
                        <center>
                            <input type="submit" value="CADASTRAR" class="btn btn-warning btn-lg center-block">
                        </center>
                    </form>

                </div>
            </div>
        </div>

    </div>
</div>


<!-- /.container -->

<c:import url="../template/footer.jsp"/>