<%-- 
    Document   : cadastro
    Created on : 04/04/2018, 16:05:02
    Author     : Tom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <div class="form-group col-sm-4">
                                <label for="cpf"><span class="glyphicon glyphicon-eye-open"></span> CPF</label>
                                <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Digite seu cpf" required>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="rg"><span class="glyphicon glyphicon-eye-open"></span> RG</label>
                                <input type="text" class="form-control" name="rg" placeholder="Digite seu rg" required>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="telefone"><span class="glyphicon glyphicon-eye-open"></span> Telefone</label>
                                <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Digite seu telefone" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="endereco"><span class="glyphicon glyphicon-eye-open"></span> Endereço</label>
                                <input type="text" class="form-control" name="endereco" placeholder="Ex.: Rua Exemplo, 1 - Bairro, Cidade" required>
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
                            <div class="form-group col-sm-4">
                                <label for="areaInteresse1">Área de Interesse 1: </label>
                                <select class="custom-select" id="areaInteresse1">
                                    <option selected></option>
                                    <c:forEach var="area" items="${areas}">
                                        <option value="${area.idAreaInteresse}"><c:out value="${area.nome}" /></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="areaInteresse2">Área de Interesse 2: </label>
                                <select class="custom-select" id="areaInteresse2">
                                    <option selected></option>
                                    <c:forEach var="area" items="${areas}">
                                        <option value="${area.idAreaInteresse}"><c:out value="${area.nome}" /></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="areaInteresse3">Área de Interesse 3: </label>
                                <select class="custom-select" id="areaInteresse3">
                                    <option selected></option>
                                    <c:forEach var="area" items="${areas}">
                                        <option value="${area.idAreaInteresse}"><c:out value="${area.nome}" /></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group checkbox col-sm-12">
                                <label>
                                    <input type="checkbox" name="estudante" id="checkEstudante">Sou estudante
                                    <input type="hidden" name="estudante" value="N">
                                </label>
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

    $(document).ready(function () {
        $("#cpf").mask("999.999.999-99");
    });

    $(document).ready(function () {
        $("#telefone").mask("(99)999999999");
    });

    document.getElementById('areaInteresse1').onchange = function () {
        if ((this.value) === (document.getElementById('areaInteresse2').value)) {
            alert("ATENÇÃO: a Área de Interesse 1 não pode ser igual a Área de Interesse 2.");
            this.value = '';
        } else if ((this.value) === (document.getElementById('areaInteresse3').value)) {
            alert("ATENÇÃO: a Área de Interesse 1 não pode ser igual a Área de Interesse 3.");
            this.value = '';
        }
    };
    
    document.getElementById('areaInteresse2').onchange = function () {
        if ((this.value) === (document.getElementById('areaInteresse1').value)) {
            alert("ATENÇÃO: a Área de Interesse 2 não pode ser igual a Área de Interesse 1.");
            this.value = '';
        } else if ((this.value) === (document.getElementById('areaInteresse3').value)) {
            alert("ATENÇÃO: a Área de Interesse 2 não pode ser igual a Área de Interesse 3.");
            this.value = '';
        }
    };
    
    document.getElementById('areaInteresse3').onchange = function () {
        if ((this.value) === (document.getElementById('areaInteresse1').value)) {
            alert("ATENÇÃO: a Área de Interesse 3 não pode ser igual a Área de Interesse 1.");
            this.value = '';
        } else if ((this.value) === (document.getElementById('areaInteresse2').value)) {
            alert("ATENÇÃO: a Área de Interesse 3 não pode ser igual a Área de Interesse 2.");
            this.value = '';
        }
    };

    document.getElementById('checkEstudante').onchange = function () {
        document.getElementById('numMatricula').disabled = !this.checked;
        document.getElementById('curso').disabled = !this.checked;
        document.getElementById('instituicao').disabled = !this.checked;
        document.getElementById('numMatricula').value = '';
        document.getElementById('curso').value = '';
        document.getElementById('instituicao').value = '';
        document.getElementById('checkEstudante').value = 'S';
        document.getElementById('numMatricula').required = true;
        document.getElementById('curso').required = true;
        document.getElementById('instituicao').required = true;
    };
</script>