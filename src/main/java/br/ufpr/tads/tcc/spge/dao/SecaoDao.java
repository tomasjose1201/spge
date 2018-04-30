/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.facade.UsuarioFacade;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Secao;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class SecaoDao {

    private final String stmtInsert = "insert into secao values(null, ?, ?, ?, ?, ?, ?, ?)";
    private final String stmtSearchResponsavel = "select * from convidado where email = ?";
    private final String stmtInsertResponsavel = "insert into convidado values (null, ?, ?, ?)";
    private final String stmtInsertResponsavelSecao = "insert into convidado_secao values (?, ?, ?, ?, ?, ?)";
    private final String stmtSelectById = "select * from secao where idEvento = ?";
    private Connection con;

    public SecaoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void insert(Secao secao, Convidado responsavel) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario found = null;
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
            if (secao.getDataHoraEncerramentoInscricoes() != null) {
                Timestamp tsEncInscricoes = new Timestamp(secao.getDataHoraEncerramentoInscricoes().getTime());
                stmt.setTimestamp(7, tsEncInscricoes);
            } else {
                stmt.setTimestamp(7, null);
            }
            stmt.execute();
            stmt = con.prepareStatement("select last_insert_id()");
            rs = stmt.executeQuery();
            int idSecao = 0;
            while (rs.next()) {
                idSecao = rs.getInt(1);
            }
            Convidado resp = null;
            stmt = con.prepareStatement(stmtSearchResponsavel);
            stmt.setString(1, responsavel.getEmail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                resp = new Convidado();
                resp.setIdConvidado(rs.getInt("idConvidado"));
                resp.setNome(rs.getString("nome"));
                resp.setEmail(rs.getString("email"));
                resp.setIdUsuario(rs.getInt("idUsuario"));
            }
            UsuarioFacade uFacade = new UsuarioFacade();
            if (resp == null) {
                stmt = con.prepareStatement(stmtInsertResponsavel);
                if (uFacade.validarEmail(responsavel.getEmail())) {
                    found = uFacade.buscarUsuario(responsavel.getEmail());
                    stmt.setString(1, found.getNome());
                    stmt.setString(2, found.getEmail());
                    stmt.setInt(3, found.getIdUsuario());
                } else {
                    stmt.setString(1, responsavel.getNome());
                    stmt.setString(2, responsavel.getEmail());
                    stmt.setString(3, null);
                }
                stmt.execute();
                stmt = con.prepareStatement("select last_insert_id()");
                rs = stmt.executeQuery();
                int idResponsavel = 0;
                while (rs.next()) {
                    idResponsavel = rs.getInt(1);
                }
                insertResponsavelSecao(idResponsavel, idSecao);
            } else {
                insertResponsavelSecao(resp.getIdConvidado(), idSecao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public void insertResponsavelSecao(int idResponsavel, int idSecao) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtInsertResponsavelSecao);
            stmt.setInt(1, idResponsavel);
            stmt.setInt(2, idSecao);
            stmt.setString(3, "N");
            stmt.setString(4, "P"); // Status Participação: Pendente
            stmt.setTimestamp(5, null);
            stmt.setString(6, "RE"); // Tipo Convidado: Responsável
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
        }
    }
    
    public ArrayList<Secao> selectById(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Secao> lista = new ArrayList();
        con = ConnectionFactory.getConnection();
        try {
            Secao nova = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                nova = new Secao();
                nova.setIdSecao(rs.getInt("idSecao"));
                nova.setIdEvento(rs.getInt("idEvento"));
                nova.setNome(rs.getString("nome"));
                nova.setLocal(rs.getString("local"));
                nova.setDescricao(rs.getString("descricao"));
                nova.setDataHoraInicio(rs.getTimestamp("dataHoraInicio"));
                nova.setDataHoraEncerramento(rs.getTimestamp("dataHoraEncerramento"));
                nova.setDataHoraEncerramentoInscricoes(rs.getTimestamp("dataHoraEncerramentoInscricoes"));
                lista.add(nova);
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
}
