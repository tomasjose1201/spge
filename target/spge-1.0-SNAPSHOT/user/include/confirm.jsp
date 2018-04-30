<%-- 
    Document   : confirm
    Created on : 18/04/2018, 20:20:01
    Author     : Tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="modal fade" id="confirmModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Deseja confirmar sua participação?</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form action="ConvidadoController?action=confirmPart" method="POST">
                    <div class="modal-body">
                        Se desejar continuar, confirme abaixo.
                        <input id="idEvento" name="idEvento" type="hidden" />
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-success" href="ConvidadoController?action=confirmPart">
                            Confirmar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $(".confirmModalBtn").click(function () {
        var id = $(this).data('id');
        document.getElementById('idEvento').value = id;
        $("#confirmModal").modal();
    });
</script>
