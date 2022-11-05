package org.utl.dsm.optik.model;

public class Compra {
    private int idCompra;
    private Empleado empleado;

    public Compra() {
    }

    public Compra(Empleado empleado) {
        this.empleado = empleado;
    }

    public Compra(int idCompra, Empleado empleado) {
        this.idCompra = idCompra;
        this.empleado = empleado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", empleado=" + empleado.toString() +
                '}';
    }
}

