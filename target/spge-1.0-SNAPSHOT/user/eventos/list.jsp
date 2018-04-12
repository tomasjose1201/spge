<%-- 
    Document   : list
    Created on : 12/04/2018, 14:18:43
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SPGE - Sistema de Planejamento e Gestão de Eventos</title>
        <!-- Bootstrap core CSS-->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="../css/sb-admin.css" rel="stylesheet">
    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="#">SPGE</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Eventos">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseEventos" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-calendar"></i>
                            <span class="nav-link-text">Eventos</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseEventos">
                            <li>
                                <a href="list.jsp">Listar</a>
                            </li>
                            <li>
                                <a href="#">Novo Evento</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-envelope"></i>
                            <span class="d-lg-none">Messages
                                <span class="badge badge-pill badge-primary">12 New</span>
                            </span>
                            <span class="indicator text-primary d-none d-lg-block">
                                <i class="fa fa-fw fa-circle"></i>
                            </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">New Messages:</h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>David Miller</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>Jane Smith</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>John Doe</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item small" href="#">View all messages</a>
                        </div>
                    </li>

                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Pesquisar...">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-calendar"></i> Lista de Eventos
                        <div class="dropdown" style="float:right">
                            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Filtrar
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Confirmado</a>
                                <a class="dropdown-item" href="#">Pendente</a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th width="10%">Data</th>
                                        <th width="10%">Horário</th>
                                        <th>Local</th>
                                        <th width="10%">Status</th>
                                        <th width="10%">Detalhes</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Evento 1</td>
                                        <td>01/08/2018</td>
                                        <td>19:00/22:00</td>
                                        <td>Local 1</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 2</td>
                                        <td>02/08/2018</td>
                                        <td>13:00/15:00</td>
                                        <td>Local 2</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 3</td>
                                        <td>03/08/2018</td>
                                        <td>10:30/11:30</td>
                                        <td>Local 3</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 4</td>
                                        <td>04/08/2018</td>
                                        <td>18:00/20:00</td>
                                        <td>Local 4</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 5</td>
                                        <td>05/08/2018</td>
                                        <td>12:00/13:30</td>
                                        <td>Local 5</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 6</td>
                                        <td>06/08/2018</td>
                                        <td>09:40/10:30</td>
                                        <td>Local 6</td>
                                        <td>Confirmado</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 7</td>
                                        <td>07/08/2018</td>
                                        <td>07:30/12:00</td>
                                        <td>Local 7</td>
                                        <td>Pendente</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                    <tr>
                                        <td>Evento 8</td>
                                        <td>08/08/2018</td>
                                        <td>21:00/22:00</td>
                                        <td>Local 8</td>
                                        <td>Pendente</td>
                                        <td><a href="#">Ver mais</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid-->
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</small>
                    </div>
                </div>
            </footer>
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fa fa-angle-up"></i>
            </a>
            <!-- Logout Modal-->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Bootstrap core JavaScript-->
            <script src="../vendor/jquery/jquery.min.js"></script>
            <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
            <!-- Page level plugin JavaScript-->
            <script src="../vendor/chart.js/Chart.min.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="../js/sb-admin.min.js"></script>
            <!-- Custom scripts for this page-->
            <script src="../js/sb-admin-charts.min.js"></script>
        </div>
    </body>

</html>
