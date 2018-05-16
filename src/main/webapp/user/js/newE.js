/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.getElementById('checkCertificado').onchange = function () {
    document.getElementById('checkCertificado').value = 'S';
};

document.getElementById('checkSecoes').onchange = function () {
    document.getElementById('checkSecoes').value = 'S';
};

$(document).ready(function () {
    $("#preco").maskMoney({allowNegative: false, thousands: '.', decimal: ',', affixesStay: false});
});

function ValidaDatas() {
    var dataInicio = new Date($('#dataHoraInicio').val());
    var dataEncerramento = new Date($('#dataHoraEncerramento').val());
    var dataEncerramentoIns = new Date($('#dataHoraEncerramentoInscricoes').val());
    if (dataInicio < new Date()) {
        alert("ATENÇÃO: a Data de Início não pode ser menor que a data atual." +
                " Preencha o campo novamente.");
        document.getElementById('dataHoraInicio').value = '';
    }
    if (dataInicio >= dataEncerramento) {
        alert("ATENÇÃO: a Data de Início não pode ser maior ou igual a Data de Encerramento do evento." +
                " Preencha os campos novamente.");
        document.getElementById('dataHoraInicio').value = '';
        document.getElementById('dataHoraEncerramento').value = '';
    }
    if (dataEncerramentoIns > dataInicio) {
        alert("ATENÇÃO: a Data de Encerramento das Inscrições não pode ser maior que a Data de Início do evento." +
                " Preencha o campo novamente.");
        document.getElementById('dataHoraEncerramentoInscricoes').value = '';
    }
}

function uploadFile() {
    var target = document.querySelector("img");
    var file = document.querySelector("input[type=file]").files[0];

    var reader = new FileReader();

    $(document).on('change', '.btn-file :file', function () {
        var input = $(this),
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
        input.trigger('fileselect', [label]);
    });

    $('.btn-file :file').on('fileselect', function (event, label) {
        var input = $(this).parents('.input-group').find(':text'),
                log = label;
        if (input.length) {
            input.val(log);
        } else {
            if (log)
                alert(log);
        }
    });

    if (file) {
        reader.onloadend = function () {
            target.src = reader.result;
            $('#imgBase64').val(reader.result);
        };
        reader.readAsDataURL(file);
    } else {
        target.src = "";
    }
}

/*$(document).ready(function () {
 $(document).on('change', '.btn-file :file', function () {
 var input = $(this),
 label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
 input.trigger('fileselect', [label]);
 });
 
 $('.btn-file :file').on('fileselect', function (event, label) {
 
 var input = $(this).parents('.input-group').find(':text'),
 log = label;
 
 if (input.length) {
 input.val(log);
 } else {
 if (log)
 alert(log);
 }
 
 });
 function readURL(input) {
 if (input.files && input.files[0]) {
 var reader = new FileReader();
 
 reader.onload = function (e) {
 $('#img-upload').attr('src', e.target.result);
 $('#imgInp').val('NANDE');
 };
 reader.readAsDataURL(input.files[0]);
 }
 }
 
 $("#imgInp").change(function () {
 readURL(this);
 });
 });*/