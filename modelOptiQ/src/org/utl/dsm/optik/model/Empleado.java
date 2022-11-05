
package org.utl.dsm.optik.model;

/**
 *
 * @author urieh
 */
public class Empleado {
    private int IdEmpleado;
    private String numeroUnico;
    private int estatus;
    private Persona persona; 
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(String numeroUnico, int estatus, Persona persona, Usuario usuario) {
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.persona = persona;
        this.usuario = usuario;
    }

    public Empleado(int IdEmpleado, String numeroUnico, int estatus, Persona persona, Usuario usuario) {
        this.IdEmpleado = IdEmpleado;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.persona = persona;
        this.usuario = usuario;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "IdEmpleado=" + IdEmpleado + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + ", persona=" + persona.toString() + ", usuario=" + usuario.toString() + '}';
    }
    
    
    
}
