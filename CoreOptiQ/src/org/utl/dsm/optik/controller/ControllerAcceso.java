
package org.utl.dsm.optik.controller;
import java.sql.*;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;

public class ControllerAcceso {
    
    public Empleado accerder(Usuario usuario)throws Exception{
    String query = "Select * from vista_empleados WHERE nombre = '" +usuario.getNombre() + "'AND contrasenia = '"+ usuario.getContrasenia()+"'";
    ConexionMySQL conexion = new ConexionMySQL();
    Connection conn = conexion.open();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
            Empleado empleado = new Empleado();
            Persona persona = new Persona();
            Usuario usu = new Usuario();
        while (rs.next()) {
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellidoPaterno(rs.getString("apellidoPaterno"));
            persona.setApellidoMaterno(rs.getString("apellidoMaterno"));
            persona.setGenero(rs.getString("genero"));
            persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
            persona.setCalle(rs.getString("calle"));
            persona.setNumero(rs.getString("numero"));
            persona.setColonia(rs.getString("colonia"));
            persona.setCp(rs.getString("cp"));
            persona.setCiudad(rs.getString("ciudad"));
            persona.setEstado(rs.getString("estado"));
            persona.setTelCasa(rs.getString("telCasa"));
            persona.setTelMovil(rs.getString("telMovil"));
            persona.setEmail(rs.getString("email"));
            usu.setNombre(rs.getString("nombreU"));
            usu.setContrasenia(rs.getString("contrasenia"));
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setRol(rs.getString("rol"));
            empleado.setPersona(persona);
            empleado.setUsuario(usuario);
            empleado.setIdEmpleado(rs.getInt("idEmpleado"));
            empleado.setNumeroUnico(rs.getString("numeroUnico"));
            empleado.setEstatus(rs.getInt("estatus"));
        }
        //cerrar la conexion
        conn.close();
        rs.close();
        stmt.close();
        
        return empleado;
    }
    
    public void guardarToken(Empleado empleado) throws SQLException{
    String query = "UPDATE usuario SET lastToken = ?, dateLastToken =NOW() WHERE idUsuario = ? ";
    System.out.println(query);
    
    ConexionMySQL conn = new ConexionMySQL();
    Connection connection = conn.open();
    
    PreparedStatement psmt = connection.prepareCall(query);
    
    
    psmt.setString(1, empleado.getUsuario().getLastToken());
    psmt.setInt(2, empleado.getUsuario().getIdUsuario());
    
    psmt.execute();
    
    psmt.close();
    conn.close();
    connection.close();
   
    }
    
    public boolean eliminarToken(Empleado e) throws SQLException {
    boolean r= false;
    String query = "Update usuario set lastToken = '' Where idUsuario = ?";
    
    ConexionMySQL connexion = new ConexionMySQL();
    Connection conn = connexion.open();
    
    PreparedStatement psmt = conn.prepareCall(query);
    
    psmt.setInt(1, e.getUsuario().getIdUsuario());
    
    psmt.execute();
    r=true;
    
    psmt.close();
    conn.close();
    connexion.close();
    
    return r;
    }
    
    public boolean validarToken(String t) throws SQLException{
    boolean r=false;
    String query= "Select * from usuario WHERE lastToken = '"+t+"'";
    ConexionMySQL coneccion = new ConexionMySQL();
    Connection conn = coneccion.open();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    if(rs.next()){
    r = true;
    }
    stmt.close();
    conn.close();
    coneccion.close();
    
    return r;
    }
    
}
