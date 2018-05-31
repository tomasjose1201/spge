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
public class ConvidadoSecao implements Serializable {
    private Convidado convidado;
    private Secao secao;
    private String contatoRealizado;
    private String statusConfirmacao;
    private Date dataHoraConfirmacao;
    private String statusPresenca;
    private Date dataHoraPresenca;
    private String tipoConvidado;

    public ConvidadoSecao() {
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
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
        if (getDataHoraConfirmacao() != null) {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return f.format(getDataHoraConfirmacao());
        }
        return null;
    }

    public void setDataHoraConfirmacao(Date dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }
    
    public String getStatusPresenca() {
        return statusPresenca;
    }

    public void setStatusPresenca(String statusPresenca) {
        this.statusPresenca = statusPresenca;
    }

    public Date getDataHoraPresenca() {
        return dataHoraPresenca;
    }
    
    public String getDataHoraPresencaF(){
        if (getDataHoraPresenca() != null) {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return f.format(getDataHoraPresenca());
        }
        return null;
    }

    public void setDataHoraPresenca(Date dataHoraPresenca) {
        this.dataHoraPresenca = dataHoraPresenca;
    }

    public String getTipoConvidado() {
        return tipoConvidado;
    }

    public void setTipoConvidado(String tipoConvidado) {
        this.tipoConvidado = tipoConvidado;
    }
    
    
}
