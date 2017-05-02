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
                    Interesses da Palestra "${palestraInteresse.tema}"
                    Código da Palestra "${palestraInteresse.codigo}"
                </div>
                <div class="panel-body center-block">                                 
                    <form method="POST" action="${pageContext.request.contextPath}/FrontController" class="form-inline">
                        
                        <div class="row">
                        
                            <c:forEach items="${interesses}" var="i">
                                <div class="com-xs-12 col-sm-6 col-md-4 col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <input type="checkbox" aria-label="..." name="interesse" value="${i.id}">
                                        </span>
                                        <input type="text" class="form-control" aria-label="..." readonly="readonly" disabled="disabled" value="${i.descricao}" title="Interesse">
                                    </div><!-- /input-group -->
                                </div><!-- /.col-lg-6 -->                      
                            </c:forEach>    
                        
                        </div>
                        
                        <input type="hidden" name="ctrl" value="Inscricao">
                        <input type="submit" value="Inscrever-se">
                        
                    </form>
                </div>
            </div>
        </div>
    </>

<c:import url="../template/footer_post_login.jsp"/>