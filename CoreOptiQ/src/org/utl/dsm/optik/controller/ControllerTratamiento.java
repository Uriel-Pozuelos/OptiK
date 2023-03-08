
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.model.Tratamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;

/**
 *
 * @author urieh
 */
public class ControllerTratamiento {
    public int insertarTratamiento(Tratamiento tratamiento) throws SQLException{
        String query = "{CALL insertarTratamiento(?,?,?,?)}";
        int idTratamiento =0;
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, tratamiento.getNombre());
        cstmt.setDouble(2, tratamiento.getPrecioCompra());
        cstmt.setDouble(3, tratamiento.getPrecioVenta());
        
        cstmt.registerOutParameter(4, Types.INTEGER);
        
        cstmt.executeUpdate();
        
        idTratamiento = cstmt.getInt(4);
        
        tratamiento.setIdTratamiento(idTratamiento);
        
        cstmt.close();
        conn.close();
        conexion.close();
        
        return idTratamiento;
    }
    
     public List<Tratamiento> getAll(String filtro) throws SQLException{
        String query = "SELECT * FROM vista_tratamiento WHERE estatus="+filtro+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        List<Tratamiento> tratamiento = new ArrayList<>();
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Tratamiento m = new Tratamiento();
            
            m.setIdTratamiento(rs.getInt("idTratamiento"));
            m.setNombre(rs.getString("nombre"));
            m.setPrecioCompra(rs.getDouble("precioCompra"));
            m.setPrecioVenta(rs.getDouble("precioVenta"));
            m.setEstatus(rs.getInt("estatus"));
            
            tratamiento.add(m);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return tratamiento;
    }
    
     public List<Tratamiento> getAllIn(String filtroIna) throws SQLException{
        String query = "SELECT * FROM vista_tratamiento WHERE estatus="+filtroIna+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        List<Tratamiento> tratamiento = new ArrayList<>();
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Tratamiento m = new Tratamiento();
            
            m.setIdTratamiento(rs.getInt("idTratamiento"));
            m.setNombre(rs.getString("nombre"));
            m.setPrecioCompra(rs.getDouble("precioCompra"));
            m.setPrecioVenta(rs.getDouble("precioVenta"));
            m.setEstatus(rs.getInt("estatus"));
            
            tratamiento.add(m);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return tratamiento;
    } 
     
     
     public void actualizar(Tratamiento tratamiento) throws SQLException{
        String query = "{CALL actualizarTratamiento(?,?,?,?)}";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
         cstmt.setInt(1, tratamiento.getIdTratamiento());
        cstmt.setString(2, tratamiento.getNombre());
        cstmt.setDouble(3, tratamiento.getPrecioCompra());
        cstmt.setDouble(4, tratamiento.getPrecioVenta());
       
        
        
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    } 
     
    public void eliminar(Tratamiento tratamiento) throws SQLException{
        
        String query = "{CALL eliminarTratamiento(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, tratamiento.getIdTratamiento());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
    
   public void activar(Tratamiento tratamiento) throws SQLException{
        String query = "{CALL activarTratamiento(?)}";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, tratamiento.getIdTratamiento());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
    
}
