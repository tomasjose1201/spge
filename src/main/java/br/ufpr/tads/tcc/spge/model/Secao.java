/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tom
 */
public class Secao implements Serializable {
    private int idSecao;
    private int idEvento;
    private String nome;
    private String local;
    private String descricao;
    private Date dataHoraInicio;
    private Date dataHoraEncerramento;
    private Date dataHoraEncerramentoInscricoes;

    public Secao() {
    }

    public int getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }
    
    public String getDataHoraInicioF(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return f.format(getDataHoraInicio());
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraEncerramento() {
        return dataHoraEncerramento;
    }
    
    public String getDataHoraEncerramentoF(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return f.format(getDataHoraEncerramento());
    }

    public void setDataHoraEncerramento(Date dataHoraEncerramento) {
        this.dataHoraEncerramento = dataHoraEncerramento;
    }

    public Date getDataHoraEncerramentoInscricoes() {
        return dataHoraEncerramentoInscricoes;
    }
    
    public String getDataHoraEncerramentoInscricoesF(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return f.format(getDataHoraEncerramentoInscricoes());
    }

    public void setDataHoraEncerramentoInscricoes(Date dataHoraEncerramentoInscricoes) {
        this.dataHoraEncerramentoInscricoes = dataHoraEncerramentoInscricoes;
    }
}
