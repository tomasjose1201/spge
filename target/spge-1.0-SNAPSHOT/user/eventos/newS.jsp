<%-- 
    Document   : newS
    Created on : 08/04/2018, 22:36:27
    Author     : kaueholt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- novaSecaoModal-->
<div class="modal fade" id="novaSecaoModal" tabindex="-1" role="dialog" aria-labelledby="novaSecaoLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="padding:7%; width: 150%" >
            <div class="modal-header">
                <h5 class="modal-title" id="novaSecaoLabel">Nova seção do evento</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-footer" style="padding-right:4%">
                <form>
                    <div class="form-group">
                        <label for="InputEmail">Nome da seção</label>
                        <input class="form-control" id="InputNomeSecao" type="text" aria-describedby="nomeSecao" placeholder="Ex.: Palestra 03 - Criando seções">
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-4">
                                <label for="inputDataSecao">Data</label>
                                <input class="form-control col-md-9" id="inputDataSecao" type="text" aria-describedby="dataSecao" placeholder="dd/mm/aaaa">
                            </div>
                            <div class="col-md-3">
                                <label for="inputHI">Horário Inicial</label>
                                <input class="form-control col-md-8" id="inputHI" type="text" aria-describedby="horaInicialSecao" placeholder="hh:mm">
                            </div>
                            <div class="col-md-3">
                                <label for="inputHF">Horário final</label>
                                <input class="form-control col-md-8" id="inputHF" type="text" aria-describedby="horaFinalSecao" placeholder="hh:mm">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label for="inputLocalSecao">Local</label>
                            <input class="form-control" id="inputLocalSecao" type="text" placeholder="Rua dos Eventos com Seção, 42">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label for="inputResponsavel">Responsáveis (separe com ponto e vírgula)</label>
                            <input class="form-control" id="inputResponsavel" type="text" placeholder="Albert Einstein; John Lennon; Marie Curie">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <input id="cbSecaoIsEvento" type="checkbox" value="secaoIsEvento" checked>
                            <label for="cbSecaoisEvento">Participantes do Evento-Pai são automaticamente cadastrados nessa seção.</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <a class="btn btn-primary btn-block" href="#" style="height:142%; margin-bottom: -30px">Gravar Seção</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
