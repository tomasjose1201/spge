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
                <c:if test="${msgConfirm != null}">
                    <div class="alert alert-success text-center">
                        <h5><c:out value="${msgConfirm}" /></h5>
                    </div>
                </c:if>
                <c:if test="${msgEmail != null}">
                    <div class="alert alert-primary text-center">
                        <h5><c:out value="${msgEmail}" /></h5>
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
                                        <th width="12%">Ações</th>
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
                                            <td>
                                                <c:if test="${part.statusPresenca=='A'}">
                                                    <c:if test="${!empty nomeSecao}">
                                                        <a href="ConvidadoController?action=confirmPresenca&obj=secao&idConv=${part.convidado.idConvidado}&idSecao=${part.secao.idSecao}" style="color:green">Presente</a>
                                                    </c:if>
                                                    <c:if test="${!empty nomeEvento}">
                                                        <a href="ConvidadoController?action=confirmPresenca&obj=evento&idConv=${part.convidado.idConvidado}&idEvento=${part.evento.idEvento}" style="color:green">Presente</a>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${part.contatoRealizado=='N' && part.tipoConvidado=='RE' && part.statusConfirmacao=='P'}">
                                                    <a href="ConvidadoController?action=contato&idConv=${part.convidado.idConvidado}&idSecao=${part.secao.idSecao}">Enviar Email</a>
                                                </c:if>
                                                <c:if test="${!empty nomeEvento}">    
                                                <a href="ConvidadoController?action=excluir&obj=evento&idConv=${part.convidado.idConvidado}&idEvento=${part.evento.idEvento}" style="color:red;">Excluir</a>
                                                </c:if>
                                                <c:if test="${!empty nomeSecao}">    
                                                    <a href="ConvidadoController?action=excluir&obj=secao&idConv=${part.convidado.idConvidado}&idSecao=${part.secao.idSecao}" style="color:red;">Excluir</a>
                                                </c:if>
                                                    
                                                <c:if test="${!empty nomeEvento}">
                                                    <c:set var="idEventoRetorno" value="${part.evento.idEvento}" ></c:set>
                                                </c:if>
                                                <c:if test="${!empty nomeSecao}">
                                                    <c:set var="idEventoRetorno" value="${part.secao.idEvento}"></c:set>
                                                </c:if> 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <c:if test="${!empty nomeSecao}">
                    <a href="SecaoController?action=listSec&id=${idEventoRetorno}"><< Voltar</a>
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
