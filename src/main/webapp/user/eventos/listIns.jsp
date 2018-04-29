<%-- 
    Document   : listIns
    Created on : 29/04/2018, 12:10:56
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
                        <i class="fa fa-check"></i> Minhas Inscrições
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome do Evento</th>
                                        <th width="15%">Início</th>
                                        <th width="15%">Encerramento</th>
                                        <th>Localização</th>
                                        <th width="10%">Tipo</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="evento" items="${lista}">
                                        <tr>
                                            <td><c:out value="${evento.nome}"/></td>
                                            <td><c:out value="${evento.dataHoraInicioF}"/></td>
                                            <td><c:out value="${evento.dataHoraEncerramentoF}"/></td>
                                            <td><c:out value="${evento.endereco}"/></td>
                                            <td><c:out value="${evento.tipoEvento}"/></td>
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
