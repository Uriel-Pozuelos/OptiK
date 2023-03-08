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
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.optik.controller.ControllerExamenVista;
import org.utl.dsm.optik.model.Cliente;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Examen_Vista;
import org.utl.dsm.optik.model.GraduacionLentes;

/**
 *
 * @author urieh
 */
@Path("examenVista")
public class ExamenVistaRest extends Application{
    
    
    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarCompraProducto(@FormParam("datosExamenVista") @DefaultValue("") String datosExamenVista) {
        Gson gson = new Gson();
        Examen_Vista examenVista = new Examen_Vista();

        examenVista = gson.fromJson(datosExamenVista, Examen_Vista.class);
        ControllerExamenVista objCE = new ControllerExamenVista();
        String out = "";
        try {
            objCE.InsertarExamenVista(examenVista);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gson.toJson(examenVista);

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEmpleado(@FormParam("datosExamenVista") @DefaultValue("") String datosExamenVista){
        Gson gson = new Gson();
        Examen_Vista examenVista = new Examen_Vista();
        
        String out = "";
        examenVista = gson.fromJson(datosExamenVista, Examen_Vista.class);
        ControllerExamenVista objCE = new ControllerExamenVista();
        try {
            objCE.ActualizarExamenVista(examenVista);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(examenVista);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarEmpleado(@FormParam("datosExamenVista") @DefaultValue("") String datosExamenVista) {
        Gson gson = new Gson();
        Examen_Vista examenVista = new Examen_Vista();
        String out = "";

        examenVista = gson.fromJson(datosExamenVista, Examen_Vista.class);

        ControllerExamenVista objCE = new ControllerExamenVista();

        try {
            objCE.EliminarExamenVista(examenVista);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(examenVista);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activarEmpleado(@FormParam("datosExamenVista") @DefaultValue("") String datosExamenVista) {
        Gson gson = new Gson();
        Examen_Vista examenVista = new Examen_Vista();
        String out = "";

        examenVista = gson.fromJson(datosExamenVista, Examen_Vista.class);

        ControllerExamenVista objCE = new ControllerExamenVista();

        try {
            objCE.RecuperarExamenVista(examenVista);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();

        }

        out = gson.toJson(examenVista);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllEmpleado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmpleado(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerExamenVista objCE = new ControllerExamenVista();
            List<Empleado> empleados;
            empleados = objCE.getAllEmpleado(estatus);
            out = gson.toJson(empleados);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCliente(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerExamenVista objCE = new ControllerExamenVista();
            List<Cliente> clientes;
            clientes = objCE.getAllCliente(estatus);
            out = gson.toJson(clientes);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllGraduacion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGraduacion(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerExamenVista objCE = new ControllerExamenVista();
            List<GraduacionLentes> graduaciones;
            graduaciones = objCE.getAllGraduacion(estatus);
            out = gson.toJson(graduaciones);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllExamenVista")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllExamenVista(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerExamenVista objCE = new ControllerExamenVista();
            List<Examen_Vista> examenVistas;
            examenVistas = objCE.getAllExamenVista(estatus);
            out = gson.toJson(examenVistas);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("getAllExamenVistaInactiva")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllExamenVistaInactiva(@FormParam("estatus") @DefaultValue("0") String estatusIna) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerExamenVista objCE = new ControllerExamenVista();
            List<Examen_Vista> examenVistaIna;
            examenVistaIna = objCE.getAllExamenVistaIna(estatusIna);
            out = gson.toJson(examenVistaIna);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
