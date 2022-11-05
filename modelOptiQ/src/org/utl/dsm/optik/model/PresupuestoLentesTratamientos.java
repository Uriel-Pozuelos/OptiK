package org.utl.dsm.optik.model;

public class PresupuestoLentesTratamientos {
    private PresupuestoLentes presupuestoLentes;
    private Tratamiento tratamiento;

    public PresupuestoLentesTratamientos() {
    }

    public PresupuestoLentesTratamientos(PresupuestoLentes presupuestoLentes, Tratamiento tratamiento) {
        this.presupuestoLentes = presupuestoLentes;
        this.tratamiento = tratamiento;
    }

    public PresupuestoLentes getPresupuestoLentes() {
        return presupuestoLentes;
    }

    public void setPresupuestoLentes(PresupuestoLentes presupuestoLentes) {
        this.presupuestoLentes = presupuestoLentes;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "PresupuestoLentesTratamientos{" +
                "presupuestoLentes=" + presupuestoLentes.toString() +
                ", tratamiento=" + tratamiento.toString() +
                '}';
    }
}
