package org.utl.dsm.optik.model;

public class Accesorio {
    private int idAccesorio;
    private Producto producto;

    public Accesorio() {
    }
    //constructor para insertar todos los datos menos el id
    public Accesorio(Producto producto) {
        this.producto = producto;
    }

    public Accesorio(int idAccesorio, Producto producto) {
        this.idAccesorio = idAccesorio;
        this.producto = producto;
    }

    public int getIdAccesorio() {
        return idAccesorio;
    }

    public void setIdAccesorio(int idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Accesorio{" +
                "idAccesorio=" + idAccesorio +
                ", producto=" + producto.toString() +
                '}';
    }
}
