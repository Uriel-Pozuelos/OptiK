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
    private Persona persona;
    private String numeroUnico;
    private int estatus;

    public Cliente() {
    }

    public Cliente(Persona persona, String numeroUnico, int estatus) {
        this.persona = persona;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
    }

    public Cliente(int idCliente, Persona persona, String numeroUnico, int estatus) {
        this.idCliente = idCliente;
        this.persona = persona;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        return "Cliente{" + "idCliente=" + idCliente + ", persona=" + persona + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + '}';
    }
    
    

    
    
    
}
