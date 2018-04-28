/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.model;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public class Convidado implements Serializable {
    private int idConvidado;
    private String nome;
    private String email;
    private String tipoConvidado;
    private int idUsuario;

    public Convidado() {
    }

    public int getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(int idConvidado) {
        this.idConvidado = idConvidado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoConvidado() {
        return tipoConvidado;
    }

    public void setTipoConvidado(String tipoConvidado) {
        this.tipoConvidado = tipoConvidado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
