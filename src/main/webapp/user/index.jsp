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
                                <div class="mr-5">2 Avisos</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-list"></i>
                                </div>
                                <div class="mr-5">Organizando 11 eventos</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-calendar"></i>
                                </div>
                                <div class="mr-5">Inscrito em 14 eventos</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-bar-chart"></i> Dados Financeiros</div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-8 my-auto">
                                        <canvas id="myBarChart" width="100" height="50"></canvas>
                                    </div>
                                    <div class="col-sm-4 text-center my-auto">
                                        <div class="h4 mb-0 text-primary">$34,693</div>
                                        <div class="small text-muted">YTD Revenue</div>
                                        <hr>
                                        <div class="h4 mb-0 text-warning">$18,474</div>
                                        <div class="small text-muted">YTD Expenses</div>
                                        <hr>
                                        <div class="h4 mb-0 text-success">$16,219</div>
                                        <div class="small text-muted">YTD Margin</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mb-0 mt-4">
                            <i class="fa fa-calendar"></i> Meus Eventos</div>
                        <hr class="mt-2">
                        <div class="col-lg-3 col-md-6 mb-4 text-center">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Teste</h4>
                                    <p class="card-text">Teste</p>
                                </div>
                                <div class="card-footer">
                                    <a href="#" class="btn btn-primary">
                                        Ver Mais
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-bell-o"></i> Avisos</div>
                            <div class="list-group list-group-flush small">
                                <a class="list-group-item list-group-item-action" href="#">
                                    <div class="media">
                                        <div class="media-body">
                                            <strong>Evento Teste 1</strong> foi cancelado!
                                            <div class="text-muted smaller">Hoje às 5:43</div>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item list-group-item-action" href="#">
                                    <div class="media">
                                        <div class="media-body">
                                            <strong>Evento Teste 2</strong> foi cancelado!
                                            <div class="text-muted smaller">Hoje às 5:43</div>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item list-group-item-action" href="#">
                                    <div class="media">
                                        <div class="media-body">
                                            <strong>Evento Teste 3</strong> foi cancelado!
                                            <div class="text-muted smaller">Hoje às 5:43</div>
                                        </div>
                                    </div>
                                </a>
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

