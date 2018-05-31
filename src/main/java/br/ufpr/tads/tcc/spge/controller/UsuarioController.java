/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.controller;

import br.ufpr.tads.tcc.spge.facade.AreaInteresseFacade;
import br.ufpr.tads.tcc.spge.facade.UsuarioFacade;
import br.ufpr.tads.tcc.spge.model.AreaInteresse;
import br.ufpr.tads.tcc.spge.model.Email;
import br.ufpr.tads.tcc.spge.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String areaInteresse1 = request.getParameter("areaInteresse1");
            String areaInteresse2 = request.getParameter("areaInteresse2");
            String areaInteresse3 = request.getParameter("areaInteresse3");
            String estudante = request.getParameter("estudante");
            String numMatricula = request.getParameter("numMatricula");
            String curso = request.getParameter("curso");
            String instituicao = request.getParameter("instituicao");
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setCpf(cpf);
            user.setRg(rg);
            user.setEndereco(endereco);
            user.setTelefone(telefone);
            user.setEmail(email);
            user.setSenha(senha);
            user.setEstudante(estudante);
            user.setNumMatricula(numMatricula);
            user.setCurso(curso);
            user.setInstituicao(instituicao);
            try {
                UsuarioFacade facade = new UsuarioFacade();
                boolean emailExiste = facade.validarEmail(email);
                boolean cpfExiste = facade.validarCpf(cpf);
                if (emailExiste) {
                    request.setAttribute("msgEmail", "O email \"" + email + "\" já está cadastrado.");
                }
                if (cpfExiste) {
                    request.setAttribute("msgCpf", "O cpf \"" + cpf + "\" já está cadastrado.");
                }
                if (!emailExiste && !cpfExiste) {
                    facade.cadastrarUsuario(user, areaInteresse1, areaInteresse2, areaInteresse3);
                    request.setAttribute("email", user.getEmail());
                    request.setAttribute("senha", user.getSenha());
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginController?action=login");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (action.equals("perfil")) {
            AreaInteresseFacade facadeArea;
            UsuarioFacade facadeUsuario;
            Usuario result = null;
            HttpSession session = request.getSession();
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            try {
                facadeUsuario = new UsuarioFacade();
                result = facadeUsuario.buscarUsuario(usuarioLogado.getIdUsuario());
                facadeArea = new AreaInteresseFacade();
                ArrayList<AreaInteresse> listaAreas = facadeArea.getAreas();
                ArrayList<Integer> areasUsuario = facadeArea.getAreasUsuario(usuarioLogado.getIdUsuario());
                request.setAttribute("areas", listaAreas);
                request.setAttribute("areasUsu", areasUsuario);
                request.setAttribute("dadosUsuario", result);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/perfil/perfil.jsp");
            rd.forward(request, response);
        }
        if (action.equals("update")) {
            HttpSession session = request.getSession();
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            int idUsuario = usuarioLogado.getIdUsuario();
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String areaInteresse1 = request.getParameter("areaInteresse1");
            String areaInteresse2 = request.getParameter("areaInteresse2");
            String areaInteresse3 = request.getParameter("areaInteresse3");
            String estudante = request.getParameter("estudante");
            String numMatricula = request.getParameter("numMatricula");
            String curso = request.getParameter("curso");
            String instituicao = request.getParameter("instituicao");
            Usuario user = new Usuario();
            user.setIdUsuario(idUsuario);
            user.setNome(nome);
            user.setRg(rg);
            user.setEndereco(endereco);
            user.setTelefone(telefone);
            user.setEmail(email);
            user.setEstudante(estudante);
            user.setNumMatricula(numMatricula);
            user.setCurso(curso);
            user.setInstituicao(instituicao);
            try {
                UsuarioFacade facade = new UsuarioFacade();
                boolean emailExiste = facade.validarEmail(email);
                if (emailExiste && !user.getEmail().equals(usuarioLogado.getEmail())) {
                    request.setAttribute("msgEmail", "O email \"" + email + "\" já está cadastrado.");
                } else {
                    facade.atualizarUsuario(user, areaInteresse1, areaInteresse2, areaInteresse3);
                    request.setAttribute("msgAtualizado", "Os dados foram atualizados com sucesso.");
                }
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioController?action=perfil");
                rd.forward(request, response);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (action.equals("updateSenha")) {
            String step = request.getParameter("step");
            UsuarioFacade facade;
            if (step.equals("1")) {
                String email = request.getParameter("email");
                try {
                    facade = new UsuarioFacade();
                    boolean emailExiste = facade.validarEmail(email);
                    if (emailExiste) {
                        String link = "http://localhost:8080/spge/UsuarioController?action=updateSenha&step=2&email=" + email;
                        Email emailBuilder = new Email();
                        emailBuilder.setDestinatario(email);
                        emailBuilder.setAssunto("Troca de Senha [SPGE]");
                        emailBuilder.setTexto("Olá, \n"
                                + "Você solicitou a troca de senha do SPGE.\n"
                                + "Por favor, acesse o link: " + link);
                        emailBuilder.enviarEmail();
                        request.setAttribute("msgEmail2", "Email enviado para \"" + email + "\"");
                        if (request.getParameter("flag") != null) {
                            String flag = request.getParameter("flag");
                            if (flag.equals("p")) {
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/UsuarioController?action=perfil");
                                rd.forward(request, response);
                            }
                        }
                    } else {
                        request.setAttribute("msgEmail3", "O email \"" + email + "\" não existe no sistema.");
                    }
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } catch (SQLException | MessagingException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (step.equals("2")) {
                String email = request.getParameter("email");
                Usuario usu;
                try {
                    facade = new UsuarioFacade();
                    usu = facade.buscarUsuario(email);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                request.setAttribute("idUsuario", usu.getIdUsuario());
                request.setAttribute("nomeUsuario", usu.getNome());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/formsenha.jsp");
                rd.forward(request, response);
            }
            if (step.equals("3")) {
                String novaSenha = request.getParameter("senha");
                String idStr = request.getParameter("idUsuario");
                int id = Integer.parseInt(idStr);
                Usuario usu;
                try {
                    facade = new UsuarioFacade();
                    usu = facade.buscarUsuario(id);
                    usu.setSenha(novaSenha);
                    facade.atualizarSenha(usu);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                request.setAttribute("msgUpdateSenha", "A senha foi atualizada para o usuário \"" + usu.getEmail() + "\"");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/HomepageController");
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
