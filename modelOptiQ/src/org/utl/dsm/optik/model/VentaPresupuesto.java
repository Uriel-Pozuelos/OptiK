package org.utl.dsm.optik.model;

import java.util.List;

public class VentaPresupuesto {

    private Venta venta;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private List<PresupuestoLentes> ventaPresupuesto;
    private PresupuestoLentes presupuestoLentes;

    public VentaPresupuesto() {
    }

    public VentaPresupuesto(Venta venta, int cantidad, double precioUnitario, double descuento, List<PresupuestoLentes> ventaPresupuesto, PresupuestoLentes presupuestoLentes) {
        this.venta = venta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.ventaPresupuesto = ventaPresupuesto;
        this.presupuestoLentes = presupuestoLentes;
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

    public PresupuestoLentes getPresupuestoLentes() {
        return presupuestoLentes;
    }

    public void setPresupuestoLentes(PresupuestoLentes presupuestoLentes) {
        this.presupuestoLentes = presupuestoLentes;
    }


    @Override
    public String toString() {
        return "VentaPresupuesto{" +
                "venta=" + venta +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", descuento=" + descuento +
                ", ventaPresupuesto=" + ventaPresupuesto +
                ", presupuestoLentes=" + presupuestoLentes +
                '}';
    }
}
