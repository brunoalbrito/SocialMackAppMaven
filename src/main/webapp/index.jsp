<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header_pre_login.jsp"/>

<div class="bg-faded p-4 my-4">

	<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4 center">
		<div class="panel panel-default ">
			<div class="panel-heading">
				<h2 class="text-center text-lg text-uppercase my-0"><strong>LOGIN</strong></h2>
			</div>
			<br>
			<div class="panel-body">
				<form method="POST" action="FrontController">
					
					
					<input type="text" title="Digite o email." name="email" placeholder="Email" required="required" class="form-control input-lg">
					
					<br/>
					<input type="password" title="Digite a senha." name="senha" placeholder="Senha" required="required" class="form-control input-lg">
					<br/>
					<input type="hidden" value="Login" name="ctrl">
					<center>
						<input type="submit" value="LOGAR" class="btn btn-warning btn-lg center-block">
					</center>
				</form>

			</div>
		</div>

	</div>
	
	<!-- Welcome Message -->
	<div class="text-center mt-4">
		<div class="text-heading text-muted text-lg">Bem vindo ao</div>
		<h1 class="my-2">Social Mack</h1>
		<div class="text-heading text-muted text-lg">Por <strong>Mackenzie</strong></div>
	</div>
</div>

<c:import url="template/footer.jsp"/>