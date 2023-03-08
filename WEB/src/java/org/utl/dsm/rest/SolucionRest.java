
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.optik.controller.ControllerSolucion;
import org.utl.dsm.optik.model.Solucion;

@Path("solucion")
public class SolucionRest extends Application{
     @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarSolucion(@FormParam("datosSolucion") @DefaultValue("") String datosSolucion) {
        Gson gson = new Gson();
        Solucion solucion = new Solucion();

        solucion = gson.fromJson(datosSolucion, Solucion.class);
        ControllerSolucion objCE = new ControllerSolucion();
        String out = "";
        try {
            objCE.insertarSolucion(solucion);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(solucion);

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarSolucion(@FormParam("datosSolucion") @DefaultValue("") String datosSolucion) {
        Gson gson = new Gson();
        Solucion solucion = new Solucion();
        
        String out = "";
        solucion = gson.fromJson(datosSolucion, Solucion.class);
        ControllerSolucion objCE = new ControllerSolucion();
        try {
            objCE.actualizarSolucion(solucion);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(solucion);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarSolucion(@FormParam("datosSolucion") @DefaultValue("") String datosSolucion) {
        Gson gson = new Gson();
        Solucion solucion = new Solucion();
        String out = "";

        solucion = gson.fromJson(datosSolucion, Solucion.class);
        ControllerSolucion objCE = new ControllerSolucion();

        try {
            objCE.eliminarSolucion(solucion);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(solucion);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activarEmpleado(@FormParam("datosSolucion") @DefaultValue("") String datosSolucion) {
        Gson gson = new Gson();
        Solucion solucion = new Solucion();
        String out = "";

        solucion = gson.fromJson(datosSolucion, Solucion.class);
        ControllerSolucion objCE = new ControllerSolucion();

        try {
            objCE.recuperarSolucion(solucion);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(solucion);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllSolucion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSolucion(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerSolucion objCE = new ControllerSolucion();
            List<Solucion> solucion;
            solucion = objCE.getAllSolucion(estatus);
            out = gson.toJson(solucion);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    
}
