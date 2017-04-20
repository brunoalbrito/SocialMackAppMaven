<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>

<div class="row">

        <div class="col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
        
            <c:if test="${error_message != null}">
                <div class="alert alert-danger alert-dismissable">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>ERRO!</strong> ${error_message}
                </div>
            </c:if>
        
            <div class="panel panel-default">
                <div class="panel-heading">
                    Interesses da Palestra "${palestra_pendente.tema}"
                </div>
                <div class="panel-body">
                    <form method="POST" action="${pageContext.request.contextPath}/FrontController" class="form-inline">
                        
                        <c:forEach items="${interesses}" var="i">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" aria-label="..." name="interesse" value="${i.id}">
                                    </span>
                                    <input type="text" class="form-control" aria-label="..." readonly="readonly" disabled="disabled" value="${i.descricao}" title="Interesse">
                                </div><!-- /input-group -->
                            </div><!-- /.col-lg-6 -->                      
                        </c:forEach>                      
                        
                    </form>    
                    
                    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/FrontController">
                        <div class="col-lg-12">
                            <div class="input-group">
                                <input type="text" class="form-control"  title="Interesse" placeholder="Interesse" required="required" name="novo_interesse">
                                <input type="submit" value="ADD" title="Adicionar interesse..." class="btn btn-default btn-lg center-block">
                                <input type="hidden" name="ctrl" value="AddInteresse">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<c:import url="../template/footer_post_login.jsp"/>