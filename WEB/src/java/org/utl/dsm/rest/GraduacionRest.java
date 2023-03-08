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
import org.utl.dsm.optik.controller.ControllerGraduacion;
import org.utl.dsm.optik.model.GraduacionLentes;

@Path("graduacion")
public class GraduacionRest {
     @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarMaterial(@FormParam("datosGraduacion") @DefaultValue("") String datosGraduacion){
        
        Gson gson = new Gson();
          GraduacionLentes GL = new GraduacionLentes();
        String out = "";
        
        GL = gson.fromJson(datosGraduacion,GraduacionLentes.class);
        
        ControllerGraduacion objgl = new ControllerGraduacion();
        
        try {
            objgl.insertar(GL);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(GL);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out = "";
        Gson objGson = new Gson();
        try{
            ControllerGraduacion objgl = new ControllerGraduacion();
            List<GraduacionLentes> gl;
            gl = objgl.getAll(estatus);
            out = objGson.toJson(gl);
        }catch(Exception Err ){
            out = "{\"error\":"+Err.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
     @Path("getAllIn")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIn(@FormParam("estatus") @DefaultValue("0") String estatus){
        String out = "";
        Gson objGson = new Gson();
        try{
            ControllerGraduacion objgl = new ControllerGraduacion();
            List<GraduacionLentes> gl;
            gl = objgl.getAllIn(estatus);
            out = objGson.toJson(gl);
        }catch(Exception Err ){
            out = "{\"error\":"+Err.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datosGraduacion") @DefaultValue("") String datosGraduacion){
        Gson gson = new Gson();
        GraduacionLentes gl = new GraduacionLentes();
        String out = "";
        
        gl = gson.fromJson(datosGraduacion, GraduacionLentes.class);
        
        ControllerGraduacion objgl = new ControllerGraduacion();
        
        try {
            objgl.actualizar(gl);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(gl);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datosGraduacion") @DefaultValue("") String datosGraduacion ){
        Gson gson = new Gson();
        GraduacionLentes gl = new GraduacionLentes();
        String out = "";
        
        gl = gson.fromJson(datosGraduacion, GraduacionLentes.class);
        
        ControllerGraduacion objgl = new ControllerGraduacion();
        
        try {
            objgl.eliminar(gl);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(gl);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("datosGraduacion") @DefaultValue("") String datosGraduacion ){
        Gson gson = new Gson();
        GraduacionLentes gl = new GraduacionLentes();
        String out = "";
        
        gl = gson.fromJson(datosGraduacion,GraduacionLentes.class);
        
        ControllerGraduacion objgl = new ControllerGraduacion();
        
        try {
            objgl.activar(gl);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(gl);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
