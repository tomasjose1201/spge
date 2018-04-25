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
                                        <label for="nome">Nome do Evento</label>
                                        <input class="form-control" name="nome" id="nome" type="text" placeholder="Ex. 3º Festival Gastronômico de Cuiabá" required>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-row">
                                            <label for="endereco">Endereço</label>
                                            <input class="form-control" name="endereco" id="endereco" type="text" placeholder="Rua do Evento, 42 - Curitiba, PR" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="descricao">Descrição</label><small style="color:red"> (opcional) </small>
                                        <textarea class="form-control" name="descricao" rows="5" id="descricaoEvento"></textarea>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="dataHoraInicio">Data/Horário de Início</label>
                                            <input type="datetime-local" class="form-control" name="dataHoraInicio" id="dataHoraInicio" required>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dataHoraEncerramento">Data/Horário de Encerramento</label>
                                            <input type="datetime-local" class="form-control" name="dataHoraEncerramento" id="dataHoraEncerramento" required>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dataEncerramentoInscricoes">Encerramento das Inscrições</label>
                                            <input type="datetime-local" class="form-control" name="dataEncerramentoInscricoes" id="dataEncerramentoInscricoes" placeholder="dd/mm/aaaa" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="numMaxParticipantes">Nº Máximo de Participantes</label>
                                            <input type="number" min="0" class="form-control" name="numMaxParticipantes" id="numMaxParticipantes" placeholder="0" required>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="preco">Preço</label>
                                            <input type="number" class="form-control" name="preco" id="preco" placeholder="0,00">
                                            <small style="color:red"> (opcional) </small>
                                        </div>  
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Imagem do Evento</label><small style="color:red"> (opcional) </small>
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
                                            <label for="urlFacebook">URL do evento no Facebook</label><small style="color:red;">  (opcional)</small>  
                                            <input class="form-control" id="urlFacebook" type="text" placeholder="https://facebook.com/events/...">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-row">
                                            <label for="urlWebsite">URL do Website do Organizador</label><small style="color:red;">  (opcional)</small>  
                                            <input class="form-control" id="urlWebsite" type="text" placeholder="https://seuwebsite.com">
                                        </div>
                                    </div>
                                    <div class="form-group form-row form-check">
                                        <input type="checkbox" class="form-check-input" name="emiteCertificado" id="emiteCertificado">
                                        <label class="form-check-label" for="emiteCertificado" data-toggle="tooltip" >
                                            Emitir certificado aos participantes
                                        </label>
                                    </div>
                                    <div class="form-group form-row form-check">
                                        <input type="checkbox" class="form-check-input" name="tipoEvento" id="tipoEvento" checked>
                                        <label class="form-check-label" for="tipoEvento" data-toggle="tooltip" title="No modo Privado, todos os participantes terão que fazer uma requisição para participar do evento.">
                                            Evento público
                                        </label>
                                    </div>
                                    <div class="form-group form-row form-check">
                                        <input type="checkbox" class="form-check-input" name="contemSecoes" id="contemSecoes">
                                        <label class="form-check-label" for="contemSecoes" data-toggle="tooltip" title="Após o cadastro do evento você será redirecionado para o cadastro das seções.">
                                            Subdividir o evento em seções
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

