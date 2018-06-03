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
public class Aviso implements Serializable {
    private int idAviso;
    private int idEvento;
    private String nomeEvento;
    private String assunto;
    private String descricao;
    private Date dataHoraAviso;

    public Aviso() {
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraAviso() {
        return dataHoraAviso;
    }
    
    public String getDataHoraAvisoF(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return f.format(getDataHoraAviso());
    }

    public void setDataHoraAviso(Date dataHoraAviso) {
        this.dataHoraAviso = dataHoraAviso;
    }
    
    
}
