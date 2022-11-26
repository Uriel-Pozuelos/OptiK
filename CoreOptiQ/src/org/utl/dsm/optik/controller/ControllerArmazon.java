/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;


import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Armazon;
import org.utl.dsm.optik.model.Producto;

/**
 *
 * @author urieh
 */
public class ControllerArmazon {
     public int insertar(Armazon armazon) throws Exception{
        //Paso 1: Preparar la sentencia sql
        String query = "{call insertarArmazon(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int idProducto = 0;
        int idArmazon = 0;
        String codigoBarras = "";
        
        //Paso 2: Conectar a la BD
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
         CallableStatement cstmt = conn.prepareCall(query);
        // armazon(idProducto, modelo, color, dimensiones, descripcion, fotografia)
        
        //Paso 4: Asignar los valores para cada parametro
        cstmt.setString(1, armazon.getProducto().getNombre());
        cstmt.setString(2, armazon.getProducto().getMarca());
        cstmt.setString(3, armazon.getModelo());
        cstmt.setString(4, armazon.getColor());
        cstmt.setString(5, armazon.getDescripcion());
        cstmt.setString(6, armazon.getFotografia());
        cstmt.setString(7, armazon.getDimensiones());
        cstmt.setDouble(8, armazon.getProducto().getPrecioCompra());
        cstmt.setDouble(9, armazon.getProducto().getPrecioVenta());
        cstmt.setInt(10, armazon.getProducto().getExistencias());
        
        //Paso 5: Registrar parametros de salida del procedure
        cstmt.registerOutParameter(11, Types.INTEGER);
        cstmt.registerOutParameter(12, Types.INTEGER);
        cstmt.registerOutParameter(13, Types.VARCHAR);
        
        //Paso 6: Ejecutar la llamada al procedure
        cstmt.executeUpdate();
        
        // Paso 7 recuperar los parametros de salida 
        idProducto = cstmt.getInt(11);
        idArmazon = cstmt.getInt(12);
        codigoBarras = cstmt.getString(13);
        
        // Paso 8 insertar los valores en el objeto 
        armazon.getProducto().setIdProducto(idProducto);
        armazon.setIdArmazon(idArmazon);
        armazon.getProducto().setCodigoBarras(codigoBarras);
        
        // Paso 9 cerrar objetos de conexion 
        cstmt.close();
        conn.close();
        conexion.close();
        
        // Paso 10 devolver o return el id generado
        return idArmazon;
    }
    
    public void actualizar(Armazon armazon) throws Exception{
        //Paso 1: Preparar la sentencia sql
        String query = "{call actualizarArmazon(?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        //Paso 2: Conectar a la BD
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);
        //Paso 4: Asignar los valores para cada parametro
        
        cstmt.setString(1, armazon.getProducto().getNombre());
        cstmt.setString(2, armazon.getProducto().getMarca());
        cstmt.setString(3, armazon.getModelo());
        cstmt.setString(4, armazon.getColor());
        cstmt.setString(5, armazon.getDescripcion());
        cstmt.setString(6, armazon.getFotografia());
        cstmt.setString(7, armazon.getDimensiones());
        cstmt.setDouble(8, armazon.getProducto().getPrecioCompra());
        cstmt.setDouble(9, armazon.getProducto().getPrecioVenta());
        cstmt.setInt(10, armazon.getProducto().getExistencias());
        cstmt.setInt(11, armazon.getProducto().getIdProducto());
        cstmt.setInt(12, armazon.getIdArmazon());
        
        //Paso 6: Ejecutar la llamada al procedure
        cstmt.executeUpdate();
        
        // Paso 7 recuperar los parametros de salida 
        // Paso 8 insertar los valores en el objeto 
        // Paso 9 cerrar objetos de conexion 
        cstmt.close();
        conn.close();
        conexion.close();
        
        // Paso 10 devolver o return el id generado
    }
    
    public List<Armazon> getAll (String filtro) throws SQLException{
        
        String query="SELECT * FROM vista_armazon WHERE estatus="+filtro+"";
        System.out.println(query);
        ConexionMySQL objConexion= new ConexionMySQL();
        Connection conn=objConexion.open();
        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Armazon> armazon = new ArrayList<>();
        ResultSet rs= pstmt.executeQuery();
        while(rs.next()){
            Armazon e = new Armazon();
            Producto u = new Producto();
            //
            u.setIdProducto(rs.getInt("idProducto"));
            u.setNombre(rs.getString("nombre"));
            u.setCodigoBarras(rs.getString("codigoBarras"));
            u.setMarca(rs.getString("marca"));
            u.setPrecioCompra(rs.getDouble("precioCompra"));
            u.setPrecioVenta(rs.getDouble("precioVenta"));
            u.setExistencias(rs.getInt("existencias"));
            u.setEstatus(rs.getInt("estatus"));
            e.setProducto(u);
            e.setIdArmazon(rs.getInt("idArmazon"));
            e.setModelo(rs.getString("modelo"));
            e.setColor(rs.getString("color"));
            e.setDimensiones(rs.getString("dimensiones"));
            e.setDescripcion(rs.getString("descripcion"));
            e.setFotografia(rs.getString("fotografia"));
            armazon.add(e);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return armazon;
    }
    
    public String actualizarArmazon(Armazon armazon) throws SQLException{
        String query = "{call actualizarArmazon(?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL objConection = new ConexionMySQL();
        Connection conn = objConection.open();
         CallableStatement cstmt = conn.prepareCall(query);
        //armazon set modelo = var_modelo, color=var_color, dimensiones = var_dimensiones, 
        //descripcion= var_descripcion, fotografia = var_fotografia where idArmazon = var_idArmazon;
        
        cstmt.setString(1, armazon.getProducto().getNombre());
        cstmt.setString(2, armazon.getProducto().getMarca());
        cstmt.setString(3, armazon.getModelo());
        cstmt.setString(4, armazon.getColor());
        cstmt.setString(5, armazon.getDescripcion());
        cstmt.setString(6, armazon.getFotografia());
        cstmt.setString(7, armazon.getDimensiones());
        cstmt.setDouble(8, armazon.getProducto().getPrecioCompra());
        cstmt.setDouble(9, armazon.getProducto().getPrecioVenta());
        cstmt.setInt(10, armazon.getProducto().getExistencias());
        cstmt.setInt(11, armazon.getProducto().getIdProducto());
        cstmt.setInt(12, armazon.getIdArmazon());
        
        cstmt.execute();
        objConection.close();
        conn.close();
        cstmt.close();
        return "Se actualizo correctamente";
    }
    
    public String actualizarEstatus(int idArmazon, int estatus) throws SQLException{
        String query = "{call actulizarEstatusA(?,?)}";
        ConexionMySQL objConection = new ConexionMySQL();
        Connection conn = objConection.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setInt(1,estatus);
        cstmt.setInt(2,idArmazon);
        cstmt.execute();
        objConection.close();
        conn.close();
        cstmt.close();
        return "Se actualizo estatus";
    }
    
}
