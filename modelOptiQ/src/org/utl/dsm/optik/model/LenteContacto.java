package org.utl.dsm.optik.model;

public class LenteContacto {
    private int idLenteContacto;
    private Producto producto;
    private String keratometria;
    private String fotografia;

    public LenteContacto() {
    }
    //constructor para insertar todos los datos menos el id

    public LenteContacto(Producto producto, String keratometria, String fotografia) {
        this.producto = producto;
        this.keratometria = keratometria;
        this.fotografia = fotografia;
    }

    public LenteContacto(int idLenteContacto, Producto producto, String keratometria, String fotografia) {
        this.idLenteContacto = idLenteContacto;
        this.producto = producto;
        this.keratometria = keratometria;
        this.fotografia = fotografia;
    }

    public int getIdLenteContacto() {
        return idLenteContacto;
    }

    public void setIdLenteContacto(int idLenteContacto) {
        this.idLenteContacto = idLenteContacto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getKeratometria() {
        return keratometria;
    }

    public void setKeratometria(String keratometria) {
        this.keratometria = keratometria;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public String toString() {
        return "LenteContacto{" +
                "idLenteContacto=" + idLenteContacto +
                ", producto=" + producto.toString() +
                ", keratometria='" + keratometria + '\'' +
                ", fotografia='" + fotografia + '\'' +
                '}';
    }
}
