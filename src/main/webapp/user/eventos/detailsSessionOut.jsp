<%-- 
    Document   : formsenha
    Created on : 31/05/2018, 11:43:01
    Author     : Tom
--%>

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

        <title>SPGE - Evento</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/heroic-features.css" rel="stylesheet">

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="HomepageController" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">SPGE</a>
            </div>
        </nav>

        <div class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <c:set var="evento" value="${detalhes}" />
                        <h3 style="margin-top: 30px">
                            <c:out value="${evento.nome}" />
                            <div style="float: right">
                                <c:if test="${(role==false) && (convidadoconfirmado==false)}">
                                    <a class="confirmModalBtn" data-id="${evento.idEvento}">
                                        <button class="btn btn-success" type="button">
                                            Participar
                                        </button>
                                    </a>
                                </c:if>
                                <c:if test="${(evento.contemSecoes=='S')}">
                                    <a href="SecaoController?action=listSec&id=${evento.idEvento}">
                                        <button class="btn btn-outline-primary" type="button">
                                            Listar Seções
                                        </button>
                                    </a>
                                </c:if>  
                            </div>

                        </h3>
                        
                        <img id="qrCodeImg" src="${qrcode}" style="float: right;" />

                        <dl>
                            <dt>Organizador:</dt> 
                            <dd><c:out value="${org.nome} (${org.email})" /></dd>
                            <c:if test="${evento.descricao != ''}">
                                <dt>Descrição:</dt> 
                                <dd><c:out value="${evento.descricao}" /></dd>
                            </c:if>
                            <dt>Localização:</dt> 
                            <dd><c:out value="${evento.endereco}" /></dd>
                            <dt>Data/Hora Início:</dt> 
                            <dd><c:out value="${evento.dataHoraInicioF}" /></dd>
                            <dt>Data/Hora Encerramento:</dt> 
                            <dd><c:out value="${evento.dataHoraEncerramentoF}" /></dd>
                            <dt>Encerramento das Inscrições:</dt>
                            <dd><c:out value="${evento.dataHoraEncerramentoInscricoesF}" /></dd>
                            <dt>Tipo de Evento</dt>
                            <dd><c:out value="${evento.tipoEvento}" /></dd>
                            <dt>Número Máximo de Participantes:</dt>
                            <dd><c:out value="${evento.numMaxParticipantes}" /></dd>
                            <dt>Emite Certificado?</dt>
                            <dd><c:out value="${(evento.emiteCertificado=='S') ? 'Sim' : 'Não'}" /></dd>
                            <dt>Preço: </dt>
                            <dd><c:out value="${evento.precoF}" /></dd>
                            <c:if test="${evento.urlWebsite != ''}">
                                <dt>Website:</dt>
                                <dd><c:out value="${evento.urlWebsite}" /></dd> 
                            </c:if>
                            <c:if test="${evento.urlEventoFacebook != ''}">
                                <dt>Facebook:</dt>
                                <dd><c:out value="${evento.urlEventoFacebook}" /></dd>
                            </c:if>

                        </dl>
                    </div>
                </div>
            </div>
            <!-- Footer -->
            <footer class="footer py-4 bg-dark fixed-bottom">
                <div class="container">
                    <p class="m-0 text-center text-white">Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</p>
                </div>
            </footer>
            <!-- Scroll To Top Button -->
            <jsp:include page="../include/topbutton.jsp"/>        
            <!-- JS -->
            <jsp:include page="../include/script.jsp"/>
            <!-- Confirm Modal -->
            <jsp:include page="../include/confirm.jsp"/>
        </div>
    </body>

</html>
