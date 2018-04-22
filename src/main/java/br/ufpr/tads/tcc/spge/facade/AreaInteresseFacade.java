/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.AreaInteresseDao;
import br.ufpr.tads.tcc.spge.model.AreaInteresse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class AreaInteresseFacade {
    private AreaInteresseDao dao;

    public AreaInteresseFacade() throws SQLException {
        this.dao = new AreaInteresseDao();
    }
    
    public ArrayList<AreaInteresse> getAreas () {
        ArrayList<AreaInteresse> areas = new ArrayList();
        try {      
            areas = dao.selectAll();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return areas;
    }
}
