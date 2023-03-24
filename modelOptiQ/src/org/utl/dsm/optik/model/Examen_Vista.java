package org.utl.dsm.optik.model;


public class Examen_Vista {
    private int idExamenVista;
    private String clave;
    private int estatus;
    private Empleado empleado;
    private Cliente cliente;
    private GraduacionLentes graduacion;
    private String fecha;

    public Examen_Vista() {
    }

    public Examen_Vista(String clave, int estatus, Empleado empleado, Cliente cliente, GraduacionLentes graduacion, String fecha) {
        this.clave = clave;
        this.estatus = estatus;
        this.empleado = empleado;
        this.cliente = cliente;
        this.graduacion = graduacion;
        this.fecha = fecha;
    }

    public Examen_Vista(int idExamenVista, String clave, int estatus, Empleado empleado, Cliente cliente, GraduacionLentes graduacion, String fecha) {
        this.idExamenVista = idExamenVista;
        this.clave = clave;
        this.estatus = estatus;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GraduacionLentes getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(GraduacionLentes graduacion) {
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
        return "Examen_Vista{" + "idExamenVista=" + idExamenVista + ", clave=" + clave + ", estatus=" + estatus + ", empleado=" + empleado.toString() + ", cliente=" + cliente.toString() + ", graduacion=" + graduacion.toString() + ", fecha=" + fecha + '}';
    
    }

 
}
