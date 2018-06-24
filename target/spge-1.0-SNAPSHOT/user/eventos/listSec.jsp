<%-- 
    Document   : listSec
    Created on : 01/05/2018, 18:32:39
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- Head -->
    <jsp:include page="../include/head.jsp"/>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <jsp:include page="../include/nav.jsp"/>

        <div class="content-wrapper">
            <div class="container-fluid">
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
                                        <th>Ações</th>
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
                                                        <a href="#" class="confirmSModalBtn" data-id="${secao.idSecao}" style="color:green">Participar</a> 
                                                        <br>
                                                    </c:if>
                                                </c:if>
                                            <c:if test="${idUsuarioSessao == idUsuarioOrganizadorEvento}">
                                                <a href="ConvidadoController?action=listPart&obj=secao&id=${secao.idSecao}">Inscritos</a>
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
            <jsp:include page="../include/footer.jsp"/>
            <!-- Scroll To Top Button -->
            <jsp:include page="../include/topbutton.jsp"/>
            <!-- Logout Modal -->
            <jsp:include page="../include/logout.jsp"/>
            <!-- JS -->
            <jsp:include page="../include/script.jsp"/>
            <!-- Confirm Modal -->
            <jsp:include page="../include/confirmS.jsp"/>
        </div>
    </body>
</html>
