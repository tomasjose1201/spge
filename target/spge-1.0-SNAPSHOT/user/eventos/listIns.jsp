<%-- 
    Document   : listIns
    Created on : 29/04/2018, 12:10:56
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- Head -->
    <jsp:include page="../include/head.jsp"/>
    <script src="user/vendor/jquery/jquery.min.js"></script>
    <script src="user/js/moment.js"></script>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <jsp:include page="../include/nav.jsp"/>

        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-check"></i> Minhas Inscrições
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th width="18%">Nome do Evento</th>
                                        <th width="15%">Início</th>
                                        <th width="15%">Encerramento</th>
                                        <th>Localização</th>
                                        <th>Tipo</th>
                                        <th width="5%">Status Confirmação</th>
                                        <th width="5%">Status Presença</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="inscricao" items="${lista}">
                                        <tr>
                                            <td>
                                                <c:if test="${inscricao.evento.contemSecoes=='S'}">
                                                    <a href="#" class="btnInscrSecoes" data-ide="${inscricao.evento.idEvento}" data-idc="${inscricao.convidado.idConvidado}">
                                                        <c:out value="${inscricao.evento.nome}"/>
                                                    </a>
                                                </c:if>
                                                <c:if test="${inscricao.evento.contemSecoes=='N'}">
                                                    <c:out value="${inscricao.evento.nome}"/>
                                                </c:if>
                                            </td>
                                            <td><c:out value="${inscricao.evento.dataHoraInicioF}"/></td>
                                            <td><c:out value="${inscricao.evento.dataHoraEncerramentoF}"/></td>
                                            <td><c:out value="${inscricao.evento.endereco}"/></td>
                                            <td><c:out value="${inscricao.evento.tipoEvento}"/></td>
                                            <td><c:out value="${(inscricao.statusConfirmacao=='C') ? 'Confirmado' : 'Pendente'}"/></td>
                                            <td><c:out value="${(inscricao.statusPresenca=='A') ? 'Ausente' : 'Presente'}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <!-- Modal -->
                <div class="modal fade" id="myModalInscricoes" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4><span class="glyphicon glyphicon-lock"></span>Seções</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Você está inscrito nas seções abaixo:</p>
                                <ul id="dataList"></ul>
                                <div class="templates">
                                    <div id="listItem">
                                        <div class="row1">
                                            <strong><div class="nome"></div></strong>
                                            <div class="linha1"></div>
                                            <div class="linha2"></div>
                                            <div class="linha3"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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

            <script>
                $(".btnInscrSecoes").on("click", function (e) {
                    e.preventDefault();
                    var idEvento = $(this).data('ide');
                    var idConvidado = $(this).data('idc');
                    var url = "ConvidadoController?action=secoesConvidado";
                    $.ajax({
                        url: url,
                        data: {
                            idEvento: idEvento,
                            idConvidado: idConvidado
                        },
                        dataType: 'json',
                        success: function (data) {
                            var dataObject = JSON.parse(JSON.stringify(data));
                            var listItemString = $('#listItem').html();

                            dataObject.forEach(buildNewList);

                            function buildNewList(item, index) {
                                var listItem = $('<li>' + listItemString + '</li>');
                                var listItemNome = $('.nome', listItem);
                                listItemNome.html(item.secao.nome);
                                var listItemLinha1 = $('.linha1', listItem);
                                listItemLinha1.html('Local: ' + item.secao.local);
                                var listItemLinha2 = $('.linha2', listItem);
                                listItemLinha2.html('Início/Encerramento: ' + moment(item.secao.dataHoraInicio).format('DD/MM/YYYY hh:mm') + ' | ' + moment(item.secao.dataHoraEncerramento).format('DD/MM/YYYY hh:mm'));
                                var listItemLinha3 = $('.linha3', listItem);
                                listItemLinha3.html('Status Presença: ' + (item.statusPresenca == 'A' ? 'Ausente' : 'Presente'));
                                $('#dataList').append(listItem);
                            }
                            $("#myModalInscricoes").modal();
                        }
                        ,
                        error: function (request, textStatus, errorThrown) {
                            alert(request.status + ', Error: ' + request.statusText);
                        }
                    });
                    $('#dataList').empty();
                });


            </script>
        </div>
    </body>

</html>
