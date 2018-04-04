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
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4><span class="glyphicon glyphicon-lock"></span> Cadastro</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form role="form" action="UsuarioController" method="POST">
                        <div class="form-group">
                            <label for="nome"><span class="glyphicon glyphicon-user"></span> Nome</label>
                            <input type="text" class="form-control" name="nome" placeholder="Digite seu nome" required>
                        </div>
                        <div class="form-group">
                            <label for="cpf"><span class="glyphicon glyphicon-eye-open"></span> CPF</label>
                            <input type="text" class="form-control" name="cpf" placeholder="Digite seu cpf" required>
                        </div>
                        <div class="form-group">
                            <label for="rg"><span class="glyphicon glyphicon-eye-open"></span> RG</label>
                            <input type="text" class="form-control" name="rg" placeholder="Digite seu rg" >
                        </div>
                        <div class="form-group">
                            <label for="endereco"><span class="glyphicon glyphicon-eye-open"></span> Endereço</label>
                            <input type="text" class="form-control" name="endereco" placeholder="Digite seu endereço">
                        </div>
                        <div class="form-group">
                            <label for="email"><span class="glyphicon glyphicon-eye-open"></span> Email</label>
                            <input type="text" class="form-control" name="email" placeholder="Digite seu email" required>
                        </div>
                        <div class="form-group">
                            <label for="telefone"><span class="glyphicon glyphicon-eye-open"></span> Telefone</label>
                            <input type="text" class="form-control" name="telefone" placeholder="Digite seu telefone" required>
                        </div>
                        <div class="form-group">
                            <label for="areasInteresse"><span class="glyphicon glyphicon-eye-open"></span> Áreas de Interesse</label>
                            <input type="text" class="form-control" name="areasInteresse" placeholder="Digite suas áreas de interesse" >
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" value="" checked>Sou estudante</label>
                        </div>
                        <div class="form-group">
                            <label for="numMatricula"><span class="glyphicon glyphicon-eye-open"></span> Número de Matrícula</label>
                            <input type="text" class="form-control" name="numMatricula" placeholder="Digite seu Nº de Matrícula" >
                        </div>
                        <div class="form-group">
                            <label for="curso"><span class="glyphicon glyphicon-eye-open"></span> Curso</label>
                            <input type="text" class="form-control" name="curso" placeholder="Digite seu curso" >
                        </div>
                        <div class="form-group">
                            <label for="instituicao"><span class="glyphicon glyphicon-eye-open"></span> Instituição de Ensino</label>
                            <input type="text" class="form-control" name="instituicao" placeholder="Digite sua instituição" >
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
</script>