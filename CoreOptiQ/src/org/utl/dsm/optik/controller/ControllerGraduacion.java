
package org.utl.dsm.optik.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.GraduacionLentes;

public class ControllerGraduacion {
     public int insertar(GraduacionLentes gl ) throws SQLException{
        String query = "{CALL insertarGraduacion(?,?,?,?,?,?,?,?)}";
        int idGraduacion =0;
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setDouble(1, gl.getEsferaod());
        cstmt.setDouble(2, gl.getEsferaoi());
        cstmt.setInt(3, gl.getCilindrood());
        cstmt.setInt(4, gl.getCilindrooi());
        cstmt.setInt(6, gl.getEjeoi());
        cstmt.setInt(5, gl.getEjeod());
        cstmt.setString(7, gl.getDip());
        
        
        cstmt.registerOutParameter(8, Types.INTEGER);
        
        cstmt.executeUpdate();
        
        idGraduacion = cstmt.getInt(8);
        
        gl.setIdGraduacion(idGraduacion);
        
        cstmt.close();
        conn.close();
        conexion.close();
        
        return idGraduacion;
    }
     
    public List<GraduacionLentes> getAll(String filtro) throws SQLException{
        String query = "SELECT * FROM vista_graduacion WHERE estatus="+filtro+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        List<GraduacionLentes> graduacion = new ArrayList<>();
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            GraduacionLentes gl = new GraduacionLentes();
            
            gl.setIdGraduacion(rs.getInt("idGraduacion"));
            gl.setEsferaod(rs.getDouble("esferaod"));
            gl.setEsferaoi(rs.getDouble("esferaoi"));
            gl.setCilindrood(rs.getInt("cilindrood"));
            gl.setCilindrooi(rs.getInt("cilindrooi"));
            gl.setEjeoi(rs.getInt("ejeoi"));
            gl.setEjeod(rs.getInt("ejeod"));
            gl.setDip(rs.getString("dip"));
            gl.setEstatus(rs.getInt("estatus"));
            
            graduacion.add(gl);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return graduacion;
    }
    
    public List<GraduacionLentes> getAllIn(String filtroIn) throws SQLException{
        String query = "SELECT * FROM vista_graduacion_inactivas WHERE estatus="+filtroIn+";";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        List<GraduacionLentes> graduacion = new ArrayList<>();
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            GraduacionLentes gl = new GraduacionLentes();
            
            gl.setIdGraduacion(rs.getInt("idGraduacion"));
            gl.setEsferaod(rs.getDouble("esferaod"));
            gl.setEsferaoi(rs.getDouble("esferaoi"));
            gl.setCilindrood(rs.getInt("cilindrood"));
            gl.setCilindrooi(rs.getInt("cilindrooi"));
            gl.setEjeoi(rs.getInt("ejeoi"));
            gl.setEjeod(rs.getInt("ejeod"));
            gl.setDip(rs.getString("dip"));
            gl.setEstatus(rs.getInt("estatus"));
            
            graduacion.add(gl);
        }
        
        rs.close();
        pstmt.close();
        conn.close();

        return graduacion;
    }
    
     public void actualizar(GraduacionLentes gl) throws SQLException{
        String query = "{CALL actualizarGraduacion(?,?,?,?,?,?,?,?)}";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
       cstmt.setDouble(1, gl.getEsferaod());
        cstmt.setDouble(2, gl.getEsferaoi());
        cstmt.setInt(3, gl.getCilindrood());
        cstmt.setInt(4, gl.getCilindrooi());
        cstmt.setInt(6, gl.getEjeod());
        cstmt.setInt(5, gl.getEjeoi());
        cstmt.setString(7, gl.getDip());
        cstmt.setInt(8, gl.getIdGraduacion());
        
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }
     
    public void eliminar(GraduacionLentes gl) throws SQLException{
        
        String query = "{CALL eliminarGraduacion(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, gl.getIdGraduacion());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
    
    public void activar(GraduacionLentes gl) throws SQLException{
        
        String query = "{CALL activarGraduacion(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //Preparar el objeto para que pueda llamar al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, gl.getIdGraduacion());

        cstmt.executeUpdate();
        //Cerrar conexion
        cstmt.close();
        conn.close();
        conexion.close();
    }
}
