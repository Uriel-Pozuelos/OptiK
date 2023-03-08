
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.optik.controller.ControllerCliente;
import org.utl.dsm.optik.model.Cliente;

@Path("restcliente")
public class ClienteRest extends Application{
    @Path("insertCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCliente(@FormParam ("datosCliente") @DefaultValue ("") String datosCliente){
        Gson gson = new Gson();
        Cliente clientes = new Cliente();
        clientes = gson.fromJson(datosCliente, Cliente.class);
        ControllerCliente objCC = new ControllerCliente();
        String out = "";
        try {
            objCC.insertar(clientes);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
          return Response.status(Response.Status.BAD_REQUEST).entity(out).build();  
        }
        out = gson.toJson(clientes);
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("updateCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(@FormParam ("datosCliente") @DefaultValue ("") String datosCliente){
        Gson gson = new Gson();
        Cliente clientes = new Cliente();
        clientes = gson.fromJson(datosCliente, Cliente.class);
        ControllerCliente objCC = new ControllerCliente();
        String out = "";
        try {
            objCC.actualizar(clientes);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
        }
        out = gson.toJson(clientes);
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllClientes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out="";
        Gson gson=new Gson();
        try{
            ControllerCliente objCC = new ControllerCliente();
            List<Cliente> clientes;
            clientes=objCC.getAll(estatus);
            out=gson.toJson(clientes);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("actualizarcliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actulizarCliente(@FormParam("datosCliente") @DefaultValue("") String datosCliente){
        Gson gson=new Gson();
        Cliente clientes = new Cliente();
        clientes = gson.fromJson(datosCliente, Cliente.class);
        ControllerCliente objCC = new ControllerCliente();
        String out= "";
        String result = "";
        try{
            result= objCC.actualizarClientes(clientes);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
            
        }
        out= gson.toJson(clientes);
        return Response.status(Response.Status.OK).entity(out).build();
    }
         
    @Path("actualizarestatuscliente")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response actulizarEstatusCliente(@QueryParam("idCliente") @DefaultValue("0") int idCliente, @QueryParam("estatus") @DefaultValue("0") int estatus){
        ControllerCliente objCC = new ControllerCliente();
        String out= "";
        String result = "";
        try{
            result= objCC.actualizarEstatusCliente(idCliente, estatus);
        } catch (Exception ex) {
            out="{\"error\":\""+ex.toString()+"\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
            
        }
        out= result;
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
