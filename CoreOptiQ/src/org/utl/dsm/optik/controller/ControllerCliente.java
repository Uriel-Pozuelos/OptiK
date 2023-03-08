
package org.utl.dsm.optik.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Cliente;
import org.utl.dsm.optik.model.Persona;

public class ControllerCliente {
    
    public int insertar(Cliente clientes) throws Exception{
        //Paso 1: Preparar la sentencia sql
        String query = "{call insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int idPersona = 0;
        int idCliente = 0;
        String numeroUnico = "";
        
        //Paso 2: Conectar a la BD
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);
        
        //Paso 4: Asignar los valores para cada parametro
        cstmt.setString(1, clientes.getPersona().getNombre());
        cstmt.setString(2, clientes.getPersona().getApellidoPaterno());
        cstmt.setString(3, clientes.getPersona().getApellidoMaterno());
        cstmt.setString(4, clientes.getPersona().getGenero());
        cstmt.setString(5, clientes.getPersona().getFechaNacimiento());
        cstmt.setString(6, clientes.getPersona().getCalle());
        cstmt.setString(7, clientes.getPersona().getNumero());
        cstmt.setString(8, clientes.getPersona().getColonia());
        cstmt.setString(9, clientes.getPersona().getCp());
        cstmt.setString(10, clientes.getPersona().getCiudad());
        cstmt.setString(11, clientes.getPersona().getEstado());
        cstmt.setString(12, clientes.getPersona().getTelCasa());
        cstmt.setString(13, clientes.getPersona().getTelMovil());
        cstmt.setString(14, clientes.getPersona().getEmail());
        
        //Paso 5: Registrar parametros de salida del procedure
        cstmt.registerOutParameter(15, Types.INTEGER);
        cstmt.registerOutParameter(16, Types.INTEGER);
        cstmt.registerOutParameter(17, Types.INTEGER);
        
        //Paso 6: Ejecutar la llamada al procedure
        cstmt.executeUpdate();
        
        // Paso 7 recuperar los parametros de salida 
        idPersona= cstmt.getInt(15);
        idCliente = cstmt.getInt(16);
        numeroUnico = cstmt.getString(17);
        
        // Paso 8 insertar los valores en el objeto 
        clientes.getPersona().setIdPersona(idPersona);
        clientes.setIdCliente(idCliente);
        clientes.setNumeroUnico(numeroUnico);
        
        // Paso 9 cerrar objetos de conexion 
        cstmt.close();
        conn.close();
        conexion.close();
        
        // Paso 10 devolver o return el id generado
        return idCliente;
    }
    
    public void actualizar(Cliente clientes) throws Exception{
        //Paso 1: Preparar la sentencia sql
        String query = "{call actualizarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        //Paso 2: Conectar a la BD
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);
        
        //Paso 4: Asignar los valores para cada parametro
        cstmt.setString(1, clientes.getPersona().getNombre());
        cstmt.setString(2, clientes.getPersona().getApellidoPaterno());
        cstmt.setString(3, clientes.getPersona().getApellidoMaterno());
        cstmt.setString(4, clientes.getPersona().getGenero());
        cstmt.setString(5, clientes.getPersona().getFechaNacimiento());
        cstmt.setString(6, clientes.getPersona().getCalle());
        cstmt.setString(7, clientes.getPersona().getNumero());
        cstmt.setString(8, clientes.getPersona().getColonia());
        cstmt.setString(9, clientes.getPersona().getCp());
        cstmt.setString(10, clientes.getPersona().getCiudad());
        cstmt.setString(11, clientes.getPersona().getEstado());
        cstmt.setString(12, clientes.getPersona().getTelCasa());
        cstmt.setString(13, clientes.getPersona().getTelMovil());
        cstmt.setString(14, clientes.getPersona().getEmail());
        
        cstmt.setInt(15, clientes.getPersona().getIdPersona());
        cstmt.setInt(16, clientes.getIdCliente());
        
        //Paso 5: Registrar parametros de salida del procedure
        
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
    
    public List<Cliente> getAll (String filtro) throws SQLException{
        
        String query="SELECT * FROM vista_clientes WHERE estatus="+filtro+"";
        System.out.println(query);
        ConexionMySQL objConexion= new ConexionMySQL();
        Connection conn=objConexion.open();
        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Cliente> clientes = new ArrayList<>();
        ResultSet rs= pstmt.executeQuery();
        while(rs.next()){
            Cliente c = new Cliente();
            Persona p = new Persona();
            p.setNombre(rs.getString("nombre"));
            p.setIdPersona(rs.getInt("idPersona"));
            p.setApellidoPaterno(rs.getString("apellidoPaterno"));
            p.setApellidoMaterno(rs.getString("apellidoMaterno"));
            p.setGenero(rs.getString("genero"));
            p.setFechaNacimiento(rs.getString("fechaNacimiento"));
            p.setCalle(rs.getString("calle"));
            p.setNumero(rs.getString("numero"));
            p.setColonia(rs.getString("colonia"));
            p.setCp(rs.getString("cp"));
            p.setCiudad(rs.getString("ciudad"));
            p.setEstado(rs.getString("estado"));
            p.setTelCasa(rs.getString("telcasa"));
            p.setTelMovil(rs.getString("telmovil"));
            p.setEmail(rs.getString("email"));
            c.setPersona(p);
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNumeroUnico(rs.getString("numeroUnico"));
            c.setEstatus(rs.getInt("estatus"));
            clientes.add(c);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return clientes;
    }
    
    public String actualizarClientes(Cliente clientes) throws SQLException{
        String query = "{call actualizarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL objConection = new ConexionMySQL();
        Connection conn = objConection.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setString(1, clientes.getPersona().getNombre());
        cstmt.setString(2, clientes.getPersona().getApellidoPaterno());
        cstmt.setString(3, clientes.getPersona().getApellidoMaterno());
        cstmt.setString(4, clientes.getPersona().getGenero());
        cstmt.setString(5, clientes.getPersona().getFechaNacimiento());
        cstmt.setString(6, clientes.getPersona().getCalle());
        cstmt.setString(7, clientes.getPersona().getNumero());
        cstmt.setString(8, clientes.getPersona().getColonia());
        cstmt.setString(9, clientes.getPersona().getCp());
        cstmt.setString(10, clientes.getPersona().getCiudad());
        cstmt.setString(11, clientes.getPersona().getEstado());
        cstmt.setString(12, clientes.getPersona().getTelCasa());
        cstmt.setString(13, clientes.getPersona().getTelMovil());
        cstmt.setString(14, clientes.getPersona().getEmail());
        cstmt.setInt(15, clientes.getPersona().getIdPersona());
        cstmt.setInt(16, clientes.getIdCliente());
        
        cstmt.execute();
        objConection.close();
        conn.close();
        cstmt.close();
        return "Se actualizo correctamente";
    }
    
    public String actualizarEstatusCliente(int idCliente, int estatus) throws SQLException{
        String query = "{call actulizarEstatusCliente(?,?)}";
        ConexionMySQL objConection = new ConexionMySQL();
        Connection conn = objConection.open();
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setInt(1,estatus);
        cstmt.setInt(2,idCliente);
        cstmt.execute();
        objConection.close();
        conn.close();
        cstmt.close();
        return "Se actualizo estatus";
    }
    
}
