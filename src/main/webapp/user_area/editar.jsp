<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:import url="/template/header_pos_login_participante.jsp"/>

                <%
                    String id_pessoa = request.getParameter("idPessoa"); 
                    String nome = request.getParameter("nome"); 
                    String email = request.getParameter("email"); 
                    String senha = request.getParameter("senha"); 
                    String celular = request.getParameter("celular"); 
                    String formacao = request.getParameter("formacao"); 
                    String curso = request.getParameter("curso");
                %>
<center>
    	
    		<div class="bg-faded p-4 my-4">
			
			<hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0">Editar <strong>Perfil</strong></h2>
            <hr class="divider">
			
    			<form action="${pageContext.request.contextPath}/FrontController" method="POST">
            <c:out value="${participante.senha}"></c:out>
                <p>
                    <label for="id">ID:</label><br>
                    <input type="text" class="form-group" disabled id="id" name="id" value="${params.id_pessoa}" />
            </p>
            <p>
                <label for="name">Nome:</label><br>
                <input type="text" id="name" name="name" value="${params.nome}" class=""/>
            </p>

            <p>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" value="${params.email}"/>
            </p>

            <c:choose>
                <c:when test="${params.senha == null}">
                    <p>
                        <label for="senha">Senha:</label><br>
                        <input type="text" id="senha" name="senha"/>
                    </p>

                    <p>
                        <label for="celular">Celular:</label><br>
                        <input type="text" id="celular" name="celular"/>
                    </p>
                    <p>
                        <label for="formacao">Formacao:</label><br>
                        <input type="text" id="formacao" name="formacao"/>
                    </p>
                </c:when>
                <c:otherwise>
                    <p>
                        <label for="senha">Senha:</label><br>
                        <input type="text" id="senha" name="senha" value="${params.senha}"/>
                    </p>

                    <p>
                        <label for="celular">Celular:</label><br>
                        <input type="text" id="celular" name="celular" value="${params.celular}"/>
                    </p>
                    <p>
                        <label for="formacao">Formacao:</label><br>
                        <input type="text" id="formacao" name="formacao" value="${params.curso}"/>
                    </p>
                </c:otherwise>
            </c:choose>
            <input type="hidden" name="ctrl" value="AlterarParticipante"/>
                    <br>
            <p>
                <input type="submit" value="Alterar" class="btn btn-warning btn-lg center-block"/>
            </p>
        </form>
                </center>
    		</div>

    
<c:import url="../template/footer.jsp"/>