<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SocialMack</title>
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/js/jquery-3.2.0.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>        
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">SocialMack</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">          
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Palestra <span class="caret"></span></a>

                            <ul class="dropdown-menu">
                                <li><a href="cadastro_palestra.jsp">Nova</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/FrontController?ctrl=ListarPalestraOrganizador">Lista</a></li>
                            </ul>

                        </li>          
                    </ul> 

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container container-fluid">