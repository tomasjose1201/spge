<%-- 
    Document   : login
    Created on : 03/04/2018, 16:45:27
    Author     : Tom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SPGE - Homepage</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/heroic-features.css" rel="stylesheet">

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/jquery/jquery.maskedinput-1.1.4.pack.js"/></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">SPGE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="myBtnCadastro">Cadastre-se</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="myBtnLogin">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container-fluid">
        <c:if test="${msgEmail != null}">
            <br>
            <div class="alert alert-danger text-center">
                <h5><c:out value="${msgEmail}" /></h5>
            </div>
        </c:if>
        <c:if test="${msgCpf != null}">
            <br>
            <div class="alert alert-danger text-center">
                <h5><c:out value="${msgCpf}" /></h5>
            </div>
        </c:if>
        <c:if test="${loginFail != null}">
            <br>
            <div class="alert alert-danger text-center">
                <h5><c:out value="${loginFail}" /></h5>
            </div>
        </c:if>

        <!-- Jumbotron Header -->
        <header class="jumbotron my-4">
            <h1 class="display-3"><c:out value="${eventoDestaque.nome}" /></h1>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
            <a href="#" class="btn btn-primary btn-lg">Ver mais</a>
        </header>

        <!-- Page Features -->
        <div class="row text-center">

            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                    <div class="card-body">
                        <h4 class="card-title">Evento 1</h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-primary">Ver mais</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                    <div class="card-body">
                        <h4 class="card-title">Evento 2</h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-primary">Ver mais</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                    <div class="card-body">
                        <h4 class="card-title">Evento 3</h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-primary">Ver mais</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                    <div class="card-body">
                        <h4 class="card-title">Evento 4</h4>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-primary">Ver mais</a>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->
        <jsp:include page="cadastro.jsp"/>
        <jsp:include page="login.jsp"/>
    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</p>
        </div>
        <!-- /.container -->
    </footer>

</body>

</html>

