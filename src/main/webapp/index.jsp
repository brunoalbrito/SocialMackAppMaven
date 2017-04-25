<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header_pre_login.jsp"/>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
        <div class="panel panel-default">
        <h1>Teste</h1>
        <h1>Teste 2</h1>
            <div class="panel-heading">
                LOGIN
            </div>
            <div class="panel-body">
                <form method="POST" action="FrontController">
                    <input type="text" title="Digite o email." name="email" placeholder="Email" required="required" class="form-control input-lg">
                    <br/>
                    <input type="password" title="Digite a senha." name="senha" placeholder="Senha" required="required" class="form-control input-lg">
                    <br/>
                    <input type="hidden" value="Login" name="ctrl">
                    <input type="submit" value="LOGAR" class="btn btn-default btn-lg center-block">
                </form>

                <br/>

                <a style="text-align: center;" href="user_area/cadastro.jsp" role="button"><h4>Cadastre-se</h4></a>

            </div>
        </div>
    </div>
</div>

<c:import url="template/footer_pre_login.jsp"/>