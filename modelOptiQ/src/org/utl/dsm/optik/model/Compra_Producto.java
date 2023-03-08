package org.utl.dsm.optik.model;

public class Compra_Producto {
    private Compra compra;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public Compra_Producto() {
    }

    public Compra_Producto(Compra compra, Producto producto, int cantidad, double precioUnitario) {
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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

    @Override
    public String toString() {
        return "compraProducto{" +
                "compra=" + compra.toString() +
                ", producto=" + producto.toString() +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
