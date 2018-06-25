/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.SecaoFacade;
import br.ufpr.tads.tcc.spge.model.Aviso;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import br.ufpr.tads.tcc.spge.model.ConvidadoSecao;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final String stmtAvisosUsuario = "select a.*, ev.nome from usuario u, convidado c, convidado_evento e, aviso a, evento ev where u.idUsuario = ? and u.idUsuario = c.idUsuario and e.idConvidado = c.idConvidado and a.idEvento = e.idEvento and ev.idEvento = e.idEvento";
    private final String stmtSelectInscrSecoes = "select * from secao s, convidado_secao c where s.idEvento = ? and c.idConvidado = ? and s.idSecao = c.idSecao";
    private final String stmtExcluirParticipanteEvento = "delete from convidado_evento where idConvidado = ? and idEvento = ?";
    private final String stmtExcluirParticipanteSecao = "delete from convidado_secao where idConvidado = ? and idSecao = ?";
    private final String stmtSelectIdConvidado = "select * from convidado where idUsuario = ?";
    private Connection con;

    public ConvidadoDao() {

    }

    public void excluir(int idConvidado, int id, String obj) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            if (obj.equals("evento")) {
                stmt = con.prepareStatement(stmtExcluirParticipanteEvento);
            } else {
                stmt = con.prepareStatement(stmtExcluirParticipanteSecao);
            }

            stmt.setString(1, String.valueOf(idConvidado));
            stmt.setString(2, String.valueOf(id));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConvidadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int insert(Convidado convidado) throws SQLException {
        con = ConnectionFactory.getConnection();
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
        con = ConnectionFactory.getConnection();
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
                inscricao.setStatusPresenca(rs.getString("statusPresenca"));
                inscricao.setDataHoraPresenca(rs.getTimestamp("dataHoraPresenca"));
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
        con = ConnectionFactory.getConnection();
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
        con = ConnectionFactory.getConnection();
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
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
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

    public ArrayList<Aviso> selectAvisosUsuario(Usuario user) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Aviso> lista = new ArrayList();
        try {
            Aviso aviso = null;
            stmt = con.prepareStatement(stmtAvisosUsuario);
            stmt.setInt(1, user.getIdUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                aviso = new Aviso();
                aviso.setIdAviso(rs.getInt("idAviso"));
                aviso.setIdEvento(rs.getInt("idEvento"));
                aviso.setNomeEvento(rs.getString("nome"));
                aviso.setAssunto(rs.getString("assunto"));
                aviso.setDescricao(rs.getString("descricao"));
                aviso.setDataHoraAviso(rs.getTimestamp("dataHoraAviso"));
                lista.add(aviso);
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

    public ArrayList<ConvidadoSecao> selectInscrSecoes(int idEvento, int idConvidado) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<ConvidadoSecao> lista = new ArrayList();
        try {
            ConvidadoSecao inscricao = null;
            SecaoFacade secFacade = null;
            Convidado conv = null;
            stmt = con.prepareStatement(stmtSelectInscrSecoes);
            stmt.setInt(1, idEvento);
            stmt.setInt(2, idConvidado);
            rs = stmt.executeQuery();
            while (rs.next()) {
                inscricao = new ConvidadoSecao();
                secFacade = new SecaoFacade();
                conv = new Convidado();
                inscricao.setConvidado(conv);
                inscricao.setSecao(secFacade.getDetalhes(rs.getInt("idSecao")));
                inscricao.setContatoRealizado(rs.getString("contatoRealizado"));
                inscricao.setStatusConfirmacao(rs.getString("statusConfirmacao"));
                inscricao.setDataHoraConfirmacao(rs.getTimestamp("dataHoraConfirmacao"));
                inscricao.setStatusPresenca(rs.getString("statusPresenca"));
                inscricao.setDataHoraPresenca(rs.getTimestamp("dataHoraPresenca"));
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

    public int getIdConvidado(int idUsuario) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Convidado conv = null;
            stmt = con.prepareStatement(stmtSelectIdConvidado);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                conv = new Convidado();
                conv.setIdConvidado(rs.getInt("idConvidado"));
            }
            return conv.getIdConvidado();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }
}
