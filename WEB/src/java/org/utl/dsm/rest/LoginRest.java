/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utl.dsm.optik.controller.LoginController;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author urieh
 */
@Path("login")
public class LoginRest {
    @Path("ingresar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
        LoginController objLC = new LoginController();
        String out = "";
        int result;
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        System.out.println(usuario.toString());
        try{
            result = objLC.login(usuario);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = "{\"result\":"+String.valueOf(result) +"}";
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    
}
