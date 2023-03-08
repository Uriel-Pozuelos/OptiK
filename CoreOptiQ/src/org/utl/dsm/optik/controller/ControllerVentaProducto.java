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

    public boolean generarVenta(DetalleVentaProducto dvp) throws SQLException {
        boolean r = false;
        ConexionMySQL conMySQL = new ConexionMySQL();
        Connection conn = conMySQL.open();
        ResultSet rs = null;
        final Statement stmt = conn.createStatement();
        try {
            conn.setAutoCommit(false);
            String query1 = "INSERT INTO venta(idEmpleado,clave) VALUES( " + dvp.getVenta().getEmpleado().getIdEmpleado() + ""
                    + " ," + dvp.getVenta().getClave() + " ";
            stmt.execute(query1);
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID();");
            if (rs.next()) {
                dvp.getVenta().setIdVenta(rs.getInt(1));

            }
            var lista = dvp.getVentasProducto();

            lista.forEach((VentaProducto vp) -> {
                String query2 = "INSERT INTO venta_producto VALUES("
                        + dvp.getVenta().getIdVenta()
                        + "," + vp.getProducto().getIdProducto()
                        + "," + vp.getCantidad() + ","
                        + vp.getPrecioUnitario() + ","
                        + vp.getDescuento();
                try {
                    stmt.execute(query2);
                } catch (Exception ex) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                   
                    }
                }

            });
            conn.commit();
            conn.setAutoCommit(true);
            r = true;
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return r;
        }

        return r;
    }
}
