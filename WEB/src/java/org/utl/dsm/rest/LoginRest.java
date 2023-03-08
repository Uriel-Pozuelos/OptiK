/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import org.utl.dsm.optik.controller.ControllerAcceso;
import org.utl.dsm.optik.controller.LoginController;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author urieh
 */
@Path("login")
public class LoginRest extends Application{
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
        try{
            result = objLC.login(usuario);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = "{\"result\":"+String.valueOf(result) +"}";
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("ingresar2")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login2(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
        String out = "";
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        Empleado e;
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        try{
            ControllerAcceso ca = new ControllerAcceso();
            e = ca.accerder(usuario);
            
            
            try{
            e.toString();
            e.getUsuario().setLastToken();
            ca.guardarToken(e);
            out = gson.toJson(e);
            }catch(SQLException ex){
              ex.printStackTrace();
            out = """
                  {"error":"datos incorrectos"}
                  """;
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
            }catch(JsonParseException jpe){
                jpe.printStackTrace();
 out ="""
                  {"error":Formato de datos no valido"}
                  """;
    return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
 }
        }
        catch(Exception ex){
            ex.printStackTrace();
        out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
    String out = null;
    Empleado empleado = null;
    ControllerAcceso ca = null;
    Gson gson = new Gson();
    
    try{
    empleado = gson.fromJson(datosUsuario, Empleado.class);
    ca = new ControllerAcceso();
    
    if(ca.eliminarToken(empleado)){
    out ="""
                  {"response":"Se elimino el token Correctamente"}
                  """;
    return Response.status(Response.Status.OK).entity(out).build();
    
    }else{
        out ="""
                  {"error":"No se pudo eliminar el token"}
                  """;
    return Response.status(Response.Status.NOT_ACCEPTABLE).entity(out).build();
    }
    
 } catch(JsonParseException jpe){
 out ="""
                  {"error":Formato de datos no valido"}
                  """;
    return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
 }
    catch (Exception ex) {
            out ="{\"error\":"+ex.toString()+"}";
                 
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(out).build();
        }

    
   
    
    }
}
