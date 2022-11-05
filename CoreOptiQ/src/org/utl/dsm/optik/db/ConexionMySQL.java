
package org.utl.dsm.optik.db;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author urieh
 */
public class ConexionMySQL {
    
    Connection conn;
    
    public Connection open(){
     String usuario = "root";
     String password = "root";
     String url ="jdbc:mysql://127.0.0.1:3306/optiqalumnos?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, usuario, password);
    return conn;
    }catch (Exception e) {
            throw new Error("error al conectar bd con user "+usuario);
    } 
    } 
    
    public void close(){
    try{
    conn.close();
    } catch(Exception e){
        throw new Error("problema al cerrar la base de datos");
    }
    
    
    }

    @Override
    public String toString() {
        return "ConexionMySQL{" + "conn=" + conn + '}';
    }
    
}
