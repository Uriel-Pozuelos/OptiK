
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
import org.utl.dsm.optik.controller.ControllerCompraProducto;
import org.utl.dsm.optik.controller.EmpleadoController;
import org.utl.dsm.optik.model.Compra;
import org.utl.dsm.optik.model.Compra_Producto;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Producto;


@Path("compraProducto")
public class CompraProductoRest extends Application {
    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarCompraProducto(@FormParam("datosCompraProducto") @DefaultValue("") String datosCompraProducto) {
        Gson gson = new Gson();
        Compra_Producto compraProducto = new Compra_Producto();

        compraProducto = gson.fromJson(datosCompraProducto, Compra_Producto.class);
        ControllerCompraProducto objCE = new ControllerCompraProducto();
        String out = "";
        try {
            objCE.InsertarCompra(compraProducto);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
        }

        out = gson.toJson(compraProducto);

        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("insertarProducto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarPCP(@FormParam("datosPCP") @DefaultValue("") String datosPCP) {
        Gson gsonP = new Gson();
        Compra_Producto pCp = new Compra_Producto();
        String out = "";

        pCp = gsonP.fromJson(datosPCP, Compra_Producto.class);

        ControllerCompraProducto objCEP = new ControllerCompraProducto();

        try {
            objCEP.InsertarProductoCompra(pCp);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        out = gsonP.toJson(pCp);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllEmpleado")
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
    
    @Path("getAllProducto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducto(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerCompraProducto objCE = new ControllerCompraProducto();
            List<Producto> productos;
            productos = objCE.getAllProducto(estatus);
            out = gson.toJson(productos);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
  @Path("getAllCompra")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompra(@FormParam("estatus") @DefaultValue("1") String estatus) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerCompraProducto objCE = new ControllerCompraProducto();
            List<Compra> compras;
            compras = objCE.getAllCompra(estatus);
            out = gson.toJson(compras);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllCompraProducto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompraProductos(@FormParam("idCompra")@DefaultValue("1") String idCompra){
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerCompraProducto objCE = new ControllerCompraProducto();
            List<Compra_Producto> comprasProductos;
            comprasProductos = objCE.getAllCompraProducto(idCompra);
            out = gson.toJson(comprasProductos);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminarCompra")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarCompra(@FormParam("datosCompraProducto") @DefaultValue("") String datosCompraProducto){
        Gson gson = new Gson();
        Compra compraP = new Compra();
        String out = "";
        
        compraP = gson.fromJson(datosCompraProducto, Compra.class);
        
        ControllerCompraProducto objCe = new ControllerCompraProducto();
        
        try {
            objCe.EliminarCompra(compraP);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(compraP);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllCompraCanceladas")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompraCancela(@FormParam("estatus") @DefaultValue("0") String estatusIna) {
        Gson gson = new Gson();
        String out = "";
        try {
            ControllerCompraProducto objCE = new ControllerCompraProducto();
            List<Compra> comprasIna;
            comprasIna = objCE.getAllCompraInactivos(estatusIna);
            out = gson.toJson(comprasIna);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("recuperarCompra")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperarCompra(@FormParam("datosCompraProducto") @DefaultValue("") String datosCompraProducto){
        Gson gson = new Gson();
        Compra compraP = new Compra();
        String out = "";
        
        compraP = gson.fromJson(datosCompraProducto, Compra.class);
        
        ControllerCompraProducto objCe = new ControllerCompraProducto();
        
        try {
            objCe.RecuperarCompra(compraP);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString() + "}";
            
            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
        }
        
        out = gson.toJson(compraP);

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
