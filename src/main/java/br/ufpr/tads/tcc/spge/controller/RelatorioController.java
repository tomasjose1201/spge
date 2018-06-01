/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.dao.ConnectionFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Tom
 */
@WebServlet(name = "RelatorioController", urlPatterns = {"/RelatorioController"})
public class RelatorioController extends HttpServlet {

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
        Connection con = ConnectionFactory.getConnection();
        // Caminho contextualizado do relatório compilado
        String jasper = request.getContextPath() + "/user/relatorio/CertificadoDeParticipacao.jasper";
        // Host onde o servlet esta executando
        String host = "http://" + request.getServerName()
                + ":" + request.getServerPort();
        // URL para acesso ao relatório
        URL jasperURL = new URL(host + jasper);
        // Parâmetros do relatório
        HashMap params = new HashMap();
        params.put("idConvidado", Integer.parseInt(request.getParameter("idConvidado")));
        params.put("idEvento", Integer.parseInt(request.getParameter("idEvento")));
        // Geração do relatório
        byte[] bytes;
        try {
            bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, con);
        } catch (JRException ex) {
            throw new RuntimeException(ex);
        }
        if (bytes != null) {
            // A página será mostrada em PDF
            response.setContentType("application/pdf");
            // Envia o PDF
            OutputStream ops = response.getOutputStream();
            ops.write(bytes);
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
