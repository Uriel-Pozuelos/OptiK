
package org.utl.dsm.optik.model;

import java.util.List;
import java.util.stream.Collectors;

public class DetalleVentaProducto {
    private Venta venta;
    private List<VentaProducto> ventasProducto;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(Venta venta, List<VentaProducto> ventasProducto) {
        this.venta = venta;
        this.ventasProducto = ventasProducto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<VentaProducto> getVentasProducto() {
        return ventasProducto;
    }

    public void setVentasProducto(List<VentaProducto> ventasProducto) {
        this.ventasProducto = ventasProducto;
    }

    @Override
    public String toString() {
        return "DetalleVentaProducto{" + "venta=" + venta + ", ventasProducto=" + ventasProducto + '}';
    }

      
}
