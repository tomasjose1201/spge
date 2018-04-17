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
                        <h1><c:out value="${evento.nome}" /></h1>
                        <img src="/img/${evento.fotoDestaque}" style="width:400px;height:300px;float:right;">                     
                        <dl>                      
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
                            <dt>Website:</dt>
                            <dd><c:out value="${evento.urlWebsite}" /></dd>
                            <dt>Facebook:</dt>
                            <dd><c:out value="${evento.urlEventoFacebook}" /></dd>
                        </dl>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <button class="btn btn-outline-primary" type="button">
                    Listar Seções
                </button>
                <button class="btn btn-outline-primary" type="button">
                    Listar Participantes
                </button>
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
