/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ValidaDatas() {
    var dataInicio = new Date($('#dataHoraInicio').val());
    var dataEncerramento = new Date($('#dataHoraEncerramento').val());
    var dataEncerramentoIns = new Date($('#dataHoraEncerramentoInscricoes').val());
    var dtInicioEvento = new Date(parseInt($('#dtInicioEvento').val(),10));
    var dtEncerramentoEvento = new Date(parseInt($('#dtEncerramentoEvento').val(),10));
    var dtEncerramentoInsEvento = new Date(parseInt($('#dtEncerramentoInsEvento').val(),10));
    if(dataInicio < dtInicioEvento || dataInicio > dtEncerramentoEvento){
        alert("ATENÇÃO: a Data de Início da seção deve estar entre as datas de início e fim do evento." +
                " Preencha o campo novamente.");
        document.getElementById('dataHoraInicio').value = '';
    }
    if(dataEncerramento < dtInicioEvento || dataEncerramento > dtEncerramentoEvento) {
        alert("ATENÇÃO: a Data de Encerramento da seção deve estar entre as datas de início e fim do evento." +
                " Preencha o campo novamente.");
        document.getElementById('dataHoraEncerramento').value = '';
    }
    
    if (dataInicio >= dataEncerramento) {
        alert("ATENÇÃO: a Data de Início não pode ser maior ou igual a Data de Encerramento da seção." +
                " Preencha os campos novamente.");
        document.getElementById('dataHoraInicio').value = '';
        document.getElementById('dataHoraEncerramento').value = '';
    }
    if (dataEncerramentoIns > dataInicio || dataEncerramentoIns < dtEncerramentoInsEvento) {
        alert("ATENÇÃO: a Data de Encerramento das Inscrições não pode ser maior que a Data de Início da seção" +
                " nem menor que a Data de Encerramento das Inscrições do evento." +
                " Preencha o campo novamente.");
        document.getElementById('dataHoraEncerramentoInscricoes').value = '';
    }
}

