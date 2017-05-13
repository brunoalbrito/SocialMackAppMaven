<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_pos_login_organizador.jsp"/>

<div class="bg-faded p-4 my-4">
    <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4 center">
        <div class="panel panel-default">
            <hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0">Registrar <strong>Palestra</strong></h2>
            <hr class="divider">
            <br>
            <div class="panel-body">
                <form method="POST" action="${pageContext.request.contextPath}/FrontController">
                
                    <input type="text" title="Digite o tema." name="tema" placeholder="Tema" required="required" class="form-control input-lg">
                    <br/>
                    <input type="number" title="Digite o código." name="codigo" placeholder="Código" required="required" class="form-control input-lg">
                    <br/>
                    <input type="hidden" value="ValidaRegistro" name="ctrl">
                    <center><input type="submit" value="PRÓXIMO" class="btn btn-warning center-block"></center>

                </form>   
            </div>
        </div>
    </div>

</div>

<c:import url="../template/footer.jsp"/>