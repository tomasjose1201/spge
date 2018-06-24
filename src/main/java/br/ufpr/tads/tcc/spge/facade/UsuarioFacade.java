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
        dao = new UsuarioDao();
    }

    public int cadastrarUsuario(Usuario user, String areaInteresse1, String areaInteresse2,
            String areaInteresse3) throws SQLException {
        int a1, a2, a3;
        a1 = a2 = a3 = 0;
        if (!areaInteresse1.equals("")) {
            a1 = Integer.parseInt(areaInteresse1);
        }
        if (!areaInteresse2.equals("")) {
            a2 = Integer.parseInt(areaInteresse2);
        }
        if (!areaInteresse3.equals("")) {
            a3 = Integer.parseInt(areaInteresse3);
        }
        return dao.insert(user, a1, a2, a3);
    }
    
    public void atualizarUsuario(Usuario user, String areaInteresse1, String areaInteresse2,
            String areaInteresse3) throws SQLException {
        int a1, a2, a3;
        a1 = a2 = a3 = 0;
        if (!areaInteresse1.equals("")) {
            a1 = Integer.parseInt(areaInteresse1);
        }
        if (!areaInteresse2.equals("")) {
            a2 = Integer.parseInt(areaInteresse2);
        }
        if (!areaInteresse3.equals("")) {
            a3 = Integer.parseInt(areaInteresse3);
        }
        dao.update(user, a1, a2, a3);
    }
    
    public void atualizarSenha(Usuario user) throws SQLException {
        dao.updateSenha(user);
    }

    public boolean validarEmail(String email) throws SQLException {
        return dao.existsEmail(email);
    }
    
    public Usuario buscarUsuario(String email) throws SQLException {
        return dao.selectByEmail(email);
    }
    
    public Usuario buscarUsuario(int id) throws SQLException {
        return dao.selectById(id);
    }

    public boolean validarCpf(String cpf) throws SQLException {
        return dao.existsCpf(cpf);
    }
}
