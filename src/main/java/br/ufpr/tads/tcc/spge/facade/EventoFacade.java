/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.EventoDao;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Usuario;
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
        return dao.selectAll();
    }
    
    public ArrayList<Evento> getEventosAleatorios () throws SQLException {
        return dao.selectRandom();
    }

    public Evento getDetalhes(int idEvento) throws SQLException {
        return dao.selectById(idEvento);
    }
    
    public int cadastrarEvento(Evento evento) throws SQLException {
        return dao.insert(evento);
    }
    
    public void cadastrarConvidadoEvento (Convidado conv, int idEvento) throws SQLException {
        dao.insertConvidadoEvento(conv, idEvento);
    }
    
    public void confirmarConvidadoEvento (Convidado conv, int idEvento) throws SQLException {
        dao.confirmarConvidadoEvento(conv, idEvento);
    }
    
    public void confirmarPresenca (Convidado conv, int idEvento) throws SQLException {
        dao.confirmarPresenca(conv, idEvento);
    }

    public ArrayList<Evento> buscarEventosOrganizador(Usuario user) throws SQLException {
        return dao.selectEventosOrganizador(user);
    }

    public ArrayList<Evento> buscarFaturamentos(ArrayList<Evento> eventos) throws SQLException {
        return dao.selectFaturamentos(eventos);
    }

    public ArrayList<Evento> buscarEventosDestaque(int a1, int a2, int a3) throws SQLException {
        return dao.selectDestaques(a1, a2, a3);
    }
}
