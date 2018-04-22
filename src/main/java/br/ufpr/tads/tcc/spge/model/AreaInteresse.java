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
public class AreaInteresse implements Serializable{
    private int idAreaInteresse;
    private String nome;

    public AreaInteresse() {
    }

    public int getIdAreaInteresse() {
        return idAreaInteresse;
    }

    public void setIdAreaInteresse(int idAreaInteresse) {
        this.idAreaInteresse = idAreaInteresse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
