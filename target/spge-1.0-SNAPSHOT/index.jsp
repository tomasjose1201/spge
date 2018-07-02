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
                        <a class="nav-link" href="#myBtnCadastro" id="myBtnCadastro" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">Cadastre-se</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#myBtnLogin" id="myBtnLogin" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">Login</a>
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
    <c:if test="${msgEmail2 != null}">
        <br>
        <div class="alert alert-info text-center">
            <h5><c:out value="${msgEmail2}" /></h5>
        </div>
    </c:if>
    <c:if test="${msgEmail3 != null}">
        <br>
        <div class="alert alert-danger text-center">
            <h5><c:out value="${msgEmail3}" /></h5>
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
    <c:if test="${msgUpdateSenha != null}">
        <br>
        <div class="alert alert-info text-center">
            <h5><c:out value="${msgUpdateSenha}" /></h5>
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
                <div class="carousel-item active" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(https://images.unsplash.com/photo-1454165804606-c3d57bc86b40?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=37c91c8e3f63462e0739c676dfe8fee8&auto=format&fit=crop&w=750&q=80)">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Organize seu evento acadêmico</h3>
                        <p>Crie eventos e seções de maneira simples e rápida.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(https://images.unsplash.com/photo-1460925895917-afdab827c52f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5a7430d7bd5676bc7b81f2b8bf8f6a75&auto=format&fit=crop&w=702&q=80)">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Gerencie seus eventos</h3>
                        <p>Visualização de inscritos, controle de presença e emissão de certificados.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)  ),url(https://images.unsplash.com/photo-1515168985652-8454bcc8fcaf?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=f0a3b98bc7ce573455ad6cbe3d35c369&auto=format&fit=crop&w=750&q=80)">
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
                        <img class="card-img-top" src="${evento.fotoDestaque}" alt="">
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
    
    <script>
          $(document).ready(function() {

          if(window.location.href.indexOf('#myBtnCadastro') > -1) {
            $("#myModalCadastro").modal();
          }

        });    
    </script>

    <!-- Footer -->
    <footer class="footer py-4 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</p>
        </div>
    </footer>
</body>

</html>

