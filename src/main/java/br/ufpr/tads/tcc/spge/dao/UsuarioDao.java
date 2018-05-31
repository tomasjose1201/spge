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

    private final String stmtSelectByEmail = "select * from usuario where email = ? and senha = ?";
    private final String stmtSelectOnlyByEmail = "select * from usuario where email = ?";
    private final String stmtSelectById = "select * from usuario where idUsuario = ?";
    private final String stmtInsert = "insert into usuario values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String stmtInsertAreas = "insert into usuario_area_interesse values (?, ?)";
    private final String stmtExistsEmail = "select * from usuario where email = ?";
    private final String stmtExistsCpf = "select * from usuario where cpf = ?";
    private final String stmtUpdate = "update usuario set nome = ?, rg = ?, endereco = ?, telefone = ?, email = ?, estudante = ?, numMatricula = ?, curso = ?, instituicao = ? where idUsuario = ?";
    private final String stmtDeleteAreas = "delete from usuario_area_interesse where idUsuario = ?";
    private final String stmtUpdateSenha = "update usuario set senha = ? where idUsuario = ?";
    private Connection con;

    public UsuarioDao() throws SQLException {
    }

    public Usuario selectByEmail(Usuario user) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtSelectByEmail);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNome(rs.getString("nome"));
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
            }
            return usu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public Usuario selectByEmail(String email) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtSelectOnlyByEmail);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNome(rs.getString("nome"));
                usu.setEmail(rs.getString("email"));
            }
            return usu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public Usuario selectById(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNome(rs.getString("nome"));
                usu.setEmail(rs.getString("email"));
                usu.setCpf(rs.getString("cpf"));
                usu.setRg(rs.getString("rg"));
                usu.setEndereco(rs.getString("endereco"));
                usu.setTelefone(rs.getString("telefone"));
                usu.setSenha(rs.getString("senha"));
                usu.setEstudante(rs.getString("estudante"));
                usu.setNumMatricula(rs.getString("numMatricula"));
                usu.setCurso(rs.getString("curso"));
                usu.setInstituicao(rs.getString("instituicao"));
            }
            return usu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public boolean existsEmail(String email) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtExistsEmail);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setEmail(rs.getString("email"));
            }
            if (usu != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public boolean existsCpf(String cpf) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            Usuario usu = null;
            stmt = con.prepareStatement(stmtExistsCpf);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setCpf(rs.getString("cpf"));
            }
            if (usu != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public void insert(Usuario user, int a1, int a2, int a3) throws SQLException {
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
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
            if (a1 != 0) {
                insertAreas(user, a1);
            }
            if (a2 != 0) {
                insertAreas(user, a2);
            }
            if (a3 != 0) {
                insertAreas(user, a3);
            }
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
        Usuario usu = null;
        try {
            stmt = con.prepareStatement(stmtSelectOnlyByEmail);
            stmt.setString(1, user.getEmail());
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

    public void update(Usuario user, int a1, int a2, int a3) throws SQLException {
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtUpdate);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getRg());
            stmt.setString(3, user.getEndereco());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getEstudante());
            stmt.setString(7, user.getNumMatricula());
            stmt.setString(8, user.getCurso());
            stmt.setString(9, user.getInstituicao());
            stmt.setInt(10, user.getIdUsuario());
            stmt.execute();
            stmt = con.prepareStatement(stmtDeleteAreas);
            stmt.setInt(1, user.getIdUsuario());
            stmt.execute();
            if (a1 != 0) {
                insertAreas(user, a1);
            }
            if (a2 != 0) {
                insertAreas(user, a2);
            }
            if (a3 != 0) {
                insertAreas(user, a3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
    
    public void updateSenha(Usuario user) throws SQLException {
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtUpdateSenha);
            stmt.setString(1, user.getSenha());
            stmt.setInt(2, user.getIdUsuario());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
}
