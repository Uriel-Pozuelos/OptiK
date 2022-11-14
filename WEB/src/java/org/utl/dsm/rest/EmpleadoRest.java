
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utl.dsm.optik.controller.EmpleadoController;
import org.utl.dsm.optik.model.Empleado;

import java.util.List;

/**
 *
 * @author urieh
 */
@Path("empleado")
public class EmpleadoRest extends Application{
    
    @Path("guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarEmpleado(@FormParam("datosEmpleados") @DefaultValue("") String datosEmpleados){
        Gson gson = new Gson();
        Empleado empleado = new Empleado();
        empleado = gson.fromJson(datosEmpleados , Empleado.class);
        EmpleadoController objCE = new EmpleadoController();
        String out="";
        try{
            objCE.insert(empleado);
        }catch(Exception ex){
            out="{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(empleado);
        
    return Response.status(Response.Status.CREATED).entity(out).build();
    }

    @Path("getallempleado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmpleado(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out = "";
        Gson gson = new Gson();
        try {
            EmpleadoController objCE = new EmpleadoController();
            List<Empleado> empleado;
            empleado = objCE.getAll(estatus);
            out = gson.toJson(empleado);
        } catch (Exception ex) {
            out = "{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("updateempleado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmpleado(@FormParam("datosEmpleados") @DefaultValue("") String datosEmpleados){
        Gson gson = new Gson();
        Empleado empleado = new Empleado();
        empleado = gson.fromJson(datosEmpleados , Empleado.class);
        EmpleadoController objCE = new EmpleadoController();
        String out="";
        String result="";
        try{
            result = objCE.updateEmpleado(empleado);
            System.out.println(result);
        }catch(Exception ex){
            out="{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = gson.toJson(empleado);
    return  Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("deleteempleado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmpleado(@FormParam("idEmpleado") @DefaultValue("") String idEmpleado){
        EmpleadoController objCE = new EmpleadoController();
        String out="";
        String result="";
        try{
            result = objCE.eliminarEmpleado(Integer.parseInt(idEmpleado));
            
        }catch(Exception ex){
            out="{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = """
                {
                    "result": "Empleado eliminado correctamente"
                }
                """;
              
    return  Response.status(Response.Status.OK).entity(out).build();
}
    @Path("activateempleado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activateEmpleado(@FormParam("idEmpleado") @DefaultValue("") String idEmpleado){
        EmpleadoController objCE = new EmpleadoController();
        String out="";
        String result="";
        try{
            result = objCE.activarEmpleado(Integer.parseInt(idEmpleado));
            
        }catch(Exception ex){
            out="{\"error\":"+ex.toString()+"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        out = """
                {
                    "result": "Empleado actualizado correctamente"
                }
                """;
              
    return  Response.status(Response.Status.OK).entity(out).build();
}
}


