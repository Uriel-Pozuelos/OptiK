
package org.utl.dsm.optik.model;

import java.util.List;

/**
 *
 * @author urieh
 */
public class DetalleVentaPresupuestoLentes {
    private Venta venta;
    private List<VentaPresupuesto> ventaPresupuesto;

    public DetalleVentaPresupuestoLentes(Venta venta, List<VentaPresupuesto> ventaPresupuesto) {
        this.venta = venta;
        this.ventaPresupuesto = ventaPresupuesto;
    }

    

    public DetalleVentaPresupuestoLentes() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<VentaPresupuesto> getVentaPresupuesto() {
        return ventaPresupuesto;
    }

    public void setVentaPresupuesto(List<VentaPresupuesto> ventaPresupuesto) {
        this.ventaPresupuesto = ventaPresupuesto;
    }

    @Override
    public String toString() {
        return "DetalleVentaPresupuestoLentes{" + "venta=" + venta + ", ventaPresupuesto=" + ventaPresupuesto + '}';
    }
}
