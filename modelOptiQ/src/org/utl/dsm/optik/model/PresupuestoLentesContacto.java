package org.utl.dsm.optik.model;

public class PresupuestoLentesContacto {
    private int idPresupuestoLentesContacto;
 
    private LenteContacto lenteContacto;
    private Presupuesto presupuesto;
    private String clave;

    public PresupuestoLentesContacto() {
    }

    public PresupuestoLentesContacto( LenteContacto lenteContacto, String clave, Presupuesto presupuesto) {
       
        this.lenteContacto = lenteContacto;
        this.clave = clave;
        this.presupuesto = presupuesto;
    }

    public PresupuestoLentesContacto(int idPresupuestoLentesContacto, LenteContacto lenteContacto, String clave, Presupuesto presupuesto) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
      
        this.lenteContacto = lenteContacto;
        this.clave = clave;
        this.presupuesto = presupuesto;
    }

    public int getIdPresupuestoLentesContacto() {
        return idPresupuestoLentesContacto;
    }

    public void setIdPresupuestoLentesContacto(int idPresupuestoLentesContacto) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
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

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }
    

    @Override
    public String toString() {
        return "PresupuestoLentesContacto{" +
                "idPresupuestoLentesContacto=" + idPresupuestoLentesContacto +
              
                ", lenteContacto=" + lenteContacto.toString() +
                ", clave='" + clave + '\'' +
                '}';
    }
}
