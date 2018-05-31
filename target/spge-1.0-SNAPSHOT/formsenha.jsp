<%-- 
    Document   : formsenha
    Created on : 31/05/2018, 11:43:01
    Author     : Tom
--%>

<%-- 
    Document   : login
    Created on : 03/04/2018, 16:45:27
    Author     : Tom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SPGE - Troca de Senha</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/heroic-features.css" rel="stylesheet">

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="HomepageController" style="font-family: 'Trebuchet MS', Helvetica, sans-serif;">SPGE</a>
            </div>
        </nav>

        <div class="container my-5" align="center">
            <h3>Olá, ${nomeUsuario}</h3><br>
            <form role="form" action="UsuarioController?action=updateSenha&step=3&idUsuario=${idUsuario}" method="POST">
                <div class="row">
                    <div class="form-group col-sm-4"></div>
                    <div class="form-group col-sm-4">
                        <label for="senha"><span class="glyphicon glyphicon-eye-open"></span> Digite sua nova senha: </label>
                        <input type="password" class="form-control" name="senha" required>
                    </div>
                    <div class="form-group col-sm-4"></div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-4"></div>
                    <div class="form-group col-sm-4">
                        <label for="confirmSenha"><span class="glyphicon glyphicon-eye-open"></span> Digite novamente sua nova senha para confirmar: </label>
                        <input type="password" class="form-control" name="confirmSenha" required>
                    </div>
                    <div class="form-group col-sm-4"></div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-4"></div>
                    <div class="form-group col-sm-4">
                        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> Salvar</button>
                    </div>
                    <div class="form-group col-sm-4"></div>
                </div>
            </form>
        </div>
        <!-- Footer -->
        <footer class="footer py-4 bg-dark fixed-bottom">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; SPGE - Sistema de Planejamento e Gerenciamento de Eventos 2018</p>
            </div>
        </footer>
    </body>

</html>
