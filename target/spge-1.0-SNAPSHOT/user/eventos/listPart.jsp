<%-- 
    Document   : listPart
    Created on : 01/05/2018, 09:01:20
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <c:if test="${contemSecoes == 'S'}">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-calendar"></i> Lista de Seções
                        </div>
                        <div class="card-body">

                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nome da Seção</th>
                                            <th>Local</th>
                                            <th>Descrição</th>
                                            <th>Início</th>
                                            <th>Encerramento</th>
                                            <th>Encerramento Inscrições</th>
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
                                                <td><c:out value="${secao.dataHoraEncerramentoInscricoesF}"/></td>
                                                <td><a href="#">Action 1</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${contemSecoes == 'N'}">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-calendar"></i> Lista de Participantes
                        </div>
                        <div class="card-body">

                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th width="20%">Nome</th>
                                            <th width="20%">Email</th>
                                            <th>Contato Realizado?</th>
                                            <th>Status Confirmação</th>
                                            <th>Data/Hora Confirmação</th>
                                            <th>Função</th>
                                            <th>Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="part" items="${listaP}">
                                            <tr>
                                                <td><c:out value="${part.convidado.nome}"/></td>
                                                <td><c:out value="${part.convidado.email}"/></td>
                                                <td><c:out value="${part.contatoRealizado=='S' ? 'Sim' : 'Não'}"/></td>
                                                <td><c:out value="${part.statusConfirmacao=='C'? 'Confirmado' : 'Pendente'}"/></td>
                                                <td><c:out value="${part.dataHoraConfirmacaoF}"/></td>
                                                <td><c:out value="${part.tipoConvidado=='PA' ? 'Participante' : 'Responsável'}"/></td>
                                                <td><a href="#">Action 1</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>

            <!-- Footer -->
            <jsp:include page="../include/footer.jsp"/>
            <!-- Scroll To Top Button -->
            <jsp:include page="../include/topbutton.jsp"/>
            <!-- Logout Modal -->
            <jsp:include page="../include/logout.jsp"/>
            <!-- JS -->
            <jsp:include page="../include/script.jsp"/>
        </div>
    </body>
</html>
