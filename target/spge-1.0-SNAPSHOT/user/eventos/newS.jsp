<%-- 
    Document   : newS
    Created on : 08/04/2018, 22:36:27
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title" id="newETitles" >Nova Seção</h5>                
                        <form action="SecaoController?action=new" method="POST">
                            <div class="form-group">
                                <label for="nome">Nome da Seção</label>
                                <input class="form-control" name="nome" type="text" placeholder="Ex.: Palestra 'Criando Seções'" required>
                            </div>
                            <div class="form-group">
                                <label for="local">Local </label><small style="color:red"> (opcional) </small>
                                <input class="form-control" name="local" type="text" placeholder="Ex.: Auditório 2" >
                            </div>
                            <div class="form-group">
                                <label for="descricao">Descrição</label><small style="color:red"> (opcional) </small>
                                <textarea class="form-control" name="descricao" rows="5"></textarea>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-3">
                                    <label for="dataHoraInicio">Data/Horário de Início</label>
                                    <input type="datetime-local" class="form-control" name="dataHoraInicio" required>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="dataHoraEncerramento">Data/Horário de Encerramento</label>
                                    <input type="datetime-local" class="form-control" name="dataHoraEncerramento" required>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="dataHoraEncerramentoInscricoes">Encerramento das Inscrições</label>
                                    <input type="datetime-local" class="form-control" name="dataHoraEncerramentoInscricoes" id="dataHoraEncerramentoInscricoes" placeholder="dd/mm/aaaa" required>
                                </div>
                            </div>
                            <div class="hidden">
                                <input name="idEvento" type="hidden" value="${idEvento}"/>
                            </div>        
                            <button type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-off"></span> Adicionar Seção
                            </button>
                        </form>
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-check"></i> Seções Adicionadas
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th width="15%">Início</th>
                                        <th width="15%">Encerramento</th>
                                        <th>Local</th>
                                        <th>Descrição</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary">
                            <span class="glyphicon glyphicon-off"></span> Concluir Cadastro
                        </button>
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