<%-- 
    Document   : trocasenha
    Created on : 11/05/2018, 13:38:48
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModalSenha" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4><span class="glyphicon glyphicon-lock"></span> Trocar Senha</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form role="form" action="UsuarioController?action=updateSenha&step=1" method="POST">
                        <div class="form-group">
                            <label for="email"><span class="glyphicon glyphicon-user"></span>Ao preencher o campo abaixo você receberá um email para trocar de senha:</label>
                            <input type="email" class="form-control" name="email" placeholder="Digite seu email" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> Enviar</button>
                    </form>
                </div>
            </div>

        </div>
    </div> 
</div>

<script>
    $(document).ready(function () {
        $("#myBtnSenha").click(function () {
            $("#myModalSenha").modal();
        });
    });
</script>