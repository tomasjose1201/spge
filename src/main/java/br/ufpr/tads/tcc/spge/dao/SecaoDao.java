/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.Secao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Tom
 */
public class SecaoDao {
    
    private final String stmtInsert = "insert into secao values(null, ?, ?, ?, ?, ?, ?, ?)";
    private Connection con;

    public SecaoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }
    
    public void insert(Secao secao) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtInsert);
            stmt.setInt(1, secao.getIdEvento());
            stmt.setString(2, secao.getNome());
            stmt.setString(3, secao.getLocal());
            stmt.setString(4, secao.getDescricao());
            Timestamp tsInicio = new Timestamp(secao.getDataHoraInicio().getTime());
            stmt.setTimestamp(5, tsInicio);
            Timestamp tsEncerramento = new Timestamp(secao.getDataHoraEncerramento().getTime());
            stmt.setTimestamp(6, tsEncerramento);
            Timestamp tsEncInscricoes = new Timestamp(secao.getDataHoraEncerramentoInscricoes().getTime());
            stmt.setTimestamp(7, tsEncInscricoes);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
}
