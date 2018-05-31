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
            <div class="container">
                <h3 class="text-center">Certificados Disponíveis:</h3><br>
                <c:forEach var="certificado" items="${certificados}">
                    <div class="row text-center">
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><c:out value="${certificado.evento.nome}" /></h5>
                                </div>
                                <div class="card-footer">
                                    <a href="RelatorioController?action=relatorio&id=${certificado.evento.idEvento}" class="btn btn-danger">Download PDF</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- Footer -->
            <jsp:include page="../include/footer.jsp"/>

            <!-- Logout Modal -->
            <jsp:include page="../include/logout.jsp"/>

            <!-- JS -->
            <jsp:include page="../include/script.jsp"/>
        </div>
    </body>
</html>
