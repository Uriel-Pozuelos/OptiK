package org.utl.dsm.optik.model;

public class PresupuestoLentes {
    private int idPresupuestoLentes;
    private Presupuesto presupuesto;
    private int alturaOblea;
    private Tipo_mica tipoMica;
    private Material material;
    private Armazon armazon;

    public PresupuestoLentes() {
    }

    public PresupuestoLentes(Presupuesto presupuesto, int alturaOblea, Tipo_mica tipoMica, Material material, Armazon armazon) {
        this.presupuesto = presupuesto;
        this.alturaOblea = alturaOblea;
        this.tipoMica = tipoMica;
        this.material = material;
        this.armazon = armazon;
    }

    public PresupuestoLentes(int idPresupuestoLentes, Presupuesto presupuesto, int alturaOblea, Tipo_mica tipoMica, Material material, Armazon armazon) {
        this.idPresupuestoLentes = idPresupuestoLentes;
        this.presupuesto = presupuesto;
        this.alturaOblea = alturaOblea;
        this.tipoMica = tipoMica;
        this.material = material;
        this.armazon = armazon;
    }

    public int getIdPresupuestoLentes() {
        return idPresupuestoLentes;
    }

    public void setIdPresupuestoLentes(int idPresupuestoLentes) {
        this.idPresupuestoLentes = idPresupuestoLentes;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getAlturaOblea() {
        return alturaOblea;
    }

    public void setAlturaOblea(int alturaOblea) {
        this.alturaOblea = alturaOblea;
    }

    public Tipo_mica getTipoMica() {
        return tipoMica;
    }

    public void setTipoMica(Tipo_mica tipoMica) {
        this.tipoMica = tipoMica;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Armazon getArmazon() {
        return armazon;
    }

    public void setArmazon(Armazon armazon) {
        this.armazon = armazon;
    }

    @Override
    public String toString() {
        return "PresupuestoLentes{" +
                "idPresupuestoLentes=" + idPresupuestoLentes +
                ", presupuesto=" + presupuesto.toString() +
                ", alturaOblea=" + alturaOblea +
                ", tipoMica=" + tipoMica.toString() +
                ", material=" + material.toString() +
                ", armazon=" + armazon.toString() +
                '}';
    }
}
