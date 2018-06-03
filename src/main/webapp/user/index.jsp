<%-- 
    Document   : index
    Created on : 12/04/2018, 14:10:14
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- Head -->
    <jsp:include page="include/head.jsp"/>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <jsp:include page="include/nav.jsp"/>

        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-4 col-sm-6 mb-3">
                        <div class="card text-white bg-primary o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-comments"></i>
                                </div>
                                <div class="mr-5">${qtdeAvisos} <c:out value="${qtdeAvisos==1 ? 'Aviso' : 'Avisos'}"/></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-calendar"></i>
                                </div>
                                <div class="mr-5">Inscrito em ${qtdeEventosIns} <c:out value="${qtdeEventosIns==1 ? 'evento' : 'eventos'}"/></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-list"></i>
                                </div>
                                <div class="mr-5">Organizando ${qtdeEventosOrg} <c:out value="${qtdeEventosOrg==1 ? 'evento' : 'eventos'}"/></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-bell-o"></i> Avisos</div>
                            <div class="list-group list-group-flush small">
                                <c:forEach var="aviso" items="${avisos}">
                                    <a class="list-group-item list-group-item-action" >
                                        <div class="media">
                                            <div class="media-body">
                                                <strong>${aviso.assunto}</strong>
                                                <p>${aviso.descricao}</p>
                                                <div class="text-muted smaller">
                                                    <strong>${aviso.nomeEvento}</strong> ${aviso.dataHoraAvisoF}
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="mb-0 mt-4">
                            <i class="fa fa-calendar"></i> Destaques</div>
                        <hr class="mt-2">
                        <div class="row text-center">
                            <c:forEach var="evento" items="${eventosDestaque}">
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">${evento.nome}</h4>
                                            <p class="card-text">${evento.descricao}</p>
                                        </div>
                                        <div class="card-footer">
                                            <a href="EventoController?action=details&id=${evento.idEvento}" class="btn btn-primary">Ver mais</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="card mb-2">
                            <div class="card-header">
                                <i class="fa fa-bar-chart"></i> Faturamento</div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-12 text-center my-auto">
                                        <c:forEach var="evento" items="${eventosOrg}">
                                            <c:forEach var="fat" items="${faturamentos}">
                                                <c:if test="${fat.idEvento == evento.idEvento}">
                                                    <div class="h4 mb-0 text-primary">${fat.precoF}</div>
                                                </c:if>
                                            </c:forEach>
                                            <div class="small text-muted">${evento.nome}</div>
                                            <hr>
                                        </c:forEach>
                                        <div class="h4 mb-0 text-success">Total: ${somaFat}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer -->
            <jsp:include page="include/footer.jsp"/>
            <!-- Scroll To Top Button -->
            <jsp:include page="include/topbutton.jsp"/>
            <!-- Logout Modal -->
            <jsp:include page="include/logout.jsp"/>
            <!-- JS -->
            <jsp:include page="include/script.jsp"/>
        </div>
    </body>
</html>

