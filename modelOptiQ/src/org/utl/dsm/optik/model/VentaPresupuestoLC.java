/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author urieh
 */
public class VentaPresupuestoLC {

    private PresupuestoLentesContacto presupuestoLC;
    private int cantidad;
    private double precioUnitario;
    private double descuento;

    public VentaPresupuestoLC( PresupuestoLentesContacto presupuestoLC, int cantidad, double precioUnitario, double descuento) {
        
        this.presupuestoLC = presupuestoLC;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public VentaPresupuestoLC() {
    }


    public PresupuestoLentesContacto getPresupuestoLC() {
        return presupuestoLC;
    }

    public void setPresupuestoLC(PresupuestoLentesContacto presupuestoLC) {
        this.presupuestoLC = presupuestoLC;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "VentaPresupuestoLC{" + ", presupuestoLC=" + presupuestoLC + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + '}';
    }
    
    
    
}
