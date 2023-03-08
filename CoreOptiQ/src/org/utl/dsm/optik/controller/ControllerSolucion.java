
package org.utl.dsm.optik.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Solucion;

public class ControllerSolucion {
    public int insertarSolucion(Solucion solucion) throws SQLException{
        String query = "{call insertarSolucion(?,?,?,?,?,?,?,?)}";
        int idProductoG = 0;
        int idSolucionG = 0;
        String codigoBarrasG = "";
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, solucion.getProducto().getNombre());
        cstmt.setString(2, solucion.getProducto().getMarca());
        cstmt.setDouble(3, solucion.getProducto().getPrecioCompra());
        cstmt.setDouble(4, solucion.getProducto().getPrecioVenta());
        cstmt.setInt(5, solucion.getProducto().getExistencias());
        
        cstmt.registerOutParameter(6, Types.VARCHAR);
        cstmt.registerOutParameter(7, Types.INTEGER);
        cstmt.registerOutParameter(8, Types.INTEGER);
        
        cstmt.executeUpdate();
        
        codigoBarrasG = cstmt.getString(6);
        idProductoG = cstmt.getInt(7);
        idSolucionG = cstmt.getInt(8);
        
        solucion.getProducto().setCodigoBarras(codigoBarrasG);
        solucion.getProducto().setIdProducto(idProductoG);
        solucion.setIdSolucion(idSolucionG);
        
        cstmt.close();
        conn.close();
        conexion.close();
        
        return idSolucionG;
    }
    
    public void actualizarSolucion(Solucion solucion) throws SQLException{
        String query = "{CALL actualizarSolucion(?,?,?,?,?,?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, solucion.getProducto().getNombre());
        cstmt.setString(2, solucion.getProducto().getMarca());
        cstmt.setDouble(3, solucion.getProducto().getPrecioCompra());
        cstmt.setDouble(4, solucion.getProducto().getPrecioVenta());
        cstmt.setInt(5, solucion.getProducto().getExistencias());
        cstmt.setInt(6, solucion.getProducto().getIdProducto());
        
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }
    
    public void eliminarSolucion(Solucion solucion) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{CALL eliminarSolucion(?)}";

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, solucion.getIdSolucion());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();

    }
    
    public void recuperarSolucion(Solucion solucion) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{CALL recuperarSolucion(?)}";

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, solucion.getIdSolucion());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();

    }
    
    public List<Solucion> getAllSolucion (String filtro) throws SQLException{
        String query = "SELECT * FROM vistaSolucion WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Solucion> soluciones = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Solucion s = new Solucion();
            Producto p = new Producto();
            
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigoBarras(rs.getString("codigoBarras"));
            p.setNombre(rs.getString("nombre"));
            p.setMarca(rs.getString("marca"));
            p.setPrecioCompra(rs.getDouble("precioCompra"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setExistencias(rs.getInt("existencias"));
            p.setEstatus(rs.getInt("estatus"));
            s.setProducto(p);
            s.setIdSolucion(rs.getInt("idSolucion"));
            
            soluciones.add(s);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return soluciones;
    }
    
}
