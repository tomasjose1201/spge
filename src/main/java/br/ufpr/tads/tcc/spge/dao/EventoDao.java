/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tom
 */
public class EventoDao {
    
    private final String stmtSelectAll = "select * from evento";
    private final String stmtSelectById = "select * from evento where idEvento = ?";
    private Connection con;

    public EventoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }
    
    public ArrayList<Evento> selectAll() throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSelectAll);
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setNome(rs.getString("nome"));
                novo.setDescricao(rs.getString("descricao"));
                novo.setDataHoraInicio(rs.getTimestamp("dataHoraInicio"));
                novo.setDataHoraEncerramento(rs.getTimestamp("dataHoraEncerramento"));
                novo.setDataHoraEncerramentoInscricoes(rs.getTimestamp("dataHoraEncerramentoInscricoes"));
                novo.setEndereco(rs.getString("endereco"));
                novo.setNumMaxParticipantes(rs.getInt("numMaxParticipantes"));
                novo.setEmiteCertificado(rs.getString("emiteCertificado"));
                novo.setContemSecoes(rs.getString("contemSecoes"));
                novo.setTipoEvento(rs.getString("tipoEvento"));
                novo.setPreco(rs.getDouble("preco"));
                novo.setFotoDestaque(rs.getString("fotoDestaque"));
                novo.setUrlWebsite(rs.getString("urlWebsite"));
                novo.setUrlEventoFacebook(rs.getString("urlEventoFacebook"));                
                lista.add(novo);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public Evento selectById(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setNome(rs.getString("nome"));
                novo.setDescricao(rs.getString("descricao"));
                novo.setDataHoraInicio(rs.getTimestamp("dataHoraInicio"));
                novo.setDataHoraEncerramento(rs.getTimestamp("dataHoraEncerramento"));
                novo.setDataHoraEncerramentoInscricoes(rs.getTimestamp("dataHoraEncerramentoInscricoes"));
                novo.setEndereco(rs.getString("endereco"));
                novo.setNumMaxParticipantes(rs.getInt("numMaxParticipantes"));
                novo.setEmiteCertificado(rs.getString("emiteCertificado"));
                novo.setContemSecoes(rs.getString("contemSecoes"));
                novo.setTipoEvento(rs.getString("tipoEvento"));
                novo.setPreco(rs.getDouble("preco"));
                novo.setFotoDestaque(rs.getString("fotoDestaque"));
                novo.setUrlWebsite(rs.getString("urlWebsite"));
                novo.setUrlEventoFacebook(rs.getString("urlEventoFacebook")); 
            }
            return novo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            stmt.close();
            rs.close();
            con.close();
        }
    }
}
