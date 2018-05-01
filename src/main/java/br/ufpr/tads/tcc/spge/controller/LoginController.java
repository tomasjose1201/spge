/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.model.Usuario;
import br.ufpr.tads.tcc.spge.dao.UsuarioDao;
import br.ufpr.tads.tcc.spge.facade.LoginFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/index.jsp");
                rd.forward(request, response);
            } else {
                //Redireciona para index.jsp, passando uma mensagem como parâmetro
                request.setAttribute("erro", 2);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
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
