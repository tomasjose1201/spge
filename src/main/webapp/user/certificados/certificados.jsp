<%-- 
    Document   : certificados
    Created on : 31/05/2018, 17:03:55
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
            <h3 class="text-center">Certificados Disponíveis:</h3>
            <div class="container-fluid my-4">
                <div class="row text-center">
                    <c:forEach var="certificado" items="${certificados}">
                        <c:if test="${certificado.evento.emiteCertificado=='S'}">
                            <c:if test="${certificado.statusPresenca=='P'}">
                                <div class="col-lg-3 col-md-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title"><c:out value="${certificado.evento.nome}" /></h4>
                                            <p class="card-text"><c:out value="${certificado.evento.descricao}" /></p>
                                        </div>
                                        <div class="card-footer">
                                            <a target="_blank" href="RelatorioController?idConvidado=${certificado.convidado.idConvidado}&idEvento=${certificado.evento.idEvento}" class="btn btn-danger">
                                                Gerar PDF
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <c:set var="cert" value="1" />
                            </c:if>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <c:if test="${cert != 1}">
                <p class="text-center">Você ainda não possui certificados disponíveis.</p>
            </c:if>

            <!-- Footer -->
            <jsp:include page="../include/footer.jsp"/>

            <!-- Logout Modal -->
            <jsp:include page="../include/logout.jsp"/>

            <!-- JS -->
            <jsp:include page="../include/script.jsp"/>
        </div>
    </body>
</html>
