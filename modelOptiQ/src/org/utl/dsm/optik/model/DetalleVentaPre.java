/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

import java.util.List;

public class DetalleVentaPre {
    private Venta venta;
    private List<VentaPresupuestoLC> ventaPresupuestosLC;

    public DetalleVentaPre() {
    }

    public DetalleVentaPre(Venta venta, List<VentaPresupuestoLC> ventaPresupuestosLC) {
        this.venta = venta;
        this.ventaPresupuestosLC = ventaPresupuestosLC;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<VentaPresupuestoLC> getVentaPresupuestosLC() {
        return ventaPresupuestosLC;
    }

    public void setVentaPresupuestosLC(List<VentaPresupuestoLC> ventaPresupuestosLC) {
        this.ventaPresupuestosLC = ventaPresupuestosLC;
    }   
}
