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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;    
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Tom
 */
@WebServlet(name = "EventoController", urlPatterns = {"/EventoController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 *50)
public class EventoController extends HttpServlet {
    
    private final String UPLOAD_DIRECTORY = "img";

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
                
                /* Usuário Evento vs Usuário Session */
                HttpSession session = request.getSession();
                Usuario organizadorSessao = (Usuario) session.getAttribute("usuario");
                request.setAttribute("org", organizadorSessao);
                /* */
               
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
                
                /* Usuário Evento vs Usuário Session */
                Usuario organizadorEvento = facadeUsuario.buscarUsuario(detalhesEvento.getIdUsuario());
                HttpSession session = request.getSession();
                Usuario organizadorSessao = (Usuario) session.getAttribute("usuario");
                request.setAttribute("orgSessao", organizadorSessao);
                request.setAttribute("org", organizadorEvento);
                
                if(organizadorEvento.getIdUsuario() == organizadorSessao.getIdUsuario()) {
                    request.setAttribute("role", true);
                } else {
                    request.setAttribute("role", false);
                }
                /* */
                
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
            
            
        /* Tratamento de Imagens - INÍCIO */ 
        
        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIRECTORY;
        //String uploadFilePath = UPLOAD_DIRECTORY;
        // creates upload folder if it does not exists
        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
        }
        PrintWriter writer = response.getWriter();
        // write all files in upload folder
        //for (Part part : request.getParts()) {
                //if (part != null && part.getSize() > 0) {
                        Part part = request.getPart("foto");
                        String fileName = part.getSubmittedFileName();
                        String contentType = part.getContentType();

                        // allows only JPEG files to be uploaded
                        if (!contentType.equalsIgnoreCase("image/jpeg") || contentType.equalsIgnoreCase("image/png")) {
                            part.write(uploadFilePath + File.separator + fileName);

                            writer.append("File successfully uploaded to " 
                                            + uploadFolder.getAbsolutePath() 
                                            + File.separator
                                            + fileName
                                            + "<br>\r\n");       
                        }
                //}
        //}
        
           //process only if its multipart content
            /*if(ServletFileUpload.isMultipartContent(request)){
                try {
                    List<FileItem> multiparts = new ServletFileUpload(
                                             new DiskFileItemFactory()).parseRequest(request);

                    for(FileItem item : multiparts){
                        if(!item.isFormField()){
                            String name = new File(item.getName()).getName();
                            request.setAttribute("nomeFoto", name);
                            item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        }
                    }

                   //File uploaded successfully
                   System.out.println("File Uploaded Successfully");
                } catch (Exception ex) {
                   System.out.println("File Upload Failed due to " + ex);
                }          

            }else{
                System.out.println("Sorry this Servlet only handles file upload request");
            }*/
            
            //String description = request.getParameter("foto"); // Retrieves <input type="text" name="description">
            /*Part filePart = request.getPart("foto"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            //OutputStream fileContentReceived = get
            File uploads = new File("\");
            
            File file = new File(uploads, "img\\" + File.separator);
            Files.copy(fileContent, file.toPath());*/
            //String appPath = request.getServletContext().getRealPath("");
            // ... (do your job here)
            
            // gets absolute path of the web application
            //String appPath = request.getServletContext().getRealPath("/");
            // constructs path of the directory to save uploaded file
            //String savePath = appPath + File.separator + SAVE_DIR;

            // creates the save directory if it does not exists
            /*File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }*/

            /*Part part = request.getPart("foto");
            String fileName = extractFileName(part);
            //fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);*/
            /* Tratamento de Imagens - FIM */
            
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
            String fotoDestaque = request.getParameter("nomeFoto");
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
    
    public String extractFileName(Part part) {
       String contentDisp = part.getHeader("content-disposition");
       String [] items = contentDisp.split(";");
       for (String s : items ) {
           if(s.trim().startsWith("filename")) {
               return s.substring(s.indexOf("=") + 2, s.length() - 1);
           }
       }
       return "";
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
