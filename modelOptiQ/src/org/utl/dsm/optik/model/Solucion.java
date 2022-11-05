package org.utl.dsm.optik.model;

public class Solucion {
    private int idSolucion;
    private Producto producto;

    public Solucion() {
    }
    //constructor para insertar todos los datos menos el id
    public Solucion(Producto producto) {
        this.producto = producto;
    }

    public Solucion(int idSolucion, Producto producto) {
        this.idSolucion = idSolucion;
        this.producto = producto;
    }

    public int getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Solucion{" +
                "idSolucion=" + idSolucion +
                ", producto=" + producto.toString() +
                '}';
    }
}
