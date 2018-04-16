/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Tom
 */
public class Evento implements Serializable {
    private int idEvento;
    private String nome;
    private String descricao;
    private Date dataHoraInicio;
    private Date dataHoraEncerramento;
    private Date dataHoraEncerramentoInscricoes;
    private String endereco;
    private int numMaxParticipantes; 
    private String emiteCertificado;
    private String contemSecoes;
    private String tipoEvento;
    private double preco;
    private String fotoDestaque;
    private String urlWebsite;
    private String urlEventoFacebook;

    public Evento() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumMaxParticipantes() {
        return numMaxParticipantes;
    }

    public void setNumMaxParticipantes(int numMaxParticipantes) {
        this.numMaxParticipantes = numMaxParticipantes;
    }

    public String getEmiteCertificado() {
        return emiteCertificado;
    }

    public void setEmiteCertificado(String emiteCertificado) {
        this.emiteCertificado = emiteCertificado;
    }

    public String getContemSecoes() {
        return contemSecoes;
    }

    public void setContemSecoes(String contemSecoes) {
        this.contemSecoes = contemSecoes;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public double getPreco() {
        return preco;
    }
    
    public String getPrecoF() {
        Locale ptBr = new Locale("pt", "BR");
        String precoF = NumberFormat.getCurrencyInstance(ptBr).format(getPreco());
        return precoF;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFotoDestaque() {
        return fotoDestaque;
    }

    public void setFotoDestaque(String fotoDestaque) {
        this.fotoDestaque = fotoDestaque;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public String getUrlEventoFacebook() {
        return urlEventoFacebook;
    }

    public void setUrlEventoFacebook(String urlEventoFacebook) {
        this.urlEventoFacebook = urlEventoFacebook;
    }
}
