<%-- 
    Document   : details
    Created on : 12/04/2018, 15:39:35
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
                <div class="row">
                    <div class="col-12">
                        <c:set var="evento" value="${detalhes}" />
                        <h3>
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
                                <c:if test="${(evento.contemSecoes=='N') && (role==true)}">
                                    <a href="ConvidadoController?action=listPart&obj=evento&id=${evento.idEvento}">
                                        <button class="btn btn-outline-primary" type="button">
                                            Listar Participantes
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
                            <dt>Número Máximo de Participantes:</dt>
                            <dd><c:out value="${evento.numMaxParticipantes}" /></dd>
                            <dt>Tipo de Evento</dt>
                            <c:choose>
                                <c:when test="${evento.tipoEvento=='Público'}">
                                    <dd><span class="badge badge-success" style="padding:10px; font-size: 16px;"><c:out value="Público" /></span></dd>
                                </c:when>
                                <c:when test="${evento.tipoEvento=='Privado'}">
                                    <dd><span class="badge badge-danger" style="padding:10px; font-size: 16px;"><c:out value="Privado" /></span></dd>
                                </c:when>
                            </c:choose>
                            <dt>Emite Certificado?</dt>
                            <c:choose>
                                <c:when test="${evento.emiteCertificado=='S'}">
                                    <dd><span class="badge badge-success" style="padding:10px; font-size: 16px;"><c:out value="Sim" /></span></dd>
                                </c:when>
                                <c:when test="${evento.emiteCertificado=='N'}">
                                    <dd><span class="badge badge-danger" style="padding:10px; font-size: 16px;"><c:out value="Não" /></span></dd>
                                </c:when>
                            </c:choose>
                            <dt>Preço: </dt>
                            <c:choose>
                                <c:when test="${evento.precoF == 'R$ 0,00'}">
                                    <dd><span class="badge badge-success" style="padding:10px; font-size: 16px;"><c:out value="Gratuito" /></span></dd>
                                </c:when>
                                <c:when test="${evento.precoF != 'R$ 0,00'}">
                                    <dd><span class="badge badge-danger" style="padding:10px; font-size: 16px;"><c:out value="${evento.precoF}" /></span></dd>
                                </c:when>
                            </c:choose>
                            <c:if test="${evento.urlWebsite != ''}">
                                <dt>Website:</dt>
                                <a href=""><dd><c:out value="${evento.urlWebsite}" /></dd></a>
                            </c:if>
                            <c:if test="${evento.urlEventoFacebook != ''}">
                                <dt>Facebook:</dt>
                                <a href=""><dd><c:out value="${evento.urlEventoFacebook}" /></dd></a>
                            </c:if>

                        </dl>
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
            <jsp:include page="../include/confirm.jsp"/>
        </div>
    </body>

</html>
