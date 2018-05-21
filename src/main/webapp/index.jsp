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
        <link href="css/half-slider.css" rel="stylesheet">

        <style>
            h3 {
                font-family: Verdana, Geneva, sans-serif;
                font-weight: bold;
            }
        </style>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery/jquery.maskedinput-1.1.4.pack.js"/></script>
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="HomepageController" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">SPGE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="myBtnCadastro" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">Cadastre-se</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="myBtnLogin" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <c:if test="${msgEmail != null}">
        <br>
        <div class="alert alert-danger text-center">
            <h5><c:out value="${msgEmail}" /></h5>
        </div>
    </c:if>
    <c:if test="${msgCpf != null}">
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
    <header>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(img/helloquence-61189-unsplash.jpg)">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Organize seu evento acadêmico</h3>
                        <p>Crie eventos e seções de maneira simples e rápida.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(img/carlos-muza-84523-unsplash.jpg)">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Gerencie seus eventos</h3>
                        <p>Visualização de inscritos, controle de presença e emissão de certificados.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(img/antenna-502686-unsplash.jpg)">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Participe de qualquer evento</h3>
                        <p>Basta solicitar a participação e aguardar a confirmação.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </header>

    <div class="container-fluid my-4">
        <div class="row text-center">
            <c:forEach var="evento" items="${eventos}">
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-body">
                            <h4 class="card-title"><c:out value="${evento.nome}" /></h4>
                            <p class="card-text"><c:out value="${evento.descricao}" /></p>
                        </div>
                        <div class="card-footer">
                            <a href="EventoController?action=details&id=${evento.idEvento}" class="btn btn-primary">Ver mais</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="cadastro.jsp"/>
        <jsp:include page="login.jsp"/>
    </div>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</p>
        </div>
    </footer>
</body>

</html>

