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
public class LoginFacade {
    private UsuarioDao dao;

    public LoginFacade() throws SQLException {
        this.dao = new UsuarioDao();
    }
    
    public Usuario autenticarUsuario(Usuario user) {
        try {
            Usuario retorno = new Usuario();
            retorno = dao.selectById(user);
            return retorno;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
