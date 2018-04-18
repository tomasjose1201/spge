<%-- 
    Document   : recover.jsp
    Created on : 09/04/2018, 22:33:16
    Author     : kaueholt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="recoverModal" tabindex="-1" role="dialog" aria-labelledby="recoverModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="recoverModalLabel">Recuperar Senha</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="text-center mt-4 mb-5">
                    <div class="row">
                        <h4>Esqueceu sua senha?</h4>
                    </div>
                    <div class="row">
                        <p>Entre com seu CPF, e um link de recuperação será encaminhado ao e-mail vinculado.</p>
                    </div>
                </div>
                <form>
                    <div class="row">
                        <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Informe seu CPF">
                    </div>
                    <div class="row">
                        <a class="btn btn-primary btn-block" href="login.html">Solicitar nova senha!</a>
                    </div>
                </form>
                <div class="row">
                    <div class="text-center">
                        <a class="d-block medium mt-3" href="register.html">Criar conta</a><br />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>