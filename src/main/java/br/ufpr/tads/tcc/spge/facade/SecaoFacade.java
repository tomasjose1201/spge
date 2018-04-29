/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.SecaoDao;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Secao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class SecaoFacade {
    private SecaoDao dao;
    
    public SecaoFacade() throws SQLException {
        this.dao = new SecaoDao();
    }
    
    public void cadastrarSecao(Secao secao, Convidado responsavel) throws SQLException {
        dao.insert(secao, responsavel);
    }
    
    public ArrayList<Secao> listarSecoesDoEvento (int id) {
        ArrayList<Secao> secoes = new ArrayList();
        try {      
            secoes = dao.selectById(id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return secoes;
    }
}
