/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author urieh
 */
public class Cliente {
    private int idCliente;
    private int idPersona;
    private String numeroUnico;
    private int estatus;

    public Cliente() {
    }

    public Cliente(int idPersona, String numeroUnico, int estatus) {
        this.idPersona = idPersona;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
    }

    public Cliente(int idCliente, int idPersona, String numeroUnico, int estatus) {
        this.idCliente = idCliente;
        this.idPersona = idPersona;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idPersona=" + idPersona + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + '}';
    }
    
    
    
}
