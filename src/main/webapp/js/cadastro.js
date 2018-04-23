/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#myBtnCadastro").click(function () {
        $("#myModalCadastro").modal();
    });
});

$(document).ready(function () {
    $("#cpf").mask("999.999.999-99");
});

function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF === "00000000000")
        return false;

    for (i = 1; i <= 9; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;
    if (Resto !== parseInt(strCPF.substring(9, 10)))
        return false;

    Soma = 0;
    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;
    if (Resto !== parseInt(strCPF.substring(10, 11)))
        return false;
    return true;
}

function ValidaCpf() {
    var strCpf = document.getElementById('cpf').value;
    strCpf = strCpf.replace(/[\.-]/g, "");
    if (!TestaCPF(strCpf)) {
        alert("ATENÇÃO: o CPF digitado é inválido.");
        document.getElementById('cpf').value = '';
    }
        
}

$(document).ready(function () {
    $("#telefone").mask("(99)999999999");
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
