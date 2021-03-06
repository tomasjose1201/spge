/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.dao;

import br.ufpr.tads.tcc.spge.model.Aviso;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Usuario;
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
    private final String stmtSelectRandom = "select * from evento order by rand() limit 4";
    private final String stmtInsert = "insert into evento values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String stmtInsertConvidadoEvento = "insert into convidado_evento values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String stmtConfirmarConvidadoEvento = "update convidado_evento set statusConfirmacao = ?, dataHoraConfirmacao = ? where idConvidado = ? and idEvento = ?";
    private final String stmtConfirmarPresenca = "update convidado_evento set statusPresenca = ?, dataHoraPresenca = ? where idConvidado = ? and idEvento = ?";
    private final String stmtSelectEventosOrganizador = "select * from evento where idUsuario = ?";
    private final String stmtSelectFaturamentos = "select sum(e.preco) as preco from convidado_evento c, evento e where c.idEvento = ? and c.idEvento = e.idEvento";
    private final String stmtSelectDestaques = "select * from evento where idAreaInteresse = ? or idAreaInteresse = ? or idAreaInteresse = ? order by rand() limit 6";
    private final String stmtInsertAviso = "insert into aviso values (null, ?, ?, ?, ?)";
    private final String stmtSearchEvento = "select * from evento where nome like ?";
    private Connection con;

    public EventoDao() throws SQLException {
    }

    public ArrayList<Evento> selectAll() throws SQLException {
        con = ConnectionFactory.getConnection();
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
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public ArrayList<Evento> selectRandom() throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSelectRandom);
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public Evento selectById(int id) throws SQLException {
        con = ConnectionFactory.getConnection();
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
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public int insert(Evento evento) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(stmtInsert);
            stmt.setInt(1, evento.getIdUsuario());
            stmt.setString(2, evento.getNome());
            stmt.setString(3, evento.getDescricao());
            Timestamp tsInicio = new Timestamp(evento.getDataHoraInicio().getTime());
            stmt.setTimestamp(4, tsInicio);
            Timestamp tsEncerramento = new Timestamp(evento.getDataHoraEncerramento().getTime());
            stmt.setTimestamp(5, tsEncerramento);
            Timestamp tsEncInscricoes = new Timestamp(evento.getDataHoraEncerramentoInscricoes().getTime());
            stmt.setTimestamp(6, tsEncInscricoes);
            stmt.setString(7, evento.getEndereco());
            stmt.setInt(8, evento.getNumMaxParticipantes());
            stmt.setString(9, evento.getEmiteCertificado());
            stmt.setString(10, evento.getContemSecoes());
            stmt.setString(11, evento.getTipoEvento());
            stmt.setDouble(12, evento.getPreco());
            stmt.setInt(13, evento.getIdAreaInteresse());
            stmt.setString(14, evento.getFotoDestaque());
            stmt.setString(15, evento.getUrlWebsite());
            stmt.setString(16, evento.getUrlEventoFacebook());
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
            rs.close();
            con.close();
        }
    }

    public void insertConvidadoEvento(Convidado convidado, int idEvento) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Evento evento = null;
            stmt = con.prepareStatement(stmtSelectById);
            stmt.setInt(1, idEvento);
            rs = stmt.executeQuery();
            while (rs.next()) {
                evento = new Evento();
                evento.setTipoEvento(rs.getString("tipoEvento"));
            }
            stmt = con.prepareStatement(stmtInsertConvidadoEvento);
            stmt.setInt(1, convidado.getIdConvidado());
            stmt.setInt(2, idEvento);
            stmt.setString(3, "N");
            if (evento.getTipoEvento().equals("Público")) {
                stmt.setString(4, "C"); // Status Participação: Confirmado
                Timestamp dtConfirmacao = new Timestamp(new Date().getTime());
                stmt.setTimestamp(5, dtConfirmacao);
            } else {
                stmt.setString(4, "P"); // Status Participação: Pendente
                stmt.setTimestamp(5, null);
            }
            stmt.setString(6, "A"); // Status Presença: Ausente
            stmt.setTimestamp(7, null);
            stmt.setString(8, "PA"); // Tipo Convidado: Participante
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public void confirmarConvidadoEvento(Convidado convidado, int idEvento) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtConfirmarConvidadoEvento);
            stmt.setString(1, "C");
            Timestamp dtConfirmacao = new Timestamp(new Date().getTime());
            stmt.setTimestamp(2, dtConfirmacao);
            stmt.setInt(3, convidado.getIdConvidado());
            stmt.setInt(4, idEvento);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }

    public void confirmarPresenca(Convidado convidado, int idEvento) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtConfirmarPresenca);
            stmt.setString(1, "P");
            Timestamp dtConfirmacao = new Timestamp(new Date().getTime());
            stmt.setTimestamp(2, dtConfirmacao);
            stmt.setInt(3, convidado.getIdConvidado());
            stmt.setInt(4, idEvento);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }

    public ArrayList<Evento> selectEventosOrganizador(Usuario user) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSelectEventosOrganizador);
            stmt.setInt(1, user.getIdUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public ArrayList<Evento> selectFaturamentos(ArrayList<Evento> eventos) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            for (Evento e : eventos) {
                Evento novo = null;
                stmt = con.prepareStatement(stmtSelectFaturamentos);
                stmt.setInt(1, e.getIdEvento());
                rs = stmt.executeQuery();
                while (rs.next()) {
                    novo = new Evento();
                    novo.setIdEvento(e.getIdEvento());
                    novo.setPreco(rs.getDouble("preco"));
                    lista.add(novo);
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            con.close();
        }
    }

    public ArrayList<Evento> selectDestaques(int a1, int a2, int a3) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSelectDestaques);
            stmt.setInt(1, a1);
            stmt.setInt(2, a2);
            stmt.setInt(3, a3);
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public void insertAviso(Aviso aviso) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtInsertAviso);
            stmt.setInt(1, aviso.getIdEvento());
            stmt.setString(2, aviso.getAssunto());
            stmt.setString(3, aviso.getDescricao());
            Timestamp dtAviso = new Timestamp(new Date().getTime());
            stmt.setTimestamp(4, dtAviso);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }

    public ArrayList<Evento> searchEvento(String input) throws SQLException {
        con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> lista = new ArrayList();
        try {
            Evento novo = null;
            stmt = con.prepareStatement(stmtSearchEvento);
            stmt.setString(1, "%" + input + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                novo = new Evento();
                novo.setIdEvento(rs.getInt("idEvento"));
                novo.setIdUsuario(rs.getInt("idUsuario"));
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
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
    }

    public void insertOrganizadorEvento(Convidado conv, int idEvento) throws SQLException {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(stmtInsertConvidadoEvento);
            stmt.setInt(1, conv.getIdConvidado());
            stmt.setInt(2, idEvento);
            stmt.setString(3, "N");
            stmt.setString(4, "C");
            Timestamp dtConfirmacao = new Timestamp(new Date().getTime());
            stmt.setTimestamp(5, dtConfirmacao);
            stmt.setString(6, "A"); // Status Presença: Ausente
            stmt.setTimestamp(7, null);
            stmt.setString(8, "OR"); // Tipo Convidado: Participante
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            con.close();
        }
    }
}
