<%-- 
    Document   : listPartSessionOut
    Created on : 25/06/2018, 15:12:53
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

        <title>SPGE - Participantes da Seção</title>

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
            <div class="container" style="margin-top: 30px;">
                <c:if test="${msgConfirm != null}">
                    <div class="alert alert-success text-center">
                        <h5><c:out value="${msgConfirm}" /></h5>
                    </div>
                </c:if>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-calendar"></i> Lista de Participantes: 
                        <b><c:out value="${nomeEvento}" /></b>
                        <b><c:out value="${nomeSecao}" /></b> 
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th width="20%">Nome</th>
                                        <th width="20%">Email</th>
                                        <th>Status Confirmação</th>
                                        <th>Data/Hora Confirmação</th>
                                        <th>Status Presença</th>
                                        <th>Função</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="part" items="${listaP}">
                                        <tr>

                                            <td><c:if test="${part.tipoConvidado=='RE'}">
                                                    <i class="fa fa-fw fa-star" style="color:yellow;"></i>
                                                </c:if>
                                                <c:out value="${part.convidado.nome}"/>
                                            </td>
                                            <td><c:out value="${part.convidado.email}"/></td>
                                            <td>
                                                <c:out value="${part.statusConfirmacao=='C'? 'Confirmado' : 'Pendente'}"/>
                                                <c:if test="${part.statusConfirmacao=='P'}">
                                                    <c:if test="${!empty nomeSecao}">
                                                        <br><a href="ConvidadoController?action=confirmPart&obj=secao&idConv=${part.convidado.idConvidado}&idSecao=${part.secao.idSecao}" style="color:green">Confirmar</a>
                                                    </c:if>
                                                    <c:if test="${!empty nomeEvento}">
                                                        <br><a href="ConvidadoController?action=confirmPart&obj=evento&idConv=${part.convidado.idConvidado}&idEvento=${part.evento.idEvento}" style="color:green">Confirmar</a>
                                                    </c:if>
                                                </c:if>
                                            </td>
                                            <td><c:out value="${part.dataHoraConfirmacaoF}"/></td>
                                            <td><c:out value="${part.statusPresenca=='A'? 'Ausente' : 'Presente'}"/></td>
                                            <td><c:out value="${part.tipoConvidado=='PA' ? 'Participante' : 'Responsável'}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
        </div>

    </body>
</html>
