package org.utl.dsm.optik.model;

public class VentaProducto {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double descuento;

    public VentaProducto() {
    }

    public VentaProducto( Producto producto, int cantidad, double precioUnitario, double descuento) {

        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        return "VentaProducto{" +
                ", producto=" + producto.toString() +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", descuento=" + descuento +
                '}';
    }
}
