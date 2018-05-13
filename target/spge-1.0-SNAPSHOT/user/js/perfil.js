/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#telefone").mask("(99)999999999");
});

$(document).ready(function () {
    $('#areaInteresse1').val($('#a1').val());
    $('#areaInteresse2').val($('#a2').val());
    $('#areaInteresse3').val($('#a3').val());
});

document.getElementById('areaInteresse1').onchange = function () {
    if ((this.value) === (document.getElementById('areaInteresse2').value)) {
        alert("ATENÇÃO: a Área de Interesse 1 não pode ser igual a Área de Interesse 2.");
        this.value = '';
    } else if ((this.value) === (document.getElementById('areaInteresse3').value)) {
        alert("ATENÇÃO: a Área de Interesse 1 não pode ser igual a Área de Interesse 3.");
        this.value = '';
    }
};

document.getElementById('areaInteresse2').onchange = function () {
    if ((this.value) === (document.getElementById('areaInteresse1').value)) {
        alert("ATENÇÃO: a Área de Interesse 2 não pode ser igual a Área de Interesse 1.");
        this.value = '';
    } else if ((this.value) === (document.getElementById('areaInteresse3').value)) {
        alert("ATENÇÃO: a Área de Interesse 2 não pode ser igual a Área de Interesse 3.");
        this.value = '';
    }
};

document.getElementById('areaInteresse3').onchange = function () {
    if ((this.value) === (document.getElementById('areaInteresse1').value)) {
        alert("ATENÇÃO: a Área de Interesse 3 não pode ser igual a Área de Interesse 1.");
        this.value = '';
    } else if ((this.value) === (document.getElementById('areaInteresse2').value)) {
        alert("ATENÇÃO: a Área de Interesse 3 não pode ser igual a Área de Interesse 2.");
        this.value = '';
    }
};

document.getElementById('checkEstudante').onchange = function () {
    document.getElementById('numMatricula').disabled = !this.checked;
    document.getElementById('curso').disabled = !this.checked;
    document.getElementById('instituicao').disabled = !this.checked;
    document.getElementById('numMatricula').value = '';
    document.getElementById('curso').value = '';
    document.getElementById('instituicao').value = '';
    document.getElementById('checkEstudante').value = 'S';
    document.getElementById('numMatricula').required = true;
    document.getElementById('curso').required = true;
    document.getElementById('instituicao').required = true;
};


