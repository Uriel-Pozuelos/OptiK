package org.utl.dsm.optik.model;
public class Presupuesto {
    private int idPresupuesto;
    private Examen_Vista examenVista;
    private String clave;

    public Presupuesto() {
    }

    public Presupuesto(Examen_Vista examenVista, String clave) {
        this.examenVista = examenVista;
        this.clave = clave;
    }

    public Presupuesto(int idPresupuesto, Examen_Vista examenVista, String clave) {
        this.idPresupuesto = idPresupuesto;
        this.examenVista = examenVista;
        this.clave = clave;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Examen_Vista getExamenVista() {
        return examenVista;
    }

    public void setExamenVista(Examen_Vista examenVista) {
        this.examenVista = examenVista;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "idPresupuesto=" + idPresupuesto +
                ", examenVista=" + examenVista.toString() +
                ", clave='" + clave + '\'' +
                '}';
    }
}
