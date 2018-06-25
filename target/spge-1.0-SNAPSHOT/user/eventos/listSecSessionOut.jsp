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
            <div class="container" style="margin-top: 30px;">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-calendar"></i> Lista de Seções: <b><c:out value="${nomeEvento}" /></b> 
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome da Seção</th>
                                        <th>Local</th>
                                        <th>Descrição</th>
                                        <th width="15%">Início</th>
                                        <th width="15%">Encerramento</th>
                                        <th width="15%">Encerramento Inscrições</th>
                                        <th width="12%">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="secao" items="${listaS}">
                                        <tr>
                                            <td><c:out value="${secao.nome}"/></td>
                                            <td><c:out value="${secao.local}"/></td>
                                            <td><c:out value="${secao.descricao}"/></td>
                                            <td><c:out value="${secao.dataHoraInicioF}"/></td>
                                            <td><c:out value="${secao.dataHoraEncerramentoF}"/></td>
                                            <td><c:out value="${secao.dataHoraEncerramentoInscricoesF==null ? dtEncerramentoInsEvento : secao.dataHoraEncerramentoInscricoesF}"/></td>
                                            <td>
                                                <c:if test="${org != 'true'}">
                                                    <c:set var="myFlag" value="false" />
                                                    <c:set var="myFlagInscrito" value="false" />
                                                    <c:forEach var="secaoConfirmada" items="${listaSecoesConfirmadas}">
                                                        <c:if test="${idUsuarioSessao == idUsuarioOrganizadorEvento}">
                                                            <c:set var="myFlag" value="true" />
                                                        </c:if>
                                                        <c:if test="${(secao.idSecao == secaoConfirmada.idSecao)}">
                                                            <c:set var="myFlag" value="true" />
                                                            <c:set var="myFlagInscrito" value="true" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${myFlagInscrito=='true'}">
                                                        <p><font style="color:red;">Inscrito</font></p>
                                                    </c:if>
                                                    <c:if test="${myFlag=='false'}">
                                                        <a href="HomepageController#myBtnCadastro" style="color:blue">Cadastre-se</a> 
                                                        <br>
                                                    </c:if>
                                                </c:if>
                                            <c:if test="${idUsuarioSessao == idUsuarioOrganizadorEvento}">
                                                <a href="/ConvidadoController?action=listPart&obj=secao&id=${secao.idSecao}">Inscritos</a>
                                            </c:if> 
                                            </td>
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
        </div>
    </body>
</html>
