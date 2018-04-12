<%-- 
    Document   : login
    Created on : 08/04/2018, 15:26:17
    Author     : kaueholt, Tom, Wes, Bruno?
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true" style="right:-5%; top:5%">
    <div class="modal-dialog" role="document">
        <div class="modal-content col-md-12">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Login</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-footer col-md-11 mt-3" style="display: block;margin-left: auto;margin-right: auto;border-top:none;">
                <form role="form" action="LoginController" method="POST">
                    <div class="form-group col-md-11" style="display: block;margin-left: auto;margin-right: auto;border-top:none;">
                        <div class="form-row">
                            <label for="exampleInputEmail1">CPF</label>
                            <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Entre com seu CPF">
                        </div>
                    </div>
                    <div class="form-group col-md-11 mt-1" style="display: block;margin-left: auto;margin-right: auto;border-top:none;">
                        <div class="form-row">
                            <label for="exampleInputPassword1">Senha</label>
                            <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Senha">
                        </div>
                    </div>
                    <div class="form-group col-md-11 mt-4 mb-3" style="display: block;margin-left: auto;margin-right: auto;border-top:none;">
                        <div class="form-row">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox">Lembrar senha</label>
                            </div>
                        </div>
                    </div>
                    <a class="btn btn-primary btn-block" href="/user">Acessar!</a>
                </form>
            </div>
            <div class="text-center">
                <h4><a class="d-block medium mt-2" data-dismiss="modal" data-toggle="modal" data-target="#registerModal" href="#" style="padding-top: 3%;border-top: 1px solid cornflowerblue">Criar conta</a></h4>
                <h5><a class="d-block small mt-3 mb-4" data-dismiss="modal" data-toggle="modal" data-target="#recoverModal" href="#">Esqueci minha senha</a></h5>
            </div>
        </div>
    </div>
</div>

