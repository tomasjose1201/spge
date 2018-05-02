/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.facade.ConvidadoFacade;
import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.SecaoFacade;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import br.ufpr.tads.tcc.spge.model.ConvidadoSecao;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Secao;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ConvidadoController", urlPatterns = {"/ConvidadoController"})
public class ConvidadoController extends HttpServlet {

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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usuario");
        if (action.equals("listIns")) {
            ConvidadoFacade facade = new ConvidadoFacade();
            ArrayList<ConvidadoEvento> listaInscricoes;
            try {
                listaInscricoes = facade.listarInscricoes(usu.getIdUsuario());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            request.setAttribute("lista", listaInscricoes);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/listIns.jsp");
            rd.forward(request, response);
        }
        if (action.equals("confirmPart")) {
            String obj = request.getParameter("obj");
            ConvidadoFacade conFacade = new ConvidadoFacade();
            Convidado novo = new Convidado();
            novo.setNome(usu.getNome());
            novo.setEmail(usu.getEmail());
            novo.setIdUsuario(usu.getIdUsuario());
            if (obj.equals("evento")) {
                String idEventoStr = request.getParameter("idEvento");
                int idEvento = Integer.parseInt(idEventoStr);
                try {
                    EventoFacade eveFacade = new EventoFacade();
                    int idConvidado = conFacade.cadastrarConvidado(novo);
                    novo.setIdConvidado(idConvidado);
                    eveFacade.cadastrarConvidadoEvento(novo, idEvento);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (obj.equals("secao")) {
                String idSecaoStr = request.getParameter("idSecao");
                int idSecao = Integer.parseInt(idSecaoStr);
                try {
                    SecaoFacade secFacade = new SecaoFacade();
                    int idConvidado = conFacade.cadastrarConvidado(novo);
                    novo.setIdConvidado(idConvidado);
                    secFacade.cadastrarConvidadoSecao(novo, idSecao);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/index.jsp");
            rd.forward(request, response);
        }
        if (action.equals("listPart")) {
            String obj = request.getParameter("obj");
            ConvidadoFacade conFacade = new ConvidadoFacade();
            if (obj.equals("evento")) {
                ArrayList<ConvidadoEvento> listaParticipantes;
                String idEventoStr = request.getParameter("id");
                int idEvento = Integer.parseInt(idEventoStr);
                try {
                    EventoFacade eveFacade = new EventoFacade();
                    Evento evento = eveFacade.getDetalhes(idEvento);
                    listaParticipantes = conFacade.listarParticipantes(idEvento, "E");
                    request.setAttribute("nomeEvento", evento.getNome());
                    request.setAttribute("listaP", listaParticipantes);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (obj.equals("secao")) {
                ArrayList<ConvidadoSecao> listaParticipantes;
                String idSecaoStr = request.getParameter("id");
                int idSecao = Integer.parseInt(idSecaoStr);
                try {
                    SecaoFacade secFacade = new SecaoFacade();
                    Secao secao = secFacade.getDetalhes(idSecao);
                    listaParticipantes = conFacade.listarParticipantes(idSecao, "S");
                    request.setAttribute("nomeSecao", secao.getNome());
                    request.setAttribute("listaP", listaParticipantes);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/listPart.jsp");
            rd.forward(request, response);
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
