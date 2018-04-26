/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.SecaoDao;
import br.ufpr.tads.tcc.spge.model.Secao;
import java.sql.SQLException;

/**
 *
 * @author Tom
 */
public class SecaoFacade {
    private SecaoDao dao;
    
    public SecaoFacade() throws SQLException {
        this.dao = new SecaoDao();
    }
    
    public void cadastrarSecao(Secao secao) throws SQLException {
        dao.insert(secao);
    }
}
