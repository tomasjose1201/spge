<%-- 
    Document   : perfil
    Created on : 09/05/2018, 21:16:56
    Author     : Tom
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <c:if test="${msgEmail != null}">
                    <div class="alert alert-danger text-center">
                        <h5><c:out value="${msgEmail}" /></h5>
                    </div>
                </c:if>
                <c:if test="${msgAtualizado != null}">
                    <div class="alert alert-success text-center">
                        <h5><c:out value="${msgAtualizado}" /></h5>
                    </div>
                </c:if>    
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card p-3">
                            <div class="card-body">
                                <h5 class="card-title" id="perfilTitle" >Gerenciar Perfil</h5>
                                <form action="UsuarioController?action=update" method="POST">
                                    <div class="row">
                                        <div class="form-group col-sm-12">
                                            <label for="nome"><span class="glyphicon glyphicon-user"></span> Nome</label>
                                            <input type="text" class="form-control" name="nome" placeholder="Digite seu nome" value="${dadosUsuario.nome}" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-4">
                                            <label for="cpf"><span class="glyphicon glyphicon-eye-open"></span> CPF</label>
                                            <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Digite seu cpf" value="${dadosUsuario.cpf}" disabled>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="rg"><span class="glyphicon glyphicon-eye-open"></span> RG</label>
                                            <input type="text" class="form-control" name="rg" placeholder="Digite seu rg" value="${dadosUsuario.rg}" maxlength="15" required>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="telefone"><span class="glyphicon glyphicon-eye-open"></span> Telefone Celular</label>
                                            <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Digite seu telefone" value="${dadosUsuario.telefone}" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-12">
                                            <label for="endereco"><span class="glyphicon glyphicon-eye-open"></span> Endereço</label>
                                            <input type="text" class="form-control" name="endereco" placeholder="Ex.: Rua Exemplo, 1 - Bairro, Cidade" value="${dadosUsuario.endereco}" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="email"><span class="glyphicon glyphicon-eye-open"></span> Email</label>
                                            <input type="email" class="form-control" name="email" placeholder="Digite seu email" value="${dadosUsuario.email}" required>
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <br><br>
                                            <a href="#">Redefinir Senha</a>
                                        </div>    
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-4">
                                            <label for="areaInteresse1">Área de Interesse 1: </label>
                                            <select class="custom-select" name="areaInteresse1" id="areaInteresse1">
                                                <option selected></option>
                                                <c:forEach var="area" items="${areas}">
                                                    <option value="${area.idAreaInteresse}"><c:out value="${area.nome}" /></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="areaInteresse2">Área de Interesse 2: </label>
                                            <select class="custom-select" name="areaInteresse2" id="areaInteresse2">
                                                <option selected></option>
                                                <c:forEach var="area" items="${areas}">
                                                    <option value="${area.idAreaInteresse}"><c:out value="${area.nome}" /></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="areaInteresse3">Área de Interesse 3: </label>
                                            <select class="custom-select" name="areaInteresse3" id="areaInteresse3">
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
                                                <input type="checkbox" name="estudante" id="checkEstudante" <c:if test="${dadosUsuario.estudante == 'S'}">checked</c:if>> Sou estudante
                                                <input type="hidden" name="estudante" id="estudante" value="${dadosUsuario.estudante}">
                                            </label>
                                        </div>                          
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="numMatricula"><span class="glyphicon glyphicon-eye-open"></span> Número de Matrícula</label>
                                            <input type="text" class="form-control" name="numMatricula" id="numMatricula" placeholder="Digite seu Nº de Matrícula" value="${dadosUsuario.numMatricula}">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="curso"><span class="glyphicon glyphicon-eye-open"></span> Curso</label>
                                            <input type="text" class="form-control" name="curso" id="curso" placeholder="Digite seu curso" value="${dadosUsuario.curso}">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="instituicao"><span class="glyphicon glyphicon-eye-open"></span> Instituição de Ensino</label>
                                            <input type="text" class="form-control" name="instituicao" id="instituicao" placeholder="Digite sua instituição" value="${dadosUsuario.instituicao}">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <input type="hidden" id="a1" value="${areasUsu[0]}" />
                                        <input type="hidden" id="a2" value="${areasUsu[1]}" />
                                        <input type="hidden" id="a3" value="${areasUsu[2]}" />
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block">
                                        <span class="glyphicon glyphicon-off"></span> Salvar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <script src="user/js/perfil.js"></script>
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

