<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title>SocialMack</title>
        
            <style>
        .navbar-toggler {
            z-index: 1;
        }
        
        @media (max-width: 576px) {
            nav > .container {
                width: 100%;
            }
        }
        /* Temporary fix for img-fluid sizing within the carousel */
        
        .carousel-item.active,
        .carousel-item-next,
        .carousel-item-prev {
            display: block;
        }
    </style>
        
        
<!-- ----------------------------------------------------------------------------------------------------------- -->        
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">


<!-- ----------------------------------------------------------------------------------------------------------- -->

        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

            <div class="tagline-upper text-center text-heading text-shadow text-white mt-4 hidden-md-down">SocialMack</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-4 hidden-md-down"></div>

    <!-- Navigation -->
    <nav class="navbar navbar-toggleable-md navbar-light navbar-custom bg-faded py-lg-4">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold hidden-lg-up" href="#">Start Bootstrap</a>
            <div class="collapse navbar-collapse" id="navbarExample">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item px-lg-4">
                        <a class="nav-link active text-uppercase text-expanded" href="index.html">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="user_area/cadastro.html">Cadastro</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="bg-faded p-4 my-4">

            <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4 center">
                <div class="panel panel-default ">
                    <div class="panel-heading">
                        <center>LOGIN</center>
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

        <footer class="bg-faded text-center py-4">
            <div class="container">
                <p class="m-0">Copyright &copy; Your Website 2017</p>
            </div>
        </footer>
    </div>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <div class="container-fluid">
        
        </body>

</html>