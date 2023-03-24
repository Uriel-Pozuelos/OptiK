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
import org.utl.dsm.optik.controller.ControllerTratamiento;
import org.utl.dsm.optik.controller.ControllerVentaLente;
import org.utl.dsm.optik.controller.ControllerVentaProducto;
import org.utl.dsm.optik.model.DetalleVentaPre;
import org.utl.dsm.optik.model.DetalleVentaPresupuestoLentes;
import org.utl.dsm.optik.model.DetalleVentaProducto;
import org.utl.dsm.optik.model.Tratamiento;

/**
 *
 * @author urieh
 */
@Path("vp")
public class VentaProductoRest {
    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDVP(@FormParam("datosVentaProducto") @DefaultValue("") String datosVentaProducto) {
        Gson gson = new Gson();
        System.out.println(datosVentaProducto);
        DetalleVentaProducto dvp = new DetalleVentaProducto();
        String out = "";
        dvp = gson.fromJson(datosVentaProducto, DetalleVentaProducto.class);
        ControllerVentaProducto cvp = new ControllerVentaProducto();
        System.out.println(dvp.toString());
        try {
            boolean r = cvp.generarVenta(dvp);
            if (r) {
                out = """
               "{result":"venta hecha correctamente}";
                """;
            } else {
                out = """
               "{error":"venta no hecha correctamente}";
                """;
            }

        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("ventalc")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response ventalc(@FormParam("datosVentaLc") @DefaultValue("") String datosVentaLc) {
        Gson gson = new Gson();
        DetalleVentaPre dvp = new DetalleVentaPre();
        String out = "";
        dvp = gson.fromJson(datosVentaLc, DetalleVentaPre.class);
        ControllerVentaLente cvp = new ControllerVentaLente();
        try {
            boolean r = cvp.generarVentaLC(dvp);
            if (r) {
                out = """
                      {"result":"venta hecha correctamente"}
                """;
            } else {
                out = """
                      {"error":"venta no hecha correctamente"}
                """;
            }

        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
     @Path("generarVLC")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDVPL(@FormParam("datosVLC") @DefaultValue("") String datosVLC) {
        Gson gson = new Gson();
         DetalleVentaPresupuestoLentes dvplc; 
        String out = "";
        dvplc = gson.fromJson(datosVLC, DetalleVentaPresupuestoLentes.class);
        ControllerVentaLente cvl = new ControllerVentaLente();
        System.out.println(dvplc.toString());
        try {
            boolean r = cvl.generarVentaLentes(dvplc);
            if (r) {
                out = """
                      {"result":"venta hecha correctamente"}
                """;
            } else {
                out = """
                      {"error":"venta no hecha correctamente"}
                """;
            }

        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
