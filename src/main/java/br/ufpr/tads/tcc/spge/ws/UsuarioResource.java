/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.ws;

import br.ufpr.tads.tcc.spge.facade.ConvidadoFacade;
import br.ufpr.tads.tcc.spge.facade.EventoFacade;
import br.ufpr.tads.tcc.spge.facade.LoginFacade;
import br.ufpr.tads.tcc.spge.facade.UsuarioFacade;
import br.ufpr.tads.tcc.spge.model.Convidado;
import br.ufpr.tads.tcc.spge.model.ConvidadoEvento;
import br.ufpr.tads.tcc.spge.model.Evento;
import br.ufpr.tads.tcc.spge.model.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @GET
    @Path("/validar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validarUsuario(@QueryParam("callback") String callback,
            @QueryParam("email") String email,
            @QueryParam("senha") String senha) {
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
        String json = callback + "(" + new Gson().toJson(result) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/eventos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventos(@QueryParam("callback") String callback,
            @QueryParam("idUsuario") int idUsuario) {
        ConvidadoFacade facade = new ConvidadoFacade();
        ArrayList<ConvidadoEvento> listaInscricoes;
        try {
            listaInscricoes = facade.listarInscricoes(idUsuario);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String json = callback + "(" + new Gson().toJson(listaInscricoes) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/nomeOrganizador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNomeOrganizador(@QueryParam("callback") String callback,
            @QueryParam("idUsuario") int idUsuario) {
        UsuarioFacade facade;
        Usuario usu = null;
        try {
            facade = new UsuarioFacade();
            usu = facade.buscarUsuario(idUsuario);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String json = callback + "(" + new Gson().toJson(usu.getNome()) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/convidados")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConvidadosEvento(@QueryParam("callback") String callback,
            @QueryParam("idEvento") int idEvento) {
        ArrayList<ConvidadoEvento> listaParticipantes;
        try {
            ConvidadoFacade conFacade = new ConvidadoFacade();
            listaParticipantes = conFacade.listarParticipantes(idEvento, "E");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String json = callback + "(" + new Gson().toJson(listaParticipantes) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/presencaConvidado")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPresencaConvidado(@QueryParam("callback") String callback,
            @QueryParam("idEvento") int idEvento, @QueryParam("idConvidado") int idConvidado) {
        try {
            EventoFacade eveFacade = new EventoFacade();
            ConvidadoFacade conFacade = new ConvidadoFacade();
            Convidado conv = new Convidado();
            conv = conFacade.getConvidado(idConvidado);
            eveFacade.confirmarPresenca(conv, idEvento);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String json = callback + "(" + new Gson().toJson(true) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/convidadoCpf")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPresencaConvidado(@QueryParam("callback") String callback,
            @QueryParam("idUsuario") int idUsuario) {
        UsuarioFacade facadeUsuario;
        Usuario result;
        try {
            facadeUsuario = new UsuarioFacade();
            result = facadeUsuario.buscarUsuario(idUsuario);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String json = callback + "(" + new Gson().toJson(result.getCpf()) + ")";
        return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }
}
