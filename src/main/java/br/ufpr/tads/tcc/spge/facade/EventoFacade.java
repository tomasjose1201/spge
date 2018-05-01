/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.EventoDao;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class EventoFacade {
    private EventoDao dao;

    public EventoFacade() throws SQLException {
        this.dao = new EventoDao();
    }
    
    public ArrayList<Evento> listarEventos () throws SQLException {
        /*ArrayList<Evento> eventos = new ArrayList();
        try {      
            eventos = ;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }*/
        return dao.selectAll();
    }

    public Evento getDetalhes(int idEvento) {
        Evento evento = new Evento();
        try {      
            evento = dao.selectById(idEvento);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return evento;
    }
    
    public int cadastrarEvento(Evento evento) throws SQLException {
        return dao.insert(evento);
    }
    
    public void cadastrarConvidadoEvento (Convidado conv, int idEvento) throws SQLException {
        dao.insertConvidadoEvento(conv, idEvento);
    }
}
