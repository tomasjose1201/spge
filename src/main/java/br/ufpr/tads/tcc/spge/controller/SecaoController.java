/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.SecaoFacade;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Secao;
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

/**
 *
 * @author Tom
 */
@WebServlet(name = "SecaoController", urlPatterns = {"/SecaoController"})
public class SecaoController extends HttpServlet {

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
        if (action.equals("new")) {
            String idEventoAux = request.getParameter("idEvento");
            int idEvento = Integer.parseInt(idEventoAux);
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String descricao = request.getParameter("descricao");
            String dataHoraInicioStr = request.getParameter("dataHoraInicio");
            String dataHoraEncerramentoStr = request.getParameter("dataHoraEncerramento");
            String dataHoraEncerramentoInscricoesStr = request.getParameter("dataHoraEncerramentoInscricoes");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
            Date dataHoraInicio;
            Date dataHoraEncerramento;
            Date dataHoraEncerramentoInscricoes = null;
            try {
                dataHoraInicio = df.parse(dataHoraInicioStr);
                dataHoraEncerramento = df.parse(dataHoraEncerramentoStr);
                if (!request.getParameter("dataHoraEncerramentoInscricoes").isEmpty()) {
                    dataHoraEncerramentoInscricoes = df.parse(dataHoraEncerramentoInscricoesStr);
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            Secao nova = new Secao();
            nova.setIdEvento(idEvento);
            nova.setNome(nome);
            nova.setLocal(local);
            nova.setDescricao(descricao);
            nova.setDataHoraInicio(dataHoraInicio);
            nova.setDataHoraEncerramento(dataHoraEncerramento);
            nova.setDataHoraEncerramentoInscricoes(dataHoraEncerramentoInscricoes);
            String nomeResponsavel = request.getParameter("nomeResponsavel");
            String emailResponsavel = request.getParameter("emailResponsavel");
            Convidado responsavel = new Convidado();
            responsavel.setNome(nomeResponsavel);
            responsavel.setEmail(emailResponsavel);
            try {
                SecaoFacade facade = new SecaoFacade();
                facade.cadastrarSecao(nova, responsavel);
                ArrayList<Secao> listaSecoes = facade.listarSecoesDoEvento(nova.getIdEvento());
                request.setAttribute("listaSecoes", listaSecoes);
                request.setAttribute("idEvento", idEvento);
                String dtInicioEvento = request.getParameter("dtInicioEvento");
                String dtEncerramentoEvento = request.getParameter("dtEncerramentoEvento");
                String dtEncerramentoInsEvento = request.getParameter("dtEncerramentoInsEvento");
                request.setAttribute("dtInicioEvento", dtInicioEvento);
                request.setAttribute("dtEncerramentoEvento", dtEncerramentoEvento);
                request.setAttribute("dtEncerramentoInsEvento", dtEncerramentoInsEvento);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/newS.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (action.equals("listSec")) {
            String idEventoStr = request.getParameter("id");
            int idEvento = Integer.parseInt(idEventoStr);
            try {
                EventoFacade eveFacade = new EventoFacade();
                Evento evento = eveFacade.getDetalhes(idEvento);
                request.setAttribute("dtEncerramentoInsEvento", evento.getDataHoraEncerramentoInscricoesF());
                request.setAttribute("nomeEvento", evento.getNome());
                SecaoFacade secFacade = new SecaoFacade();
                ArrayList<Secao> listaSecoes = secFacade.listarSecoesDoEvento(idEvento);
                request.setAttribute("listaS", listaSecoes);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/eventos/listSec.jsp");
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
