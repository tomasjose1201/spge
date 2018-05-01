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
public class ConvidadoEvento implements Serializable {
    private Convidado convidado;
    private Evento evento;
    private String contatoRealizado;
    private String statusConfirmacao;
    private Date dataHoraConfirmacao;
    private String tipoConvidado;

    public ConvidadoEvento() {
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getContatoRealizado() {
        return contatoRealizado;
    }

    public void setContatoRealizado(String contatoRealizado) {
        this.contatoRealizado = contatoRealizado;
    }

    public String getStatusConfirmacao() {
        return statusConfirmacao;
    }

    public void setStatusConfirmacao(String statusConfirmacao) {
        this.statusConfirmacao = statusConfirmacao;
    }

    public Date getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }
    
    public String getDataHoraConfirmacaoF(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return f.format(getDataHoraConfirmacao());
    }

    public void setDataHoraConfirmacao(Date dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

    public String getTipoConvidado() {
        return tipoConvidado;
    }

    public void setTipoConvidado(String tipoConvidado) {
        this.tipoConvidado = tipoConvidado;
    }
}
