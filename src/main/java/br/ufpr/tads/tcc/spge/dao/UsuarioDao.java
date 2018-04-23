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
    private final String stmtInsert = "insert into usuario values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String stmtInsertAreas = "insert into usuario_area_interesse values (?, ?);";
    private Connection con;

    public UsuarioDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public Usuario selectById(Usuario user) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
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
    
    public void insert(Usuario user, int a1, int a2, int a3) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtInsert);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getRg());
            stmt.setString(4, user.getEndereco());
            stmt.setString(5, user.getTelefone());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getSenha());
            stmt.setString(8, user.getEstudante());
            stmt.setString(9, user.getNumMatricula());
            stmt.setString(10, user.getCurso());
            stmt.setString(11, user.getInstituicao());
            stmt.execute();
            if(a1 != 0)
                insertAreas(user, a1);
            if(a2 != 0)
                insertAreas(user, a2);
            if(a3 != 0)
                insertAreas(user, a3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
    
    public void insertAreas(Usuario user, int idArea) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = new Usuario();
        try {
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
            }
            stmt = con.prepareStatement(stmtInsertAreas);
            stmt.setInt(1, usu.getIdUsuario());
            stmt.setInt(2, idArea);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
        }
    }
}
