<%-- 
    Document   : login
    Created on : 03/04/2018, 19:07:37
    Author     : Tom
--%>
<jsp:include page="trocasenha.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModalLogin" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form role="form" action="LoginController?action=login" method="POST">
                        <div class="form-group">
                            <label for="email"><span class="glyphicon glyphicon-user"></span> Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Digite o email" required>
                        </div>
                        <div class="form-group">
                            <label for="senha"><span class="glyphicon glyphicon-eye-open"></span> Senha</label>
                            <input type="password" class="form-control" name="senha" placeholder="Digite a senha" required>
                        </div>
                        <!--<div class="checkbox">
                            <label><input type="checkbox" value="" checked>Remember me</label>
                        </div>-->
                        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                    </form>
                </div>
                <div align="center">
                    <p> Esqueceu a senha?
                        <a href="#" id="myBtnSenha" data-dismiss="modal" data-toggle="modal">Clique aqui</a>
                    </p>
                </div>
            </div>

        </div>
    </div> 
</div>

<script>
    $(document).ready(function () {
        $("#myBtnLogin").click(function () {
            $("#myModalLogin").modal();
        });
    });
</script>