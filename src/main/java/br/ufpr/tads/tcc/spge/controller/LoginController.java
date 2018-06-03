/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.model.Usuario;
import br.ufpr.tads.tcc.spge.dao.UsuarioDao;
import br.ufpr.tads.tcc.spge.facade.ConvidadoFacade;
import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.LoginFacade;
import br.ufpr.tads.tcc.spge.model.Aviso;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import br.ufpr.tads.tcc.spge.model.Evento;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        if (action.equals("index")) {
            HttpSession session = request.getSession();
            Usuario usu = (Usuario) session.getAttribute("usuario");
            ConvidadoFacade convFacade;
            EventoFacade eveFacade;
            ArrayList<Aviso> avisos;
            ArrayList<Evento> eventos;
            ArrayList<Evento> faturamentos;
            ArrayList<ConvidadoEvento> inscricoes;
            try {
                convFacade = new ConvidadoFacade();
                avisos = convFacade.buscarAvisos(usu);
                eveFacade = new EventoFacade();
                eventos = eveFacade.buscarEventosOrganizador(usu);
                faturamentos = eveFacade.buscarFaturamentos(eventos);
                inscricoes = convFacade.listarInscricoes(usu.getIdUsuario());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            request.setAttribute("avisos", avisos);
            request.setAttribute("qtdeAvisos", avisos.size());
            request.setAttribute("eventosOrg", eventos);
            request.setAttribute("qtdeEventosOrg", eventos.size());
            request.setAttribute("faturamentos", faturamentos);
            request.setAttribute("qtdeEventosIns", inscricoes.size());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/index.jsp");
            rd.forward(request, response);
        }
        if (action.equals("login")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Usuario user = new Usuario();
            user.setEmail(email);
            user.setSenha(senha);
            Usuario result = null;
            try {
                LoginFacade facade = new LoginFacade();
                result = facade.autenticarUsuario(user);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if (result != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", result);
                ConvidadoFacade convFacade;
                EventoFacade eveFacade;
                ArrayList<Aviso> avisos;
                ArrayList<Evento> eventos;
                ArrayList<Evento> faturamentos;
                ArrayList<ConvidadoEvento> inscricoes;
                try {
                    convFacade = new ConvidadoFacade();
                    avisos = convFacade.buscarAvisos(result);
                    eveFacade = new EventoFacade();
                    eventos = eveFacade.buscarEventosOrganizador(result);
                    faturamentos = eveFacade.buscarFaturamentos(eventos);
                    inscricoes = convFacade.listarInscricoes(result.getIdUsuario());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                request.setAttribute("avisos", avisos);
                request.setAttribute("qtdeAvisos", avisos.size());
                request.setAttribute("eventosOrg", eventos);
                request.setAttribute("qtdeEventosOrg", eventos.size());
                request.setAttribute("faturamentos", faturamentos);
                request.setAttribute("qtdeEventosIns", inscricoes.size());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/index.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/HomepageController?action=loginFail");
                rd.forward(request, response);
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
