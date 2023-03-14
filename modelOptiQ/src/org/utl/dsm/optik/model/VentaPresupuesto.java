package org.utl.dsm.optik.model;

import java.util.List;

public class VentaPresupuesto {

    private Venta venta;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private List<PresupuestoLentes> ventaPresupuesto;

    public VentaPresupuesto() {
    }

    public VentaPresupuesto(Venta venta, int cantidad, double precioUnitario, double descuento, List<PresupuestoLentes> ventaPresupuesto) {
        this.venta = venta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.ventaPresupuesto = ventaPresupuesto;
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

    public List<PresupuestoLentes> getVentaPresupuesto() {
        return ventaPresupuesto;
    }

    public void setVentaPresupuesto(List<PresupuestoLentes> ventaPresupuesto) {
        this.ventaPresupuesto = ventaPresupuesto;
    }

  
    
    

   
}
