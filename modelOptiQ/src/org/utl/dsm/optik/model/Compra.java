package org.utl.dsm.optik.model;

public class Compra {
    private int idCompra;
    private int estatus;
    private Empleado empleado;
    

    public Compra() {
    }

    public Compra(int estatus, Empleado empleado) {
        this.estatus = estatus;
        this.empleado = empleado;
    }

    public Compra(int idCompra,int estatus, Empleado empleado) {
        this.idCompra = idCompra;
        this.estatus = estatus;
        this.empleado = empleado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", estatus=" + estatus + ", empleado=" + empleado.toString() + '}';
    }
    
}

