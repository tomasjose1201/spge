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

        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card p-3">
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
                                        <div class="form-group col-md-3">
                                            <label for="dataInicioEvento">Data de Início</label>
                                            <input type="date" class="form-control" name="dataInicioEvento" id="dataInicioEvento" placeholder="dd/mm/aaaa" required>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="horarioInicioEvento">Horário de Início</label>
                                            <input type="time" class="form-control" id="horarioInicioEvento">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="dataEncerramentoEvento">Data de Encerramento</label>
                                            <input type="date" class="form-control" id="dataEncerramentoEvento" placeholder="dd/mm/aaaa">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="horarioEncerramentoEvento">Horário de Encerramento</label>
                                            <input type="time" class="form-control" id="horarioEncerramentoEvento">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dataEncerramentoInscricoes">Encerramento das Inscrições</label>
                                            <input type="date" class="form-control" id="dataEncerramentoInscricoes" placeholder="dd/mm/aaaa">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="numMaxParticipantes">Nº Máximo de Participantes</label>
                                            <input type="number" min="0" class="form-control" id="numMaxParticipantes" placeholder="0">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="preco">Preço</label>
                                            <input type="number" class="form-control" id="preco" placeholder="0,00">
                                            <small style="color:red"> (opcional) </small>
                                        </div>  
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Imagem do Evento</label>
                                                <div class="input-group">
                                                    <span class="input-group-btn">
                                                        <span class="btn btn-link btn-file">
                                                            Upload <input type="file" id="imgInp">
                                                        </span>
                                                    </span>
                                                    <input type="text" class="form-control" readonly>
                                                </div>
                                                <img id='img-upload'/>
                                            </div>
                                        </div>                   
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
                </div>
                <script src="user/js/newE.js"></script>
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

