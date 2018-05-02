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
                                            <td>
                                                <c:out value="${part.contatoRealizado=='S' ? 'Sim' : 'Não'}"/>
                                                <c:if test="${part.contatoRealizado=='N'}">
                                                    <br><a href="#">Enviar Email</a>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:out value="${part.statusConfirmacao=='C'? 'Confirmado' : 'Pendente'}"/>
                                                <c:if test="${part.statusConfirmacao=='P'}">
                                                    <c:if test="${!empty nomeSecao}">
                                                        <a href="ConvidadoController?action=confirmPart&obj=secao&id=${part.convidado.idConvidado}" style="color:green">Confirmar</a>
                                                    </c:if>
                                                    <c:if test="${!empty nomeEvento}">
                                                        <a href="ConvidadoController?action=confirmPart&obj=evento&id=${part.convidado.idConvidado}" style="color:green">Confirmar</a>
                                                    </c:if>
                                                </c:if>
                                            </td>
                                            <td><c:out value="${part.dataHoraConfirmacaoF}"/></td>
                                            <td><c:out value="${part.tipoConvidado=='PA' ? 'Participante' : 'Responsável'}"/></td>
                                            <td>
                                                <a href="#" style="color:red;">Excluir</a>
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
        </div>
    </body>
</html>
