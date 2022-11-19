/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.optik.controller.ControllerLenteContacto;
import org.utl.dsm.optik.model.LenteContacto;

@Path("lenteContacto")
public class LenteContactoRest {

    @POST
    @Path("guardar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarLenteContacto(@FormParam("datosLenteContacto") @DefaultValue("") String datosLenteContacto){
        Gson gson = new Gson();
        LenteContacto lenteContacto = new LenteContacto();
        lenteContacto = gson.fromJson(datosLenteContacto, LenteContacto.class);
        ControllerLenteContacto objCLC = new ControllerLenteContacto();
        String out = "";
        try{
            objCLC.insert(lenteContacto);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(lenteContacto);
        return Response.status(Response.Status.CREATED).entity(out).build();
    }


    
    @Path("getalllente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLenteContacto(@FormParam("estatus") @DefaultValue("1") String estatus){
        
        String out = "";
        Gson gson = new Gson();
        try {
            ControllerLenteContacto objLC = new ControllerLenteContacto();
            List<LenteContacto> lente;
            lente = objLC.getAll(estatus);
            out = gson.toJson(lente);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    
    }

    @Path("updateLente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLenteContacto(@FormParam("datosLenteContacto") @DefaultValue("") String datosLenteContacto){
        Gson gson = new Gson();
        LenteContacto lenteContacto = new LenteContacto();
        lenteContacto = gson.fromJson(datosLenteContacto, LenteContacto.class);
        ControllerLenteContacto objCLC = new ControllerLenteContacto();
        String out = "";
        try{
            objCLC.updateLenteContacto(lenteContacto);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(lenteContacto);
        return Response.status(Response.Status.CREATED).entity(out).build();
    }

    @Path("deleteLente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLenteContacto(@FormParam("idLente") @DefaultValue("") String idLente){
        Gson gson = new Gson();
        ControllerLenteContacto objCLC = new ControllerLenteContacto();
        String out = "";
        try{
            objCLC.deleteLenteContacto(idLente);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = """
              {"result":"Lente de contacto eliminado"}
              """;
        return Response.status(Response.Status.CREATED).entity(out).build();
    }

    @Path("activateLente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activateLenteContacto(@FormParam("idLente") @DefaultValue("") String idLente){
        Gson gson = new Gson();
        ControllerLenteContacto objCLC = new ControllerLenteContacto();
        String out = "";
        try{
            objCLC.activateLenteContacto(idLente);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = """
              {"result":"Lente de contacto activado"}
              """;
        return Response.status(Response.Status.CREATED).entity(out).build();
    }
}
