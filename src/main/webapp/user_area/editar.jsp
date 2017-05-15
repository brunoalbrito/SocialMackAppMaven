<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:import url="/template/header_pos_login_participante.jsp"/>
<center>
    	
    		<div class="bg-faded p-4 my-4">
			<hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0">Editar <strong>Perfil</strong></h2>
            <hr class="divider">
			
    		<form action="${pageContext.request.contextPath}/FrontController" method="POST">
                <p>
                    <label for="name">Nome:</label><br>
                    <input type="text" id="name" name="name" value="${participante.nome}" class=""/>
                </p>

            <p>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" disable="true" value="${participante.email}"/>
            </p>
                    <p>
                        <label for="senha">Senha:</label><br>
                        <input type="text" id="senha" name="senha" value="${participante.senha}/>
                    </p>

                    <p>
                        <label for="celular">Celular:</label><br>
                        <input type="text" id="celular" value= "${participante.celular}" name="celular"/>
                    </p>
                    <p>
                        <label for="formacao">Formacao:</label><br>
                        <input type="text" id="formacao" value="${participante.formacao}" name="formacao"/>
                    </p>
            <input type="hidden" name="idParticipante" value="${participante.id_pessoa}"/>
            <input type="hidden" name="ctrl" value="AlterarParticipante"/>
                    <br>
            <p>
                <input type="submit" value="Alterar" class="btn btn-warning btn-lg center-block"/>
            </p>
        </form>
                </center>
    		</div>

    
<c:import url="../template/footer.jsp"/>