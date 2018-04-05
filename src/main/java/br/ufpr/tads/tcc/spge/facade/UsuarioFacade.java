/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.facade;

import br.ufpr.tads.tcc.spge.dao.UsuarioDao;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Tom
 */
public class UsuarioFacade {
    private UsuarioDao dao;

    public UsuarioFacade() throws SQLException {
        this.dao = new UsuarioDao();
    }
    
    public void cadastrarUsuario(Usuario user) throws SQLException{
        dao.insert(user);
    }
}
