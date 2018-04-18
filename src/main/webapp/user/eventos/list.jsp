<%-- 
    Document   : list
    Created on : 12/04/2018, 14:18:43
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
        
        <!-- Confirmar Participação -->
        <jsp:include page="../include/confirm.jsp"/>
        
        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-calendar"></i> Lista de Eventos
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th width="15%">Início</th>
                                        <th width="15%">Encerramento</th>
                                        <th>Localização</th>
                                        <th width="10%">Tipo</th>
                                        <th width="10%">Ações</th>
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
                                            <td><a href="#" data-toggle="modal" data-target="#confirmModal" style="color:green"><span>Participar</span></a><br />
                                                <a href="EventoController?action=details&id=${evento.idEvento}">Ver mais</a>
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
