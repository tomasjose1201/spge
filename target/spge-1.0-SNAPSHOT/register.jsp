<%-- 
    Document   : register
    Created on : 08/04/2018, 18:17:08
    Author     : kaueholt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="padding:3%; width: 132%">
            <div class="modal-header">
                <h5 class="modal-title" id="registerModalLabel">Criar conta</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-footer" style="padding-right:10%; border-bottom: 15px solid transparent">
                <form>
                    <div class="form-group">
                        <label for="InputEmail">Nome Completo*</label>
                        <input class="form-control" id="InputName" type="text" aria-describedby="name" placeholder="Nome e Sobrenome">
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-7">
                                <label for="InputName">Email</label>
                                <input class="form-control" id="InputEmail" type="email" aria-describedby="email" placeholder="email@exemplo.com">
                            </div>
                            <div class="col-md-5">
                                <label for="InputLastName">CPF*</label>
                                <input class="form-control" id="InputCPF" type="text" aria-describedby="CPF" placeholder="Seu CPF">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="InputPassword">Senha</label>
                                <input class="form-control" id="InputPassword1" type="password" placeholder="Senha">
                            </div>
                            <div class="col-md-6">
                                <label for="ConfirmPassword">Confirmar senha</label>
                                <input class="form-control" id="ConfirmPassword" type="password" placeholder="Re-digite a senha">
                            </div>
                        </div>
                    </div>
                    <p><small style="font-size:.9em"><i>*Nome e CPF serão impressos nos certificados de participação.</i></small></p>
                    <p><small style="font-size:.9em">Ao clicar em Registrar, você está concordando com os <a href="../about.html">Termos de Licença e Uso</a>.</small></p>
                    <a class="btn btn-primary btn-block" href="UsuarioController">Registrar</a>
                </form>
            </div>
        </div>
    </div>
</div>
