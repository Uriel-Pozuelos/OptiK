package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;

public class LoginController {
    public int login(Usuario usuario) throws Exception {
        System.out.println(usuario.toString());
       String query = "CALL login(?,?,?)";
       int resultado = 0;
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, usuario.getNombre());
        cstmt.setString(2, usuario.getContrasenia());
        cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        resultado = cstmt.getInt(3);
        cstmt.close();
        conn.close();
        conexion.close();
        return resultado;
    }

}
