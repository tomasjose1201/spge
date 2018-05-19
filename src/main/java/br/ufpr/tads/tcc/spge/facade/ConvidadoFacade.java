/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.ConvidadoDao;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class ConvidadoFacade {
    private ConvidadoDao dao;

    public ConvidadoFacade() {
        this.dao = new ConvidadoDao();
    }
    
    public int cadastrarConvidado(Convidado conv) throws SQLException {
        return dao.insert(conv);
    }
    
    public ArrayList<ConvidadoEvento> listarInscricoes(int idUsuario) throws SQLException {
        return dao.selectInscrById(idUsuario);
    }
    
    public ArrayList listarParticipantes(int idEvento, String flag) throws SQLException {
        return dao.selectPartById(idEvento, flag);
    }
    
    public Convidado getConvidado(int id) throws SQLException {
        return dao.getConvidado(id);
    }
    
    public void atualizarContatoRealizado(int idC, int idS, String s) throws SQLException {
        dao.atualizarContato(idC, idS, s);
    }
}
