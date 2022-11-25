package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Accesorio;
import org.utl.dsm.optik.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerAccesorio {

    public int insertAccesorio(Accesorio accesorio) throws Exception {
        String query = "CALL insertarAccesorio(?, ?, ?, ?, ?, ?, ?, ?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        int idProducto;
        int idAccesorio;
        String codigoBarras ;

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, accesorio.getProducto().getNombre());
        cstmt.setString(2, accesorio.getProducto().getMarca());
        cstmt.setDouble(3, accesorio.getProducto().getPrecioCompra());
        cstmt.setDouble(4, accesorio.getProducto().getPrecioVenta());
        cstmt.setInt(5, accesorio.getProducto().getExistencias());
        //valores de regreso
        cstmt.registerOutParameter(6, java.sql.Types.INTEGER);
        cstmt.registerOutParameter(7, java.sql.Types.INTEGER);
        cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
        cstmt.execute();

        idProducto = cstmt.getInt(6);
        idAccesorio = cstmt.getInt(7);
        codigoBarras = cstmt.getString(8);

        accesorio.getProducto().setIdProducto(idProducto);
        accesorio.setIdAccesorio(idAccesorio);
        accesorio.getProducto().setCodigoBarras(codigoBarras);

        cstmt.close();
        conn.close();
        conexion.close();

        return idProducto;
    }

    public List<Accesorio> getAccesorios(String filtro) throws Exception{
        String query = "select * from vistaAccesorio where estatus ="+ filtro +"";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        List<Accesorio> accesorios = new ArrayList<>();
        while (rs.next()){
            Accesorio accesorio = new Accesorio();
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setCodigoBarras(rs.getString("codigoBarras"));
            producto.setNombre(rs.getString("nombre"));
            producto.setMarca(rs.getString("marca"));
            producto.setPrecioCompra(rs.getDouble("precioCompra"));
            producto.setPrecioVenta(rs.getDouble("precioVenta"));
            producto.setExistencias(rs.getInt("existencias"));
            producto.setEstatus(rs.getInt("estatus"));
            accesorio.setProducto(producto);
            accesorio.setIdAccesorio(rs.getInt("idAccesorio"));
            accesorios.add(accesorio);
        }
        rs.close();
        stmt.close();
        conn.close();
        conexion.close();
        return accesorios;
    }

    public String updateAccesorio(Accesorio accesorio) throws Exception{
        String query = "CALL actualizarAccesorio(?, ?, ?, ?, ?, ?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setInt(1, accesorio.getProducto().getIdProducto());
        cstmt.setString(2, accesorio.getProducto().getNombre());
        cstmt.setString(3, accesorio.getProducto().getMarca());
        cstmt.setDouble(4, accesorio.getProducto().getPrecioCompra());
        cstmt.setDouble(5, accesorio.getProducto().getPrecioVenta());
        cstmt.setInt(6, accesorio.getProducto().getExistencias());

        cstmt.execute();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Accesorio actualizado";
    }

    public String deleteAccesorio(String idProducto) throws Exception{
        String query = "CALL eliminarAccesorio(?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, idProducto);
        cstmt.execute();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Accesorio eliminado";
    }

    public String activarAccesorio(String idProducto) throws Exception{
        String query = "CALL activarAccesorio(?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, idProducto);
        cstmt.execute();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Accesorio activado";
    }
}
