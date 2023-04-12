/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;

/**
 *
 * @author urieh
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ControllerGetAllVentas con = new ControllerGetAllVentas();
        
        var x = con.getAllVentaLente();
        x.forEach((a)->{
            System.out.println(a.toString());
        });
    }
    
}
