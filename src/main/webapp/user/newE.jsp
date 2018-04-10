<%-- 
    Document   : newE
    Created on : 08/04/2018, 22:41:19
    Author     : kaueholt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SPGE - Novo Evento</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body class="fixed-nav sticky-footer bg-dark">

        <jsp:include page="borderNavs.jsp"/>        
        <jsp:include page="newS.jsp"/>

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active" id="dreadcrumbNewE">Criar Evento</li>
                </ol>
                <div class="row">
                    <div class="col-12">
                        <div class="col-md-6 float-left">
                            <div class="card w-100 p-3">
                                <div class="card-body">
                                    <h5 class="card-title">Criar Evento</h5>                
                                    <form>
                                        <div class="form-group">
                                            <label for="InputNomeSecao">Nome do Evento</label>
                                            <input class="form-control" id="InputNomeSecao" type="text" placeholder="Ex. 3º Festival Gastronômico de Cuiabá" onchange="dreadcrumbNewE.innerHTML = InputNomeSecao.value">
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col-md-3">
                                                    <label for="inputDataIEvento">Data de Início</label>
                                                    <input class="form-control col-md-9" id="inputDataIEvento" type="text" placeholder="dd/mm/aaaa">
                                                </div>
                                                <div class="col-md-3" style="left:-3%">
                                                    <label for="inputHIEvento">Horário de Início</label>
                                                    <input class="form-control col-md-6" id="inputHIEvento" type="text" placeholder="hh:mm">
                                                </div>
                                                <div class="col-md-3" style="left:3%">
                                                    <label for="inputDataEEvento">Data Encerramento</label>
                                                    <input class="form-control col-md-9" id="inputDataEEvento" type="text" placeholder="dd/mm/aaaa">
                                                </div>
                                                <div class="col-md-3" style="right">
                                                    <label for="inputHFEvento">Hora Encerramento</label>
                                                    <input class="form-control col-md-6" id="inputHFEvento" type="text" placeholder="hh:mm">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col-md-3">
                                                    <label for="inputDataLEvento">Limite das Inscrições</label>
                                                    <input class="form-control col-md-9" id="inputDataLEvento" type="text" placeholder="dd/mm/aaaa">
                                                    <small style="color:red"> (opcional) </small>
                                                </div>
                                                <div class="col-md-3">
                                                    <label for="inputMaxParticipantes">Máximo de Inscrições</label>
                                                    <input class="form-control col-md-7" id="inputMaxParticipantes" type="text" placeholder="0"><small style="color:red"> (opcional) </small>
                                                </div>
                                                <div class="col-md-3" style="right:-3%">
                                                    <label for="inputMaxParticipantes">Valor da Inscrição</label>
                                                    <input class="form-control col-md-10" id="inputMaxParticipantes" type="text" placeholder="0,00"><small style="color:red"> (opcional) </small>
                                                </div>    
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col-md-12">  
                                                    <label for="actualupload"><i class="fa fa-picture-o" style="font-size: 5em; cursor: pointer;"></i></label>
                                                    <h4 style="display:inline-block">
                                                        <a data-toggle="input" data-target="#actualupload" style="cursor: pointer; display: inline-block">Carregar Imagem do Evento</a>
                                                    </h4>                                                    
                                                    <small style="color:red;"> (opcional)</small>                        
                                                </div>
                                                <input id="actualupload" type="file" hidden onchange="file_path_display.innerHTML = actualupload.value">
                                                <div id="file_path_display">
                                                </div>                     
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <label for="inputLocalSecao">Local</label>
                                                <input class="form-control" id="inputLocalSecao" type="text" placeholder="Rua do Evento, 42 - Curitiba, PR">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="descricaoE">Descrição:</label>
                                            <textarea class="form-control" rows="5" id="descricaoE"></textarea>
                                        </div>
                                        <div class="form-group form-row form-check">
                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                            <label class="form-check-label" for="exampleCheck1">Emite Certificado aos Participantes</label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 float-right">
                            <div class="card w-100 p-3">
                                <div class="card-body">
                                    <h5 class="card-title">Cadastrar Seção</h5> 
                                    <div class=" text-center">
                                        <i id="newEIcon" class="fa fa-plus-circle" onClick="novaSecaoModal()" data-toggle="modal" data-target="#novaSecaoModal" style="color:darkcyan; font-size:15em"></i>
                                        <ul class="list-group">
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                Seção 01
                                                <span class="badge badge-primary badge-pill">14</span>
                                            </li>
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                Seção 02
                                                <span class="badge badge-primary badge-pill">2</span>
                                            </li>
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                Seção 03
                                                <span class="badge badge-primary badge-pill">1</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="btn btn-primary btn-block btn-lg" href="#" style="height: 100px;margin:10px; margin-bottom: 40px; font-size: 3em;">Criar Evento!</a>
                </div>
            </div>
            <!-- /.container-fluid-->
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright © Your Website 2018</small>
                    </div>
                </div>
            </footer>
        </div>

    </body>
</html>

