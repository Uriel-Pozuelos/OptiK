
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
import org.utl.dsm.optik.controller.ControllerAccesorio;
import org.utl.dsm.optik.controller.ControllerLenteContacto;
import org.utl.dsm.optik.model.Accesorio;
import org.utl.dsm.optik.model.LenteContacto;


@Path("accesorio")
public class AccesoriosRest {
    @POST
    @Path("guardar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarLenteContacto(@FormParam("datosAccesorio") @DefaultValue("") String datosAccesorio){
        Gson gson = new Gson();
        Accesorio accesorio=new Accesorio();
        accesorio = gson.fromJson(datosAccesorio, Accesorio.class);
        ControllerAccesorio objA = new ControllerAccesorio();
        String out = "";
        try{
            objA.insertAccesorio(accesorio);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(accesorio);
        return Response.status(Response.Status.CREATED).entity(out).build();
    }
    
   @Path("getall")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLenteContacto(@FormParam("estatus") @DefaultValue("1") String estatus){
        
        String out = "";
        Gson gson = new Gson();
        try {
            ControllerAccesorio objA = new ControllerAccesorio();
            List<Accesorio> accesorio;
            accesorio=objA.getAccesorios(estatus);
            out = gson.toJson(accesorio);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    
    }
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLenteContacto(@FormParam("datosAccesorio") @DefaultValue("") String datosAccesorio){
        Gson gson = new Gson();
        Accesorio accesorio =new Accesorio();
        accesorio = gson.fromJson(datosAccesorio, Accesorio.class);
        ControllerAccesorio objA = new ControllerAccesorio();
        String out = "";
        try{
            objA.updateAccesorio(accesorio);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(accesorio);
        return Response.status(Response.Status.CREATED).entity(out).build();
    }
    
    @Path("delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLenteContacto(@FormParam("idProducto") @DefaultValue("") String idProducto){
        Gson gson = new Gson();
         ControllerAccesorio objA = new ControllerAccesorio();
        String out = "";
        try{
            objA.deleteAccesorio(idProducto);
        }catch(Exception ex){
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = """
              {"result":"Lente de contacto eliminado"}
              """;
        return Response.status(Response.Status.CREATED).entity(out).build();
    }

    @Path("activate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activateLenteContacto(@FormParam("idProducto") @DefaultValue("") String idProducto){
        Gson gson = new Gson();
      ControllerAccesorio objA = new ControllerAccesorio();
        String out = "";
        try{
            objA.activarAccesorio(idProducto);
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
