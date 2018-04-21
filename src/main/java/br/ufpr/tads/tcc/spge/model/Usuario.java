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
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    private String estudante;
    private String numMatricula;
    private String curso;
    private String instituicao;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstudante() {
        return estudante;
    }

    public void setEstudante(String estudante) {
        this.estudante = estudante;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
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
