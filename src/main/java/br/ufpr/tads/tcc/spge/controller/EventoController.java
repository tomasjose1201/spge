/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.facade.AreaInteresseFacade;
import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.UsuarioFacade;
import br.ufpr.tads.tcc.spge.model.AreaInteresse;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tom
 */
@WebServlet(name = "EventoController", urlPatterns = {"/EventoController"})
public class EventoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("list")) {
            EventoFacade facade;
            try {
                facade = new EventoFacade();
                ArrayList<Evento> listaEventos = facade.listarEventos();
                request.setAttribute("lista", listaEventos);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/list.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (action.equals("details")) {
            String id = request.getParameter("id");
            int idEvento = Integer.parseInt(id);
            EventoFacade facade;
            UsuarioFacade facadeUsuario;
            try {
                facade = new EventoFacade();
                facadeUsuario = new UsuarioFacade();
                Evento detalhesEvento = facade.getDetalhes(idEvento);
                Usuario organizador = facadeUsuario.buscarUsuario(detalhesEvento.getIdUsuario());
                request.setAttribute("org", organizador);
                request.setAttribute("detalhes", detalhesEvento);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/details.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (action.equals("add")) {
            AreaInteresseFacade facadeArea;
            try {
                facadeArea = new AreaInteresseFacade();
                ArrayList<AreaInteresse> listaAreas = facadeArea.getAreas();
                request.setAttribute("areas", listaAreas);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/newE.jsp");
            rd.forward(request, response);
        }

        if (action.equals("new")) {
            HttpSession session = request.getSession();
            Usuario usu = (Usuario) session.getAttribute("usuario");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String dataHoraInicioStr = request.getParameter("dataHoraInicio");
            String dataHoraEncerramentoStr = request.getParameter("dataHoraEncerramento");
            String dataHoraEncerramentoInscricoesStr = request.getParameter("dataHoraEncerramentoInscricoes");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
            Date dataHoraInicio;
            Date dataHoraEncerramento;
            Date dataHoraEncerramentoInscricoes;
            try {
                dataHoraInicio = df.parse(dataHoraInicioStr);
                dataHoraEncerramento = df.parse(dataHoraEncerramentoStr);
                dataHoraEncerramentoInscricoes = df.parse(dataHoraEncerramentoInscricoesStr);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            String endereco = request.getParameter("endereco");
            String numMaxParticipantesAux = request.getParameter("numMaxParticipantes");
            int numMaxParticipantes = Integer.parseInt(numMaxParticipantesAux);
            String emiteCertificado = request.getParameter("emiteCertificado");
            String contemSecoes = request.getParameter("contemSecoes");
            String tipoEvento = request.getParameter("tipoEvento");
            double preco = 0;
            if (!request.getParameter("preco").isEmpty()) {
                String precoAux = request.getParameter("preco");
                precoAux = precoAux.replace(",", ".");
                preco = Double.parseDouble(precoAux);
            }
            String areaInteresse = request.getParameter("areaInteresse");
            String fotoDestaque = request.getParameter("imgBase64");
            String urlWebsite = request.getParameter("urlWebsite");
            String urlEventoFacebook = request.getParameter("urlFacebook");
            Evento novo = new Evento();
            novo.setIdUsuario(usu.getIdUsuario());
            novo.setNome(nome);
            novo.setDescricao(descricao);
            novo.setDataHoraInicio(dataHoraInicio);
            novo.setDataHoraEncerramento(dataHoraEncerramento);
            novo.setDataHoraEncerramentoInscricoes(dataHoraEncerramentoInscricoes);
            novo.setEndereco(endereco);
            novo.setNumMaxParticipantes(numMaxParticipantes);
            novo.setEmiteCertificado(emiteCertificado);
            novo.setContemSecoes(contemSecoes);
            novo.setTipoEvento(tipoEvento);
            novo.setPreco(preco);
            novo.setIdAreaInteresse(Integer.parseInt(areaInteresse));
            novo.setFotoDestaque(fotoDestaque);
            novo.setUrlWebsite(urlWebsite);
            novo.setUrlEventoFacebook(urlEventoFacebook);
            try {
                EventoFacade facade = new EventoFacade();
                int idEvento = facade.cadastrarEvento(novo);
                if (novo.getContemSecoes().equals("S")) {
                    request.setAttribute("idEvento", idEvento);
                    request.setAttribute("dtInicioEvento", novo.getDataHoraInicio().getTime());
                    request.setAttribute("dtEncerramentoEvento", novo.getDataHoraEncerramento().getTime());
                    request.setAttribute("dtEncerramentoInsEvento", novo.getDataHoraEncerramentoInscricoes().getTime());
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/newS.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/EventoController?action=list");
                    rd.forward(request, response);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
