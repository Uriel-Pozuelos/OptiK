/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;
import org.utl.dsm.optik.model.Usuario;
import org.utl.dsm.optik.model.Empleado;
/**
 *
 * @author urieh
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Usuario u = new Usuario();
        Empleado e;
        ControllerAcceso ca = new ControllerAcceso();
        try{
        u.setNombre("Ivana");
        u.setContrasenia("f484303f4be56dc39e37bfe4ac905912176980bc8dd64ea8c777b4f29179ed34");
        e = ca.accerder(u);
        e.getUsuario().setLastToken();
        System.out.println(e.toString());
        ca.guardarToken(e);
        System.out.println(e.toString());
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("no");
        }
    }
    
}
