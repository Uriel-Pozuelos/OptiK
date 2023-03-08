package org.utl.dsm.optik.model;

public class PresupuestoLentesContacto {
    private int idPresupuestoLentesContacto;
    private Examen_Vista examenVista;
    private LenteContacto lenteContacto;
    private String clave;

    public PresupuestoLentesContacto() {
    }

    public PresupuestoLentesContacto(Examen_Vista examenVista, LenteContacto lenteContacto, String clave) {
        this.examenVista = examenVista;
        this.lenteContacto = lenteContacto;
        this.clave = clave;
    }

    public PresupuestoLentesContacto(int idPresupuestoLentesContacto, Examen_Vista examenVista, LenteContacto lenteContacto, String clave) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
        this.examenVista = examenVista;
        this.lenteContacto = lenteContacto;
        this.clave = clave;
    }

    public int getIdPresupuestoLentesContacto() {
        return idPresupuestoLentesContacto;
    }

    public void setIdPresupuestoLentesContacto(int idPresupuestoLentesContacto) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
    }

    public Examen_Vista getExamenVista() {
        return examenVista;
    }

    public void setExamenVista(Examen_Vista examenVista) {
        this.examenVista = examenVista;
    }

    public LenteContacto getLenteContacto() {
        return lenteContacto;
    }

    public void setLenteContacto(LenteContacto lenteContacto) {
        this.lenteContacto = lenteContacto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "PresupuestoLentesContacto{" +
                "idPresupuestoLentesContacto=" + idPresupuestoLentesContacto +
                ", examenVista=" + examenVista.toString() +
                ", lenteContacto=" + lenteContacto.toString() +
                ", clave='" + clave + '\'' +
                '}';
    }
}
