/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

import java.util.List;

public class DetalleVentaPre {
    private Venta venta;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private List<VentaPresupuestoLC> ventaPresupuestosLC;

    public DetalleVentaPre() {
    }

    public DetalleVentaPre(Venta venta, int cantidad, double precioUnitario, double descuento, List<VentaPresupuestoLC> ventaPresupuestosLC) {
        this.venta = venta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.ventaPresupuestosLC = ventaPresupuestosLC;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public List<VentaPresupuestoLC> getVentaPresupuestosLC() {
        return ventaPresupuestosLC;
    }

    public void setVentaPresupuestosLC(List<VentaPresupuestoLC> ventaPresupuestosLC) {
        this.ventaPresupuestosLC = ventaPresupuestosLC;
    }

    @Override
    public String toString() {
        return "DetalleVentaPre{" + "venta=" + venta + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + ", ventaPresupuestosLC=" + ventaPresupuestosLC + '}';
    }

   
    
    
    
}
