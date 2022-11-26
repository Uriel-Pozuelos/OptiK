/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.optik.controller.ControllerArmazon;
import org.utl.dsm.optik.model.Armazon;

/**
 *
 * @author urieh
 */
@Path("armazon")
public class ArmazonRest {
    
    @Path("insertArmazon")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertArmazon(@FormParam ("datosArmazon") @DefaultValue ("") String datosArmazon){
        Gson gson = new Gson();
        Armazon armazon = new Armazon();
        armazon = gson.fromJson(datosArmazon, Armazon.class);
        ControllerArmazon objCA= new ControllerArmazon();
        String out = "";
        try {
            objCA.insertar(armazon);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
          return Response.status(Response.Status.BAD_REQUEST).entity(out).build();  
        }
        out = gson.toJson(armazon);
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("updateArmazon")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmpleado(@FormParam ("datosArmazon") @DefaultValue ("") String datosArmazon){
        Gson gson = new Gson();
        Armazon armazon = new Armazon();
        armazon = gson.fromJson(datosArmazon, Armazon.class);
        ControllerArmazon objCA = new ControllerArmazon();
        String out = "";
        try {
            objCA.actualizar(armazon);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
        }
        out = gson.toJson(armazon);
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllArmazon")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArmazon(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out="";
        Gson gson=new Gson();
        try{
            ControllerArmazon objCA = new ControllerArmazon();
            List<Armazon> armazon;
            armazon =objCA.getAll(estatus);
            out=gson.toJson(armazon);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("actualizararmazon")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actulizarArmazon(@FormParam("datosArmazon") @DefaultValue("") String datosArmazon){
        Gson gson=new Gson();
        Armazon armazon = new Armazon();
        armazon = gson.fromJson(datosArmazon, Armazon.class);
        ControllerArmazon objCA = new ControllerArmazon();
        String out= "";
        String result = "";
        try{
            result= objCA.actualizarArmazon(armazon);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
            
        }
        out= gson.toJson(armazon);
        return Response.status(Response.Status.OK).entity(out).build();
    }
         
    @Path("actualizarestatus")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response actulizarEstatus(@QueryParam("idProducto") @DefaultValue("0") int idProducto, @QueryParam("estatus") @DefaultValue("0") int estatus){
        ControllerArmazon objCA = new ControllerArmazon();
        String out= "";
        String result = "";
        try{
            result= objCA.actualizarEstatus(idProducto, estatus);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
            
        }
        out= result;
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
