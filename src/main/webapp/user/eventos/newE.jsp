<%-- 
    Document   : newE
    Created on : 08/04/2018, 22:41:19
    Author     : kaueholt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <!-- Head -->
    <jsp:include page="../include/head.jsp"/>

    <body class="fixed-nav sticky-footer bg-dark">

        <!-- Navigation-->
        <jsp:include page="../include/nav.jsp"/>

        <!-- Nova Seção -->
        <jsp:include page="newS.jsp"/>

        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="col-md-6 float-left">
                            <div class="card w-100 p-3">
                                <div class="card-body">
                                    <h5 class="card-title" id="newETitles" >Criar Evento</h5>                
                                    <form>
                                        <div class="form-group">
                                            <label for="nomeEvento">Nome do Evento</label>
                                            <input class="form-control" id="nomeEvento" type="text" placeholder="Ex. 3º Festival Gastronômico de Cuiabá" onchange="dreadcrumbNewE.innerHTML = InputNomeSecao.value">
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <label for="localizacao">Localização</label>
                                                <input class="form-control" id="localizacao" type="text" placeholder="Rua do Evento, 42 - Curitiba, PR">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="descricaoEvento">Descrição</label>
                                            <textarea class="form-control" rows="5" id="descricaoEvento"></textarea>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label for="dataInicioEvento">Data de Início</label>
                                                <input class="form-control" id="dataInicioEvento" type="text" placeholder="dd/mm/aaaa">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="horarioInicioEvento">Horário de Início</label>
                                                <input class="form-control" id="horarioInicioEvento" type="text" placeholder="hh:mm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label for="dataEncerramentoEvento">Data de Encerramento</label>
                                                <input class="form-control" id="dataEncerramentoEvento" type="text" placeholder="dd/mm/aaaa">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="horarioEncerramentoEvento">Horário de Encerramento</label>
                                                <input class="form-control" id="horarioEncerramentoEvento" type="text" placeholder="hh:mm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label for="dataEncerramentoInscricoes">Encerramento das Inscrições</label>
                                                <input class="form-control" id="dataEncerramentoInscricoes" type="text" placeholder="dd/mm/aaaa">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="numMaxParticipantes">Nº Máximo de Participantes</label>
                                                <input class="form-control" id="numMaxParticipantes" type="text" placeholder="0">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label for="preco">Preço</label>
                                                <input class="form-control" id="preco" type="text" placeholder="0,00">
                                                <small style="color:red"> (opcional) </small>
                                            </div>  
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">  
                                                <h4 style="display:inline-block">
                                                    <label for="actualupload"><i class="fa fa-picture-o" style="cursor: pointer;"></i>
                                                        <a data-toggle="input" data-target="#actualupload" style="cursor: pointer; display: inline-block;">Carregar Imagem do Evento</a>
                                                    </label>
                                                </h4>
                                                <small style="color:red;"> (opcional)</small>  
                                            </div>
                                            <input id="actualupload" type="file" hidden onchange="file_path_display.innerHTML = actualupload.value">
                                            <div id="file_path_display"></div>                     
                                        </div>                                    
                                        <div class="form-group">
                                            <div class="form-row">
                                                <label for="urlFacebook">URL do evento no Facebook</label>  
                                                <input class="form-control" id="urlFacebook" type="text" placeholder="https://facebook.com/events/...">
                                                <small style="color:red;"> (opcional)</small>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <label for="urlWebsite">URL do Website do Organizador</label>  
                                                <input class="form-control" id="urlWebsite" type="text" placeholder="https://seuwebsite.com">
                                                <small style="color:red;"> (opcional)</small>
                                            </div>
                                        </div>
                                        <div class="form-group form-row form-check">
                                            <input type="checkbox" class="form-check-input" id="certificado">
                                            <label class="form-check-label" for="certificado" data-toggle="tooltip" >
                                                Emite certificado aos participantes
                                            </label>
                                        </div>
                                        <div class="form-group form-row form-check">
                                            <input type="checkbox" class="form-check-input" id="publico" checked>
                                            <label class="form-check-label" for="publico" data-toggle="tooltip" title="No modo Privado, todos os participantes terão que fazer uma requisição para participar do evento.">
                                                Evento público
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-block">
                                            <span class="glyphicon glyphicon-off"></span> Criar Evento
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 float-right">
                            <div class="card w-100 p-3">
                                <div class="card-body">
                                    
                                    <div>
                                        <button class="novaSecaobtn" data-toggle="modal" data-target="#novaSecaoModal">
                                            <span>Nova Seção </span>
                                        </button>
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
                </div>
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

