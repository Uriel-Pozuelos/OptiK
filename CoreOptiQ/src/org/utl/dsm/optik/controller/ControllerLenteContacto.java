
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.LenteContacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.model.Producto;

public class ControllerLenteContacto {

    public int insert(LenteContacto lenteContacto) throws Exception {
        String query = "{CALL insertarLenteContacto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        int idProducto = 0;
        int idLenteContacto = 0;
        String codigoBarras = "";
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, lenteContacto.getProducto().getNombre());
        cstmt.setString(2, lenteContacto.getProducto().getMarca());
        cstmt.setDouble(3, lenteContacto.getProducto().getPrecioCompra());
        cstmt.setDouble(4, lenteContacto.getProducto().getPrecioVenta());
        cstmt.setInt(5, lenteContacto.getProducto().getExistencias());
        cstmt.setString(6, lenteContacto.getKeratometria());
        cstmt.setString(7, lenteContacto.getFotografia());
        cstmt.setString(8, lenteContacto.getTipo());
        cstmt.registerOutParameter(9, Types.INTEGER);
        cstmt.registerOutParameter(10, Types.INTEGER);
        cstmt.registerOutParameter(11, Types.VARCHAR);
        cstmt.executeUpdate();
        idProducto= cstmt.getInt(9);
        idLenteContacto = cstmt.getInt(10);
        codigoBarras = cstmt.getString(11);
        // asignar los valores de los parametros de salida al objeto LenteContacto
        lenteContacto.setIdLenteContacto(idLenteContacto);
        lenteContacto.getProducto().setIdProducto(idProducto);
        lenteContacto.getProducto().setCodigoBarras(codigoBarras);

        cstmt.close();
        conn.close();
        conexion.close();


        return idLenteContacto;
    }

    public List<LenteContacto> getAll(String filtro) throws Exception {
        String query = "SELECT * FROM v_lentecontacto where estatus = " + filtro + "";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        List<LenteContacto> lentesContacto = new ArrayList<>();
        while (rs.next()) {
            LenteContacto lenteContacto = new LenteContacto();
            Producto producto= new Producto();
            lenteContacto.setIdLenteContacto(rs.getInt("idLenteContacto"));
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setCodigoBarras(rs.getString("codigoBarras"));
            producto.setNombre(rs.getString("nombre"));
            producto.setMarca(rs.getString("marca"));
            producto.setPrecioCompra(rs.getDouble("precioCompra"));
            producto.setPrecioVenta(rs.getDouble("precioVenta"));
            producto.setExistencias(rs.getInt("existencias"));
            lenteContacto.setKeratometria(rs.getString("keratometria"));
            lenteContacto.setFotografia(rs.getString("fotografia"));
            lenteContacto.setTipo(rs.getString("tipo"));
            producto.setEstatus(rs.getInt("estatus"));
            
            lenteContacto.setProducto(producto);
            lentesContacto.add(lenteContacto);
        }
        rs.close();
        stmt.close();
        conn.close();

        return lentesContacto;
    }

    public String updateLenteContacto(LenteContacto lenteContacto) throws Exception {
        String query = "{CALL actualizarLenteContacto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setInt(1, lenteContacto.getProducto().getIdProducto());
        cstmt.setInt(2, lenteContacto.getIdLenteContacto());
        cstmt.setString(3, lenteContacto.getProducto().getNombre());
        cstmt.setString(4, lenteContacto.getProducto().getMarca());
        cstmt.setDouble(5, lenteContacto.getProducto().getPrecioCompra());
        cstmt.setDouble(6, lenteContacto.getProducto().getPrecioVenta());
        cstmt.setInt(7, lenteContacto.getProducto().getExistencias());
        cstmt.setString(8, lenteContacto.getKeratometria());
        cstmt.setString(9, lenteContacto.getTipo());
        cstmt.setString(10, lenteContacto.getFotografia());
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Lente de contacto actualizado";
    }

    public String deleteLenteContacto(String idProducto) throws Exception {
        String query = "{CALL eliminarLenteContacto(?)}";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, idProducto);
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Lente de contacto eliminado";
    }

    public String activateLenteContacto(String idProducto) throws Exception {
        String query = "{CALL activarLenteContacto(?)}";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, idProducto);
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        conexion.close();
        return "Lente de contacto activado";
    }
    
}
