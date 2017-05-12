<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/template/header_post_login_organizador.jsp"/>

<div class="row">

        <div class="col-sm-12 col-md-12 col-lg-12">
        
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
                <div class="panel-body center-block">                                 
                    <form method="POST" action="${pageContext.request.contextPath}/FrontController" class="form-inline">
                        
                        <div class="row">
                        
                            <c:forEach items="${interesses}" var="i">
                                <div class="com-xs-12 col-sm-6 col-md-4 col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <input type="checkbox" aria-label="..." name="interesse" value="${i.id}" checked="checked">
                                        </span>
                                        <input type="text" class="form-control" aria-label="..." readonly="readonly" disabled="disabled" value="${i.descricao}" title="Interesse">
                                    </div><!-- /input-group -->
                                </div><!-- /.col-lg-6 -->                      
                            </c:forEach>    
                        
                        </div>
                        
                        <input type="hidden" name="ctrl" value="RegistrarPalestra">
                        <input type="submit" value="CADASTRAR">
                        
                    </form>
                </div>
                
                <div class="panel-footer">
                     <form class="center-block" method="post" action="${pageContext.request.contextPath}/FrontController">
                        <input type="text" class="form-control"  title="Interesse" placeholder="Interesse" required="required" name="novo_interesse">
                        <input type="submit" value="ADD" title="Adicionar interesse..." class="btn btn-default btn-lg center-block">
                        <input type="hidden" name="ctrl" value="AddInteresse">
                    </form>
                </div>
                
            </div>
        </div>
    </div>

<c:import url="../template/footer_post_login.jsp"/>