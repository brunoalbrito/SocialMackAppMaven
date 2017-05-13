<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SocialMack</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="../vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="../css/business-casual.css"/>" rel="stylesheet" type="text/css"/>

    <!-- Temporary navbar container fix -->
    <style>
    .navbar-toggler {
        z-index: 1;
    }
    
    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }
    </style>

</head>

<body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-4 hidden-md-down"><a style="text-decoration: none; color: #fff" href="home.html">SocialMack</a></div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-4 hidden-md-down"></div>

    <!-- Navigation -->
    <nav class="navbar navbar-toggleable-md navbar-light navbar-custom bg-faded py-lg-4">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold hidden-lg-up" href="#">SocialMack</a>
            <div class="collapse navbar-collapse" id="navbarExample">
                <ul class="navbar-nav mx-auto">
                    
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="${pageContext.request.contextPath}/FrontController?ctrl=ListarPalestra">Lista</a>
                    </li>
              
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="${pageContext.request.contextPath}/FrontController?ctrl=PalestraInscrito">Agenda</a>
                    </li>

                    <li class="nav-item px-lg-4">
                        <a class="active nav-link text-uppercase text-expanded" href="#">Perfil</a>
                    </li>

                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">