
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.utl.dsm.optik.model.DetalleVentaPre;
import org.utl.dsm.optik.model.DetalleVentaPresupuestoLentes;



/**
 *
 * @author urieh
 */
public class ControllerVentaLente {
    
    public boolean generarVentaLC(DetalleVentaPre dvp) {
        
        boolean r = false;
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        Statement stmnt = null;
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            stmnt = conn.createStatement();
            // Se inserta la venta
            String query1 = "INSERT INTO venta(idEmpleado, clave)  VALUES"
                    + "(" + dvp.getVenta().getEmpleado().getIdEmpleado()
                    + ',' + "'"+dvp.getVenta().getClave() +"'"+ ")";
            System.out.println(query1);
            stmnt.execute(query1);
            // Se obtiene el id de la venta que se ha insertado
            String query2 = "SELECT LAST_INSERT_ID()";
            rs = stmnt.executeQuery(query2);
            if (rs.next()) {
                dvp.getVenta().setIdVenta(rs.getInt(1));
            }

            for (int i = 0; i < dvp.getVentaPresupuestosLC().size(); i++) {
                //Se inserta el presupuesto
                String query3 = "INSERT INTO presupuesto"
                        + "(clave,idExamenVista)"
                         + "VALUES (" +"'"+ dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getPresupuesto().getClave() +"'"+"," 
                        + "" + dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getPresupuesto().getExamenVista().getIdExamenVista() + " )";
                System.out.println(query3);
                stmnt.execute(query3);
                //Se obtiene el id del presupuesto generado
                rs = stmnt.executeQuery(query2);
                if (rs.next()) {
                    dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getPresupuesto().setIdPresupuesto(rs.getInt(1));
                }

                //Se inserta en presupuesto_lentescontacto                
                String query4 = "INSERT INTO presupuesto_lentescontacto"
                        + "( idLenteContacto, clave,idExamenVista)"
                        + "VALUES (" +dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getLenteContacto().getIdLenteContacto()+ ","
                        + "'" +dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getClave()+ "'" 
                        + "," + dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getPresupuesto().getExamenVista().getIdExamenVista()+ ")";
                System.out.println(query4);
                stmnt.execute(query4);
                //Se obtiene el id del presupuesto_lentescontacto generado
                rs = stmnt.executeQuery(query2);
                if (rs.next()) {
                    dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().setIdPresupuestoLentesContacto(rs.getInt(1));
                }

                //Se insera en venta_presupuesto la relación entre la venta y el presupuesto
                String query5 = "INSERT INTO venta_presupuesto "
                        + "(idVenta, idPresupuesto, cantidad, precioUnitario, descuento) "
                        + "VALUES ("
                        + dvp.getVenta().getIdVenta() + ","
                        + dvp.getVentaPresupuestosLC().get(i).getPresupuestoLC().getPresupuesto().getIdPresupuesto() + ","
                        + dvp.getVentaPresupuestosLC().get(i).getCantidad() + ","
                        + dvp.getVentaPresupuestosLC().get(i).getPrecioUnitario() + ","
                        + dvp.getVentaPresupuestosLC().get(i).getDescuento()+ ")";
                System.out.println(query5);
                stmnt.execute(query5);
                
            }
            conn.commit();
            conn.setAutoCommit(true);
            stmnt.close();
            conn.close();
            r = true;

        } catch (SQLException ex) { 
                   try {

                conn.rollback();
                conn.setAutoCommit(true);
                conn.close();
                r = false;
            } catch (SQLException ex1) {
                r = false;
            }
        }
        r=true;

        return r;
    }
    
    
    public boolean generarVentaLentes(DetalleVentaPresupuestoLentes dvp) {
        boolean r = false;

        //Creamos un objeto conexión con MySQL
        ConexionMySQL connMySQL = new ConexionMySQL();
        //objeto de tipo Connection que abre la conexión
        Connection conn = connMySQL.open();
        //objeto de Statement
        Statement stmt = null;
        //objeto de ResultSet
        ResultSet rs = null;
        /*NOTA: Los objetos quedan afuera del try catch, para poder utilizarlos en todo el método
         */
        try {
            //el autocommit se prepara para no ejecutar en automatico las sentencias
            //sino esperar a que termine la transaccion 
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            //esta query se utiliza varias veces
            String query = "SELECT LAST_INSERT_ID()";

            //Se genera la venta
            String query0 = "INSERT INTO venta(idEmpleado, clave) VALUES ("
                    + dvp.getVenta().getEmpleado().getIdEmpleado() + ","
                    + dvp.getVenta().getClave() + ");";
            stmt.execute(query0);
            //Se obtiene el id genrado con la insercion de venta
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                dvp.getVenta().setIdVenta(rs.getInt(1));
            }

            //Se insertan varios presupuestos, por lo tanto se Cicla
            for (int i = 0; i < dvp.getVentaPresupuesto().size(); i++) {

                //Se insertan los presupuestos
                String query1 = "INSERT INTO presupuesto(idExamenVista, clave)"
                        + "VALUES (" + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getPresupuesto().getExamenVista().getIdExamenVista() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getPresupuesto().getClave()+ ");";
                stmt.execute(query1);
                rs = stmt.executeQuery(query);
                //Obtenemos el id de presupuesto y lo guardamos
                if (rs.next()) {
                    dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getPresupuesto().setIdPresupuesto(rs.getInt(1));
                }

                //Se insertan los presupuestos de lentes
                String query2 = "INSERT INTO presupuesto_Lentes(idPresupuesto, alturaOblea, idTipoMica, idMaterial, idArmazon)"
                        + "VALUES (" + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getPresupuesto().getIdPresupuesto() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getAlturaOblea() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getTipoMica().getIdTipoMica() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getMaterial().getIdMaterial() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getArmazon().getIdArmazon() + ");";
                stmt.execute(query2);
                //Obtenermos el id de presupuesto_Lentes  y se guarda en su objeto
                rs = stmt.executeQuery(query);                
                if (rs.next()) {
                    dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().setIdPresupuestoLentes(rs.getInt(1));
                }
                
                //Se almacenana los tratamientos que tiene ese lente presupuestado
                //Va en un ciclo por que se tiene la posibilidad de elegir varios tratamientos
                for (int j = 0; j < dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getListaTratamiento().size(); j++) {
                    String query3 = "INSERT INTO presupuesto_lentes_tratamientos VALUES("
                            + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getIdPresupuestoLentes() + ","
                            + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getListaTratamiento().get(j).getIdTratamiento()+ ");";
                    stmt.execute(query3);
                    
                }
                //Query numero 4 para almacenar la relacion de venta_presupuesto
                String query4 = "INSERT INTO venta_presupuesto VALUES("
                        + dvp.getVenta().getIdVenta() + ","
                        + dvp.getVentaPresupuesto().get(i).getPresupuestoLentes().getPresupuesto().getIdPresupuesto() + ","
                        + dvp.getVentaPresupuesto().get(i).getCantidad() + ","
                        + dvp.getVentaPresupuesto().get(i).getPrecioUnitario() + ","
                        + dvp.getVentaPresupuesto().get(i).getDescuento() + ");";
                stmt.execute(query4);
            }
            
            //Ya con todas las sentencias ejecutadas, se envia la conformación de ejecutar la transaccion
            conn.commit();
            //Se cierran los objetos de BD
            conn.setAutoCommit(true);
            rs.close();
            stmt.close();
            r = true;

        } catch (SQLException ex) {
            try {
                //En caso de error se indica un rollback a la transaccion. 
                conn.rollback();
                conn.setAutoCommit(true);
                r = false;

            } catch (SQLException ex1) {
                r = false;
            }
        }
        return r;
    }
    
}
