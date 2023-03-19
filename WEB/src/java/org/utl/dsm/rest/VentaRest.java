
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
import org.utl.dsm.optik.controller.ControllerVenta;
import org.utl.dsm.optik.model.Producto;

/**
 *
 * @author urieh
 */
@Path("venta")
public class VentaRest {
    @Path("getAllp")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        Gson objGson = new Gson();
        try {
            ControllerVenta cv = new ControllerVenta();
            List<Producto> pl;
            pl = cv.getAllSolucion(estatus);
            out = objGson.toJson(pl);
        } catch (Exception Err) {
            out = "{\"error\":" + Err.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("find")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductoByString(@FormParam("filtro") @DefaultValue("") String filtro) {
        String out = "";
        Gson objGson = new Gson();
        try {
            ControllerVenta cv = new ControllerVenta();
            List<Producto> pl = cv.findByString(filtro);
            out = objGson.toJson(pl);
        } catch (Exception Err) {
            out = "{\"error\":" + Err.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
