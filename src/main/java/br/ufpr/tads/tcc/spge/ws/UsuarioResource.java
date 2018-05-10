/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.ws;

import br.ufpr.tads.tcc.spge.facade.LoginFacade;
import br.ufpr.tads.tcc.spge.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Tom
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    public UsuarioResource() {
    }
    
    @POST
    @Path("/validar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String validarUsuario() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String email = "tomasjose1201@gmail.com";
        String senha = "tomas";
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
        String json = mapper.writeValueAsString(result);
        return json;
    }
}
