package org.utl.dsm.optik.model;

public class ExamenVista {
    private int idExamenVista;
    private Empleado empleado;
    private Cliente cliente;
    private Graduacion graduacion;
    private String fecha;

    public ExamenVista() {
    }
    //constructor para insertar todos los datos menos el id
    public ExamenVista(Empleado empleado, Cliente cliente, Graduacion graduacion, String fecha) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.graduacion = graduacion;
        this.fecha = fecha;
    }

    public ExamenVista(int idExamenVista, Empleado empleado, Cliente cliente, Graduacion graduacion, String fecha) {
        this.idExamenVista = idExamenVista;
        this.empleado = empleado;
        this.cliente = cliente;
        this.graduacion = graduacion;
        this.fecha = fecha;
    }

    public int getIdExamenVista() {
        return idExamenVista;
    }

    public void setIdExamenVista(int idExamenVista) {
        this.idExamenVista = idExamenVista;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Graduacion getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(Graduacion graduacion) {
        this.graduacion = graduacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ExamenVista{" +
                "idExamenVista=" + idExamenVista +
                ", empleado=" + empleado.toString() +
                ", cliente=" + cliente.toString() +
                ", graduacion=" + graduacion.toString() +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
