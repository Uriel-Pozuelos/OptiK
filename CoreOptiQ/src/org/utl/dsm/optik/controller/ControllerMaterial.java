
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerMaterial {
    public int insertar(Material material) throws SQLException{
        String query = "{CALL insertarMaterial(?,?,?,?)}";
        int idMaterial = 0;
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, material.getNombre());
        cstmt.setDouble(2, material.getPrecioCompra());
        cstmt.setDouble(3, material.getPrecioVenta());
        
        
        cstmt.registerOutParameter(4, Types.INTEGER);
        
        cstmt.executeUpdate();
        
        idMaterial = cstmt.getInt(4);
        
        material.setIdMaterial(idMaterial);
        
        cstmt.close();
        conn.close();
        conexion.close();
        
        return idMaterial;
    }
    
    public List<Material> getAll(String filtro) throws SQLException{
        String query = "SELECT * FROM vista_material WHERE estatus="+filtro+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Material> materiales = new ArrayList<>();   
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Material m = new Material();
            
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setNombre(rs.getString("nombre"));
            m.setPrecioCompra(rs.getDouble("precioCompra"));
            m.setPrecioVenta(rs.getDouble("precioVenta"));
            m.setEstatus(rs.getInt("estatus"));
            
            materiales.add(m);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return materiales;
    }
    
    public List<Material> getAllIn(String filtroIna) throws SQLException{
        String query = "SELECT * FROM vista_material WHERE estatus="+filtroIna+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        List<Material> materialesIna = new ArrayList<>();
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Material m = new Material();
            
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setNombre(rs.getString("nombre"));
            m.setPrecioCompra(rs.getDouble("precioCompra"));
            m.setPrecioVenta(rs.getDouble("precioVenta"));
            m.setEstatus(rs.getInt("estatus"));
            
            materialesIna.add(m);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return materialesIna;
    }
    public void actualizar(Material material) throws SQLException{
        String query = "{CALL actualizarMaterial(?,?,?,?)}";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, material.getNombre());
        cstmt.setDouble(2, material.getPrecioCompra());
        cstmt.setDouble(3, material.getPrecioVenta());
        cstmt.setInt(4, material.getIdMaterial());
        
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }
    public void eliminar(Material material) throws SQLException{
        
        String query = "{CALL eliminarMaterial(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, material.getIdMaterial());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
    
    public void activar(Material material) throws SQLException{
        String query = "{CALL activarMaterial(?)}";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, material.getIdMaterial());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
    
}
