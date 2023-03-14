/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Solucion;

/**
 *
 * @author urieh
 */
public class ControllerVenta {
    public List<Producto> getAllSolucion (String filtro) throws SQLException{
        String query = "SELECT * FROM producto WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Producto> producto = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigoBarras(rs.getString("codigoBarras"));
            p.setNombre(rs.getString("nombre"));
            p.setMarca(rs.getString("marca"));
            p.setPrecioCompra(rs.getDouble("precioCompra"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setExistencias(rs.getInt("existencias"));
            p.setEstatus(rs.getInt("estatus"));
            
            producto.add(p);
            
        }
        rs.close();
        pstmt.close();
        conn.close();
        return producto;
    }
    
    public List<Producto> findByString (String filtro) throws SQLException{
        String query = "SELECT * FROM producto WHERE  nombre like '%"+filtro+"%' or codigoBarras like '%"+filtro+"%";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Producto> producto = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigoBarras(rs.getString("codigoBarras"));
            p.setNombre(rs.getString("nombre"));
            p.setMarca(rs.getString("marca"));
            p.setPrecioCompra(rs.getDouble("precioCompra"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setExistencias(rs.getInt("existencias"));
            p.setEstatus(rs.getInt("estatus"));
            
            producto.add(p);
            
        }
        rs.close();
        pstmt.close();
        conn.close();
        return producto;
    }
    
    
   
    
}
