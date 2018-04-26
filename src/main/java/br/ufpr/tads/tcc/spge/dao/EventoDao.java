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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tom
 */
public class EventoDao {
    
    private final String stmtSelectAll = "select * from evento";
    private final String stmtSelectById = "select * from evento where idEvento = ?";
    private final String stmtInsert = "insert into evento values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
    
    public int insert(Evento evento) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(stmtInsert);
            stmt.setString(1, evento.getNome());
            stmt.setString(2, evento.getDescricao());
            Timestamp tsInicio = new Timestamp(evento.getDataHoraInicio().getTime());
            stmt.setTimestamp(3, tsInicio);
            Timestamp tsEncerramento = new Timestamp(evento.getDataHoraEncerramento().getTime());
            stmt.setTimestamp(4, tsEncerramento);
            Timestamp tsEncInscricoes = new Timestamp(evento.getDataHoraEncerramentoInscricoes().getTime());
            stmt.setTimestamp(5, tsEncInscricoes); 
            stmt.setString(6, evento.getEndereco());
            stmt.setInt(7, evento.getNumMaxParticipantes());
            stmt.setString(8, evento.getEmiteCertificado());
            stmt.setString(9, evento.getContemSecoes());
            stmt.setString(10, evento.getTipoEvento());
            stmt.setDouble(11, evento.getPreco());
            stmt.setString(12, "FOTO"); // TODO
            stmt.setString(13, evento.getUrlWebsite());
            stmt.setString(14, evento.getUrlEventoFacebook());
            stmt.execute();
            stmt = con.prepareStatement("select last_insert_id()");
            rs = stmt.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
}
