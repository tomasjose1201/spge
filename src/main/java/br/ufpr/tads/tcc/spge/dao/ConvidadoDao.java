/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.SecaoFacade;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import br.ufpr.tads.tcc.spge.model.ConvidadoSecao;
import br.ufpr.tads.tcc.spge.model.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class ConvidadoDao {

    private final String stmtInsert = "insert into convidado values (null, ?, ?, ?)";
    private final String stmtSearchConvidado = "select * from convidado where email = ?";
    private final String stmtSelectInscrById = "select a.*, b.nome, b.email, b.idUsuario from convidado_evento a, convidado b where a.idConvidado = b.idConvidado and b.idUsuario = ?";
    private final String stmtSelectPartByIdE = "select a.*, b.nome, b.email, b.idUsuario from convidado_evento a, convidado b where a.idConvidado = b.idConvidado and a.idEvento = ?";
    private final String stmtSelectPartByIdS = "select a.*, b.nome, b.email, b.idUsuario from convidado_secao a, convidado b where a.idConvidado = b.idConvidado and a.idSecao = ?";
    private final String stmtSelectConvidado = "select * from convidado where idConvidado = ?";
    private final String stmtUpdateContato = "update convidado_secao set contatoRealizado = ? where idConvidado = ? and idSecao = ?";
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

    public ArrayList<ConvidadoEvento> selectInscrById(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<ConvidadoEvento> lista = new ArrayList();
        try {
            ConvidadoEvento inscricao = null;
            EventoFacade eveFacade = null;
            Convidado conv = null;
            stmt = con.prepareStatement(stmtSelectInscrById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                inscricao = new ConvidadoEvento();
                eveFacade = new EventoFacade();
                conv = new Convidado();
                conv.setIdConvidado(rs.getInt("idConvidado"));
                conv.setNome(rs.getString("nome"));
                conv.setEmail(rs.getString("email"));
                conv.setIdUsuario(rs.getInt("idUsuario"));
                inscricao.setConvidado(conv);
                inscricao.setEvento(eveFacade.getDetalhes(rs.getInt("idEvento")));
                inscricao.setContatoRealizado(rs.getString("contatoRealizado"));
                inscricao.setStatusConfirmacao(rs.getString("statusConfirmacao"));
                inscricao.setDataHoraConfirmacao(rs.getTimestamp("dataHoraConfirmacao"));
                inscricao.setTipoConvidado(rs.getString("tipoConvidado"));
                lista.add(inscricao);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public ArrayList selectPartById(int id, String flag) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList lista = new ArrayList();
        try {
            ConvidadoEvento participante1 = null;
            ConvidadoSecao participante2 = null;
            EventoFacade eveFacade = null;
            SecaoFacade secFacade = null;
            Convidado conv = null;
            if (flag.equals("E")) {
                stmt = con.prepareStatement(stmtSelectPartByIdE);
            } else {
                stmt = con.prepareStatement(stmtSelectPartByIdS);
            }
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                conv = new Convidado();
                conv.setIdConvidado(rs.getInt("idConvidado"));
                conv.setNome(rs.getString("nome"));
                conv.setEmail(rs.getString("email"));
                conv.setIdUsuario(rs.getInt("idUsuario"));
                if (flag.equals("E")) {
                    participante1 = new ConvidadoEvento();
                    eveFacade = new EventoFacade();
                    participante1.setConvidado(conv);
                    participante1.setEvento(eveFacade.getDetalhes(rs.getInt("idEvento")));
                    participante1.setContatoRealizado(rs.getString("contatoRealizado"));
                    participante1.setStatusConfirmacao(rs.getString("statusConfirmacao"));
                    participante1.setDataHoraConfirmacao(rs.getTimestamp("dataHoraConfirmacao"));
                    participante1.setStatusPresenca(rs.getString("statusPresenca"));
                    participante1.setDataHoraPresenca(rs.getTimestamp("dataHoraPresenca"));
                    participante1.setTipoConvidado(rs.getString("tipoConvidado"));
                    lista.add(participante1);
                } else {
                    participante2 = new ConvidadoSecao();
                    secFacade = new SecaoFacade();
                    participante2.setConvidado(conv);
                    participante2.setSecao(secFacade.getDetalhes(rs.getInt("idSecao")));
                    participante2.setContatoRealizado(rs.getString("contatoRealizado"));
                    participante2.setStatusConfirmacao(rs.getString("statusConfirmacao"));
                    participante2.setDataHoraConfirmacao(rs.getTimestamp("dataHoraConfirmacao"));
                    participante2.setStatusPresenca(rs.getString("statusPresenca"));
                    participante2.setDataHoraPresenca(rs.getTimestamp("dataHoraPresenca"));
                    participante2.setTipoConvidado(rs.getString("tipoConvidado"));
                    lista.add(participante2);
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }
    
    public Convidado getConvidado(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Convidado conv = null;
            stmt = con.prepareStatement(stmtSelectConvidado);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                conv = new Convidado();
                conv.setIdConvidado(rs.getInt("idConvidado"));
                conv.setNome(rs.getString("nome"));
                conv.setEmail(rs.getString("email"));
                conv.setIdUsuario(rs.getInt("idUsuario"));
            }
            return conv;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }
    
    public void atualizarContato(int idC, int idS, String s) throws SQLException {
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtUpdateContato);
            stmt.setString(1, s);
            stmt.setInt(2, idC);
            stmt.setInt(3, idS);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
}
