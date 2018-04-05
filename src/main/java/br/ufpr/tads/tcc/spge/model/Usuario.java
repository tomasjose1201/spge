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
public class Usuario implements Serializable, Authenticable {
    private String email;
    private String senha;

    public Usuario() {
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = Authenticable.Util.generateHash(String.format("#%s~@~%s#", getEmail(), senha));
    }
}
