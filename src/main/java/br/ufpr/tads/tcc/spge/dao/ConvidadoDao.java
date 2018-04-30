/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.Convidado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tom
 */
public class ConvidadoDao {

    private final String stmtInsert = "insert into convidado values (null, ?, ?, ?)";
    private final String stmtSearchConvidado = "select * from convidado where email = ?";
    private Connection con;

    public ConvidadoDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public int insert(Convidado convidado) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Convidado resp = null;
            int idConvidado = 0;
            stmt = con.prepareStatement(stmtSearchConvidado);
            stmt.setString(1, convidado.getEmail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                resp = new Convidado();
                resp.setIdConvidado(rs.getInt("idConvidado"));
                resp.setNome(rs.getString("nome"));
                resp.setEmail(rs.getString("email"));
                resp.setIdUsuario(rs.getInt("idUsuario"));
            }
            if (resp == null) {
                stmt = con.prepareStatement(stmtInsert);
                stmt.setString(1, convidado.getNome());
                stmt.setString(2, convidado.getEmail());
                stmt.setInt(3, convidado.getIdUsuario());
                stmt.execute();
                stmt = con.prepareStatement("select last_insert_id()");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    idConvidado = rs.getInt(1);
                }
            } else {
                idConvidado = resp.getIdConvidado();
            }
            return idConvidado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }
}
