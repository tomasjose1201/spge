<%-- 
    Document   : confirmS
    Created on : 01/05/2018, 20:06:21
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="modal fade" id="confirmSModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Deseja confirmar sua participação na seção?</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form action="ConvidadoController?action=confirmPart&obj=secao" method="POST">
                    <div class="modal-body">
                        Se desejar continuar, confirme abaixo.
                        <input id="idSecao" name="idSecao" type="hidden" />
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-success">
                            Confirmar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $(".confirmSModalBtn").click(function () {
        var id = $(this).data('id');
        document.getElementById('idSecao').value = id;
        $("#confirmSModal").modal();
    });
</script>
