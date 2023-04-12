
package org.utl.dsm.optik.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Armazon;
import org.utl.dsm.optik.model.Cliente;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Examen_Vista;
import org.utl.dsm.optik.model.GraduacionLentes;
import org.utl.dsm.optik.model.LenteContacto;
import org.utl.dsm.optik.model.Material;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Presupuesto;
import org.utl.dsm.optik.model.PresupuestoLentes;
import org.utl.dsm.optik.model.PresupuestoLentesContacto;
import org.utl.dsm.optik.model.PresupuestoLentesTratamientos;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Tipo_mica;
import org.utl.dsm.optik.model.Tratamiento;
import org.utl.dsm.optik.model.Usuario;
import org.utl.dsm.optik.model.Venta;
import org.utl.dsm.optik.model.VentaPresupuesto;
import org.utl.dsm.optik.model.VentaPresupuestoLC;
import org.utl.dsm.optik.model.VentaProducto;
import org.utl.dsm.optik.model.DetalleVentaPresupuestoLentes;
import org.utl.dsm.optik.model.DetalleVentaProducto;
import org.utl.dsm.optik.model.VentaPresupuesto;

public class ControllerGetAllVentas {
    public List<DetalleVentaProducto> getAllDetalleVentaProducto() throws SQLException {
        String query = "SELECT * FROM vista_venta_producto;";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<DetalleVentaProducto> detalleVentaProductos = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            DetalleVentaProducto dvp = new DetalleVentaProducto();
            List<VentaProducto> listaVentaProducto = new ArrayList<VentaProducto>();
            Producto p = new Producto();
            Venta v = new Venta();
            Empleado e = new Empleado();
            Persona pe = new Persona();
            Usuario u = new Usuario();
            VentaProducto vp = new VentaProducto();           
            
            v.setIdVenta(rs.getInt("idVenta"));
            e.setIdEmpleado(rs.getInt("idEmpleado"));
            pe.setIdPersona(rs.getInt("idPersona"));
            pe.setNombre(rs.getString("persona_name"));
            pe.setApellidoPaterno(rs.getString("apellidoPaterno"));
            pe.setApellidoMaterno(rs.getString("apellidoMaterno"));
            pe.setGenero(rs.getString("genero"));
            pe.setFechaNacimiento(rs.getString("fechaNacimiento"));
            pe.setCalle(rs.getString("calle"));
            pe.setNumero(rs.getString("numero"));
            pe.setColonia(rs.getString("colonia"));
            pe.setCp(rs.getString("cp"));
            pe.setCiudad(rs.getString("ciudad"));
            pe.setEstado(rs.getString("estado"));
            pe.setTelCasa(rs.getString("telcasa"));
            pe.setTelMovil(rs.getString("telmovil"));
            pe.setEmail(rs.getString("email"));
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("persona_name"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            u.setLastToken(rs.getString("lastToken"));
            u.setDateLastToken(rs.getString("dateLastToken"));
            e.setNumeroUnico(rs.getString("numeroUnico"));
            e.setEstatus(rs.getInt("empleado_estatus"));
            v.setClave(rs.getString("clave"));
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigoBarras(rs.getString("codigoBarras"));
            p.setNombre(rs.getString("nombre"));
            p.setMarca(rs.getString("marca"));
            p.setPrecioCompra(rs.getDouble("precioCompra"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setExistencias(rs.getInt("existencias"));
            p.setEstatus(rs.getInt("estatus"));
            vp.setCantidad(rs.getInt("cantidad"));
            vp.setPrecioUnitario(rs.getDouble("precioUnitario"));
            vp.setDescuento(rs.getDouble("descuento"));

            //hacer una segunda consulta para obtener las venta_producto
            String query2 = "SELECT * FROM venta_producto WHERE idVenta = " +  rs.getInt("idVenta") + ";";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                VentaProducto vp2 = new VentaProducto();
                vp2.setCantidad(rs2.getInt("cantidad"));
                vp2.setPrecioUnitario(rs2.getDouble("precioUnitario"));
                vp2.setDescuento(rs2.getDouble("descuento"));
                //agregar el producto a la venta en base al idProducto
                Producto p2 = new Producto();
                p2.setIdProducto(rs2.getInt("idProducto"));
               //hacer otra consulta para obtener el producto
                String query3 = "SELECT * FROM producto WHERE idProducto = " +  rs2.getInt("idProducto") + ";";
                PreparedStatement pstmt3 = conn.prepareStatement(query3);
                ResultSet rs3 = pstmt3.executeQuery();
                while (rs3.next()){
                    p2.setIdProducto(rs.getInt("idProducto"));
                    p2.setCodigoBarras(rs.getString("codigoBarras"));
                    p2.setNombre(rs.getString("nombre"));
                    p2.setMarca(rs.getString("marca"));
                    p2.setPrecioCompra(rs.getDouble("precioCompra"));
                    p2.setPrecioVenta(rs.getDouble("precioVenta"));
                    p2.setExistencias(rs.getInt("existencias"));
                    p2.setEstatus(rs.getInt("estatus"));


                }

                vp2.setProducto(p2);
                listaVentaProducto.add(vp2);
            }


            e.setPersona(pe);
            e.setUsuario(u);
            v.setEmpleado(e);
            vp.setProducto(p);;
            dvp.setVentasProducto(listaVentaProducto);
            dvp.setVenta(v);
            detalleVentaProductos.add(dvp);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return detalleVentaProductos;
    }

    
    public List<DetalleVentaPresupuestoLentes> getAllVentaLenteContacto() throws SQLException {
        String query = "SELECT * FROM vista_venta_lente_contacto;";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<DetalleVentaPresupuestoLentes> detalleVentaProducto = new ArrayList<>();
        List<VentaPresupuesto> listaVentaPresupuesto = new ArrayList<VentaPresupuesto>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            PresupuestoLentesTratamientos plt = new PresupuestoLentesTratamientos();
            PresupuestoLentes pl = new PresupuestoLentes();
            Presupuesto p = new Presupuesto();
            Examen_Vista ex = new Examen_Vista();
            Empleado e = new Empleado();
            Persona per = new Persona();
            Usuario u = new Usuario();
            Cliente c = new Cliente();
            Persona pec = new Persona();
            GraduacionLentes g = new GraduacionLentes();
            Tipo_mica tp = new Tipo_mica();
            Material m = new Material();
            Armazon a = new Armazon();
            Producto pr = new Producto();
            Tratamiento t = new Tratamiento();
            VentaPresupuesto vp = new VentaPresupuesto();
            Venta v = new Venta();
            DetalleVentaPresupuestoLentes vpv = new DetalleVentaPresupuestoLentes();
            
            pl.setIdPresupuestoLentes(rs.getInt("idPresupuestoLentes"));
            p.setIdPresupuesto(rs.getInt("idPresupuesto"));
            ex.setIdExamenVista(rs.getInt("idExamenVista"));
            ex.setClave(rs.getString("clave"));
            e.setIdEmpleado(rs.getInt("idEmpleado"));
            per.setIdPersona(rs.getInt("idPersona_empleado"));
            per.setNombre(rs.getString("empleado_name"));
            per.setApellidoPaterno(rs.getString("empleado_apellidoPaterno"));
            per.setApellidoMaterno(rs.getString("empleado_apellidoMaterno"));
            per.setGenero(rs.getString("empleado_genero"));
            per.setFechaNacimiento(rs.getString("empleado_fechaNacimiento"));
            per.setCalle(rs.getString("empleado_Calle"));
            per.setNumero(rs.getString("empleado_Numero"));
            per.setColonia(rs.getString("empleado_Colonia"));
            per.setCp(rs.getString("empleado_Cp"));
            per.setCiudad(rs.getString("empleado_Ciudad"));
            per.setEstado(rs.getString("empleado_Estado"));
            per.setTelCasa(rs.getString("empleado_Telcasa"));
            per.setTelMovil(rs.getString("empleado_Telmovil"));
            per.setEmail(rs.getString("empleado_Email"));
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("user_name"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            u.setLastToken(rs.getString("lastToken"));
            u.setDateLastToken(rs.getString("dateLastToken"));
            e.setNumeroUnico(rs.getString("empleado_numeroUnico"));
            e.setEstatus(rs.getInt("empleado_estatus"));
            c.setIdCliente(rs.getInt("idCliente"));
            pec.setIdPersona(rs.getInt("idPersona_cliente"));
            pec.setNombre(rs.getString("cliente_name"));
            pec.setApellidoPaterno(rs.getString("cliente_apellidoPaterno"));
            pec.setApellidoMaterno(rs.getString("cliente_apellidoMaterno"));
            pec.setGenero(rs.getString("cliente_genero"));
            pec.setFechaNacimiento(rs.getString("cliente_fechaNacimiento"));
            pec.setCalle(rs.getString("cliente_Calle"));
            pec.setNumero(rs.getString("cliente_Numero"));
            pec.setColonia(rs.getString("cliente_Colonia"));
            pec.setCp(rs.getString("cliente_Cp"));
            pec.setCiudad(rs.getString("cliente_Ciudad"));
            pec.setEstado(rs.getString("cliente_Estado"));
            pec.setTelCasa(rs.getString("cliente_Telcasa"));
            pec.setTelMovil(rs.getString("cliente_Telmovil"));
            pec.setEmail(rs.getString("cliente_Email"));
            c.setNumeroUnico(rs.getString("cliente_numeroUnico"));
            c.setEstatus(rs.getInt("cliente_estatus"));
            g.setIdGraduacion(rs.getInt("idGraduacion"));
            g.setEsferaod(rs.getDouble("esferaod"));
            g.setEsferaoi(rs.getDouble("esferaoi"));
            g.setCilindrood(rs.getInt("cilindrood"));
            g.setCilindrooi(rs.getInt("cilindrooi"));
            g.setEjeoi(rs.getInt("ejeoi"));
            g.setEjeod(rs.getInt("ejeod"));
            g.setDip(rs.getString("dip"));
            g.setEstatus(rs.getInt("estatus"));
            ex.setFecha(rs.getString("fecha"));
            ex.setEstatus(rs.getInt("examenVista_estatus"));
            pl.setAlturaOblea(rs.getInt("alturaOblea"));
            tp.setIdTipoMica(rs.getInt("idTipoMica"));
            tp.setNombre(rs.getString("mica_nombre"));
            tp.setPrecioCompra(rs.getDouble("mica_pc"));
            tp.setPrecioVenta(rs.getDouble("mica_pv"));
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setNombre(rs.getString("material_nombre"));
            m.setPrecioCompra(rs.getDouble("material_pc"));
            m.setPrecioVenta(rs.getDouble("material_pv"));
            m.setEstatus(rs.getInt("material_estatus"));
            a.setIdArmazon(rs.getInt("idArmazon"));
            pr.setIdProducto(rs.getInt("idProducto"));
            pr.setCodigoBarras(rs.getString("codigoBarras"));
            pr.setNombre(rs.getString("nombre"));
            pr.setMarca(rs.getString("marca"));
            pr.setPrecioCompra(rs.getDouble("precioCompra"));
            pr.setPrecioVenta(rs.getDouble("precioVenta"));
            pr.setExistencias(rs.getInt("existencias"));
            pr.setEstatus(rs.getInt("producto_estatus"));
            a.setModelo(rs.getString("modelo"));
            a.setColor(rs.getString("modelo_color"));
            a.setDimensiones(rs.getString("modelo_dimensiones"));
            a.setDescripcion(rs.getString("modelo_descripcion"));
            a.setFotografia(rs.getString("modelo_fotografia"));
            t.setIdTratamiento(rs.getInt("idTratamiento"));
            t.setNombre(rs.getString("tratamiento_nombre"));
            t.setPrecioCompra(rs.getDouble("tratamiento_pc"));
            t.setPrecioVenta(rs.getDouble("tratamiento_pv"));
            t.setEstatus(rs.getInt("tratamiento_estatus"));
            vp.setCantidad(rs.getInt("cantidad"));
            vp.setPrecioUnitario(rs.getDouble("precioUnitario"));
            vp.setDescuento(rs.getDouble("descuento"));
            v.setClave(rs.getString("clave"));
            v.setIdVenta(rs.getInt("idVenta"));
           
            c.setPersona(pec);
            e.setPersona(per);
            e.setUsuario(u);
            ex.setCliente(c);
            ex.setEmpleado(e);
            ex.setGraduacion(g);
            p.setExamenVista(ex);
            a.setProducto(pr);
            pl.setPresupuesto(p);
            pl.setTipoMica(tp);
            pl.setMaterial(m);
            pl.setArmazon(a);
            plt.setPresupuestoLentes(pl);
            plt.setTratamiento(t);
            v.setEmpleado(e);
            vpv.setVenta(v);
            vp.setVenta(v);
            //hacer otra consulta para obtener los datos de la tabla venta_presupuesto
            String query2 = "SELECT * FROM venta_presupuesto WHERE idVenta = ?;";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setInt(1, v.getIdVenta());
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                vp.setCantidad(rs2.getInt("cantidad"));
                vp.setPrecioUnitario(rs2.getDouble("precioUnitario"));
                vp.setDescuento(rs2.getDouble("descuento"));
                vp.setVenta(v);
                listaVentaPresupuesto.add(vp);
            }

            vpv.setVentaPresupuesto(listaVentaPresupuesto);
            
            detalleVentaProducto.add(vpv);
 
        }
        rs.close();

        pstmt.close();
        conn.close();
        return detalleVentaProducto;
    }
    
    public List<PresupuestoLentesContacto> getAllVentaLente() throws SQLException {
        String query = "SELECT * FROM vista_venta_lente;";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<PresupuestoLentesContacto> PresupuestoLentesContacto = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            PresupuestoLentesContacto pl = new PresupuestoLentesContacto();
            Examen_Vista ex = new Examen_Vista();
            Empleado e = new Empleado();
            Persona p = new Persona();
            Usuario u = new Usuario();
            Cliente c = new Cliente();
            Persona pc = new Persona();
            GraduacionLentes g = new GraduacionLentes();
            LenteContacto lc = new LenteContacto();
            Producto pr = new Producto();
            VentaPresupuesto vp = new VentaPresupuesto();
      
            pl.setIdPresupuestoLentesContacto(rs.getInt("idPresupuestoLentesContacto"));
            ex.setIdExamenVista(rs.getInt("idExamenVista"));
            ex.setClave(rs.getString("examenVista_clave"));
            e.setIdEmpleado(rs.getInt("idEmpleado"));
            p.setIdPersona(rs.getInt("idPersona_empleado"));
            p.setNombre(rs.getString("empleado_name"));
            p.setApellidoPaterno(rs.getString("empleado_apellidoPaterno"));
            p.setApellidoMaterno(rs.getString("empleado_apellidoMaterno"));
            p.setGenero(rs.getString("empleado_genero"));
            p.setFechaNacimiento(rs.getString("empleado_fechaNacimiento"));
            p.setCalle(rs.getString("empleado_Calle"));
            p.setNumero(rs.getString("empleado_Numero"));
            p.setColonia(rs.getString("empleado_Colonia"));
            p.setCp(rs.getString("empleado_Cp"));
            p.setCiudad(rs.getString("empleado_Ciudad"));
            p.setEstado(rs.getString("empleado_Estado"));
            p.setTelCasa(rs.getString("empleado_Telcasa"));
            p.setTelMovil(rs.getString("empleado_Telmovil"));
            p.setEmail(rs.getString("empleado_Email"));
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("user_name"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            u.setLastToken(rs.getString("lastToken"));
            u.setDateLastToken(rs.getString("dateLastToken"));
            e.setNumeroUnico(rs.getString("empleado_numeroUnico"));
            e.setEstatus(rs.getInt("empleado_estatus"));
            c.setIdCliente(rs.getInt("idCliente"));
            pc.setIdPersona(rs.getInt("idPersona_cliente"));
            pc.setIdPersona(rs.getInt("idPersona_cliente"));
            pc.setNombre(rs.getString("cliente_name"));
            pc.setApellidoPaterno(rs.getString("cliente_apellidoPaterno"));
            pc.setApellidoMaterno(rs.getString("cliente_apellidoMaterno"));
            pc.setGenero(rs.getString("cliente_genero"));
            pc.setFechaNacimiento(rs.getString("cliente_fechaNacimiento"));
            pc.setCalle(rs.getString("cliente_Calle")); 
            pc.setNumero(rs.getString("cliente_Numero"));
            pc.setColonia(rs.getString("cliente_Colonia"));
            pc.setCp(rs.getString("cliente_Cp"));
            pc.setCiudad(rs.getString("cliente_Ciudad"));
            pc.setEstado(rs.getString("cliente_Estado"));
            pc.setTelCasa(rs.getString("cliente_Telcasa"));
            pc.setTelMovil(rs.getString("cliente_Telmovil"));
            pc.setEmail(rs.getString("cliente_Email"));
            c.setNumeroUnico(rs.getString("cliente_numeroUnico"));
            c.setEstatus(rs.getInt("cliente_estatus"));
            g.setIdGraduacion(rs.getInt("idGraduacion"));
            g.setEsferaod(rs.getDouble("esferaod"));
            g.setEsferaoi(rs.getDouble("esferaoi"));
            g.setCilindrood(rs.getInt("cilindrood"));
            g.setCilindrooi(rs.getInt("cilindrooi"));
            g.setEjeoi(rs.getInt("ejeoi"));
            g.setEjeod(rs.getInt("ejeod"));
            g.setDip(rs.getString("dip"));
            g.setEstatus(rs.getInt("estatus"));
            ex.setFecha(rs.getString("fecha"));
            ex.setEstatus(rs.getInt("examenVista_estatus"));
            lc.setIdLenteContacto(rs.getInt("idLenteContacto"));
            lc.setKeratometria(rs.getString("keratometria"));
            lc.setFotografia(rs.getString("fotografia"));
            lc.setTipo(rs.getString("tipo"));
            pr.setCodigoBarras(rs.getString("codigoBarras"));
            pr.setNombre(rs.getString("nombre"));
            pr.setMarca(rs.getString("marca"));
            pr.setPrecioCompra(rs.getDouble("precioCompra"));
            pr.setPrecioVenta(rs.getDouble("precioVenta"));
            pr.setExistencias(rs.getInt("existencias"));
            pr.setEstatus(rs.getInt("producto_estatus"));
            vp.setCantidad(rs.getInt("cantidad"));
            vp.setPrecioUnitario(rs.getDouble("precioUnitario"));
            vp.setDescuento(rs.getDouble("descuento"));
            pl.setClave(rs.getString("clave"));
            
            e.setUsuario(u);
            e.setPersona(p);
            c.setPersona(pc);
            ex.setGraduacion(g);
            ex.setCliente(c);
            ex.setEmpleado(e);
            lc.setProducto(pr);
            pl.setLenteContacto(lc);
            //examenVista ex, ventaPresupuesto vp agregarlo a la lista de PresupuestoLentesContacto
            PresupuestoLentesContacto.add(pl);
            
        }
        rs.close();
        pstmt.close();
        conn.close();
        return PresupuestoLentesContacto;
    }
}
