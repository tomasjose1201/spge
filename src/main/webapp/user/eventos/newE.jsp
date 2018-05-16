<%-- 
    Document   : newE
    Created on : 08/04/2018, 22:41:19
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <!-- Head -->
    <jsp:include page="../include/head.jsp"/>
    <script src="user/vendor/jquery/jquery.min.js"></script>

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
                                <form action="EventoController?action=new" method="POST" onsubmit="return ValidaDatas(this)">
                                    <div class="form-group">
                                        <label for="nome">Nome do Evento</label>
                                        <input class="form-control" name="nome" id="nome" type="text" placeholder="Ex.: 3ª Semana Acadêmica do Curso de..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="endereco">Endereço</label>
                                        <input class="form-control" name="endereco" id="endereco" type="text" placeholder="Rua do Evento, 42 - Curitiba, PR" required>
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
                                            <label for="dataHoraEncerramentoInscricoes">Encerramento das Inscrições</label>
                                            <input type="datetime-local" class="form-control" name="dataHoraEncerramentoInscricoes" id="dataHoraEncerramentoInscricoes" placeholder="dd/mm/aaaa" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="numMaxParticipantes">Nº Máximo de Participantes</label>
                                            <input type="number" min="0" class="form-control" name="numMaxParticipantes" id="numMaxParticipantes" placeholder="0" required>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="preco">Preço</label>
                                            <input type="text" class="form-control" name="preco" id="preco" placeholder="0,00">
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
                                                            Upload <input type="file" onchange="uploadFile();">
                                                        </span>
                                                    </span>
                                                    <input type="text" class="form-control" readonly>
                                                    <input type="hidden" id="imgBase64" name="imgBase64">
                                                </div>
                                                <img id="img-upload" />
                                            </div>
                                        </div>                   
                                    </div>                                    
                                    <div class="form-group">
                                        <div class="form-row">
                                            <label for="urlFacebook">URL do evento no Facebook</label><small style="color:red;">  (opcional)</small>  
                                            <input class="form-control" name="urlFacebook" id="urlFacebook" type="text" placeholder="https://facebook.com/events/...">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-row">
                                            <label for="urlWebsite">URL do Website do Organizador</label><small style="color:red;">  (opcional)</small>  
                                            <input class="form-control" name="urlWebsite" id="urlWebsite" type="text" placeholder="https://seuwebsite.com">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group checkbox col-sm-4">
                                            <input type="checkbox" name="tipoEvento" value="Público" checked>
                                            <input type="hidden" name="tipoEvento" value="Privado" id="checkTipo">
                                            <label for="tipoEvento" data-toggle="tooltip" title="No modo Privado, todos os participantes terão que fazer uma requisição para participar do evento.">
                                                Evento público
                                            </label>
                                        </div>
                                        <div class="form-group checkbox col-sm-4">
                                            <input type="checkbox" name="emiteCertificado" id="checkCertificado">
                                            <input type="hidden" name="emiteCertificado" value="N">
                                            <label>
                                                Emitir certificado aos participantes
                                            </label>
                                        </div>
                                        <div class="form-group checkbox col-sm-4">
                                            <input type="checkbox" name="contemSecoes" id="checkSecoes">
                                            <input type="hidden" name="contemSecoes" value="N">
                                            <label for="contemSecoes" data-toggle="tooltip" title="Após o cadastro do evento você será redirecionado para o cadastro das seções.">
                                                Dividir o evento em seções
                                            </label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary" onClick="return ValidaDatas();">
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

