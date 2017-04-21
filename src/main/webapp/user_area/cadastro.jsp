<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../template/header_pre_login.jsp"/>

<div class="row">
    <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                CADASTRO
            </div>
            <div class="panel-body">
                <form action="FrontController" method="post">
                    <input type="text" name="name" title="Digite seu nome." placeholder="Nome" required="required" class="form-control input-lg">
                    <br/>
                    <input type="email" name="email" title="Digite o endereço de e-mail." placeholder="E-mail" required="required" class="form-control input-lg">
                    <br/>
                    <input type="hidden" value="Cadastro" name="ctrl">
                    <input type="submit" value="CADASTRAR" class="btn btn-default btn-lg center-block">
                </form>
                
                <br/>
                
                <a style="text-align: center;" href="index.jsp" role="button"><h4>Login</h4></a>
                
            </div>
        </div>
    </div>
</div>

<c:import url="template/footer_post_login.jsp"/>