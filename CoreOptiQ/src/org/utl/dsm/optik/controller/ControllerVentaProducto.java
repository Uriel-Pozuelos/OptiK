/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.model.DetalleVentaProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.VentaProducto;

/**
 *
 * @author urieh
 */
public class ControllerVentaProducto {

   public boolean generarVenta(DetalleVentaProducto dvp) {
        boolean r = false;
        ConexionMySQL conMySQL = new ConexionMySQL();
        Connection conn = conMySQL.open();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String query1 = "INSERT INTO venta (idEmpleado, clave) VALUES(" + dvp.getVenta().getEmpleado().getIdEmpleado() + ",'" + dvp.getVenta().getClave() + "')";
            System.out.println(query1);
            stmt.execute(query1);
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                dvp.getVenta().setIdVenta(rs.getInt(1));
            }

            for (int i = 0; i < dvp.getVentasProducto().size(); i++) {
                String query2 = "INSERT INTO venta_producto VALUES(" + dvp.getVenta().getIdVenta() + "," + dvp.getVentasProducto().get(i).getProducto().getIdProducto() + "," + dvp.getVentasProducto().get(i).getCantidad() + "," + dvp.getVentasProducto().get(i).getPrecioUnitario() + "," + dvp.getVentasProducto().get(i).getDescuento() + ")";
                System.out.println(query2);
                stmt.execute(query2);
               
            }
            conn.commit();
            conn.setAutoCommit(true);

            rs.close();
            stmt.close();
            conn.close();
            conMySQL.close();
            r = true;
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                System.out.println("error");
                conn.rollback();
                conn.setAutoCommit(true);
                conn.close();
                conMySQL.close();
                r = false;
            } catch (SQLException ex1) {
            }
            r = false;
        }
        return r;
    }
}
