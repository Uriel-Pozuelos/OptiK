
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
import org.utl.dsm.optik.controller.ControllerMaterial;
import org.utl.dsm.optik.model.Material;

@Path("material")
public class MaterialesRest {
    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarMaterial(@FormParam("datosMaterial") @DefaultValue("") String datosMaterial){
        
        Gson gson = new Gson();
        Material m = new Material();
        String out = "";
        
        m = gson.fromJson(datosMaterial,Material.class);
        
        ControllerMaterial objCm = new ControllerMaterial();
        
        try {
            objCm.insertar(m);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(m);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out = "";
        Gson objGson = new Gson();
        try{
            ControllerMaterial objMa = new ControllerMaterial();
            List<Material> material;
            material = objMa.getAll(estatus);
            out = objGson.toJson(material);
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
            ControllerMaterial objMa = new ControllerMaterial();
            List<Material> material;
            material = objMa.getAllIn(estatus);
            out = objGson.toJson(material);
        }catch(Exception Err ){
            out = "{\"error\":"+Err.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
     @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEmpleado(@FormParam("datosMaterial") @DefaultValue("") String datosMaterial){
        Gson gson = new Gson();
        Material m = new Material();
        String out = "";
        
        m = gson.fromJson(datosMaterial, Material.class);
        
        ControllerMaterial objMa = new ControllerMaterial();
        
        try {
            objMa.actualizar(m);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(m);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datosMaterial") @DefaultValue("") String datosMaterial ){
        Gson gson = new Gson();
        Material m = new Material();
        String out = "";
        
        m = gson.fromJson(datosMaterial, Material.class);
        
        ControllerMaterial objMa = new ControllerMaterial();
        
        try {
            objMa.eliminar(m);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(m);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("datosMaterial") @DefaultValue("") String datosMaterial){
        Gson gson = new Gson();
        Material m = new Material();
        String out = "";
        
        m = gson.fromJson(datosMaterial, Material.class);
        
        ControllerMaterial objMa = new ControllerMaterial();
        
        try {
            objMa.activar(m);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
             return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(m);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
