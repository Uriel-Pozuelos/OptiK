
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
import org.utl.dsm.optik.controller.ControllerTratamiento;
import org.utl.dsm.optik.model.Tratamiento;

@Path("tratamiento")
public class TratamientoRest {
    
 @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarTratamiento(@FormParam("datosTratamiento") @DefaultValue("") String datosTratamiento) {
        Gson gson = new Gson();
        Tratamiento t = new Tratamiento();
        String out = "";

        t = gson.fromJson(datosTratamiento, Tratamiento.class);

        ControllerTratamiento objgl = new ControllerTratamiento();

        try {
            objgl.insertarTratamiento(t);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(t);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        Gson objGson = new Gson();
        try {
            ControllerTratamiento objgl = new ControllerTratamiento();
            List<Tratamiento> gl;
            gl = objgl.getAll(estatus);
            out = objGson.toJson(gl);
        } catch (Exception Err) {
            out = "{\"error\":" + Err.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllIn")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIn(@FormParam("estatus") @DefaultValue("0") String estatus) {
        String out = "";
        Gson objGson = new Gson();
        try {
            ControllerTratamiento objgl = new ControllerTratamiento();
            List<Tratamiento> gl;
            gl = objgl.getAllIn(estatus);
            out = objGson.toJson(gl);
        } catch (Exception Err) {
            out = "{\"error\":" + Err.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datosTratamiento") @DefaultValue("") String datosTratamiento) {
        Gson gson = new Gson();
        Tratamiento t = new Tratamiento();
        String out = "";

        t = gson.fromJson(datosTratamiento, Tratamiento.class);

        ControllerTratamiento objgl = new ControllerTratamiento();

        try {
            objgl.actualizar(t);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(t);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datosTratamiento") @DefaultValue("") String datosTratamiento) {
        Gson gson = new Gson();
        Tratamiento t = new Tratamiento();
        String out = "";

        t = gson.fromJson(datosTratamiento, Tratamiento.class);

        ControllerTratamiento objgl = new ControllerTratamiento();

        try {
            objgl.eliminar(t);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(t);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("datosTratamiento") @DefaultValue("") String datosTratamiento) {
        Gson gson = new Gson();
        Tratamiento t = new Tratamiento();
        String out = "";

        t = gson.fromJson(datosTratamiento, Tratamiento.class);

        ControllerTratamiento objgl = new ControllerTratamiento();

        try {
            objgl.activar(t);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(t);

        return Response.status(Response.Status.OK).entity(out).build();
    }

}
