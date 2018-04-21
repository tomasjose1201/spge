<%-- 
    Document   : cadastro
    Created on : 04/04/2018, 16:05:02
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModalCadastro" role="dialog">
        <div class="modal-dialog modal-lg">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4><span class="glyphicon glyphicon-lock"></span> Cadastro</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form role="form-inline" action="UsuarioController?action=new" method="POST">
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="nome"><span class="glyphicon glyphicon-user"></span> Nome</label>
                                <input type="text" class="form-control" name="nome" placeholder="Digite seu nome" required>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="cpf"><span class="glyphicon glyphicon-eye-open"></span> CPF</label>
                                <input type="text" class="form-control" name="cpf" placeholder="Digite seu cpf" required>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="rg"><span class="glyphicon glyphicon-eye-open"></span> RG</label>
                                <input type="text" class="form-control" name="rg" placeholder="Digite seu rg" >
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="endereco"><span class="glyphicon glyphicon-eye-open"></span> Endereço</label>
                                <input type="text" class="form-control" name="endereco" placeholder="Digite seu endereço">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="email"><span class="glyphicon glyphicon-eye-open"></span> Email</label>
                                <input type="email" class="form-control" name="email" placeholder="Digite seu email" required>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="senha"><span class="glyphicon glyphicon-eye-open"></span> Senha</label>
                                <input type="password" class="form-control" name="senha" placeholder="Digite sua senha" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="telefone"><span class="glyphicon glyphicon-eye-open"></span> Telefone</label>
                                <input type="text" class="form-control" name="telefone" placeholder="Digite seu telefone" required>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="areasInteresse"><span class="glyphicon glyphicon-eye-open"></span> Áreas de Interesse</label>
                                <input type="text" class="form-control" name="areasInteresse" placeholder="Digite suas áreas de interesse" >
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group checkbox col-sm-12">
                                <label><input type="checkbox" id="checkEstudante">Sou estudante</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="numMatricula"><span class="glyphicon glyphicon-eye-open"></span> Número de Matrícula</label>
                                <input type="text" class="form-control" name="numMatricula" id="numMatricula" placeholder="Digite seu Nº de Matrícula" disabled>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="curso"><span class="glyphicon glyphicon-eye-open"></span> Curso</label>
                                <input type="text" class="form-control" name="curso" id="curso" placeholder="Digite seu curso" disabled>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="instituicao"><span class="glyphicon glyphicon-eye-open"></span> Instituição de Ensino</label>
                                <input type="text" class="form-control" name="instituicao" id="instituicao" placeholder="Digite sua instituição" disabled>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">
                            <span class="glyphicon glyphicon-off"></span> Salvar
                        </button>
                    </form>
                </div>

            </div>

        </div>
    </div> 
</div>

<script>
    $(document).ready(function () {
        $("#myBtnCadastro").click(function () {
            $("#myModalCadastro").modal();
        });
    });

    document.getElementById('checkEstudante').onchange = function () {
        document.getElementById('numMatricula').disabled = !this.checked;
        document.getElementById('curso').disabled = !this.checked;
        document.getElementById('instituicao').disabled = !this.checked;
        document.getElementById('numMatricula').value = '';
        document.getElementById('curso').value = '';
        document.getElementById('instituicao').value = '';
        document.getElementById('numMatricula').required = true;
        document.getElementById('curso').required = true;
        document.getElementById('instituicao').required = true;
    };
</script>