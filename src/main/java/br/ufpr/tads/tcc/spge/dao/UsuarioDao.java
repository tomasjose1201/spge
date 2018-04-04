/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tom
 */
public class UsuarioDao {
    
    private final String stmtSelectById = "select * from usuario where email = ? and senha = ?";
    private Connection con;

    public UsuarioDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public Usuario selectById(String email, String senha) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
            }
            return usu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            stmt.close();
            rs.close();
            con.close();
        }
    }
}
