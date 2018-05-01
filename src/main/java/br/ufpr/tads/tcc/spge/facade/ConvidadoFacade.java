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
    
    public ArrayList<ConvidadoEvento> listarParticipantes(int idEvento) throws SQLException {
        return dao.selectPartById(idEvento);
    }
}
