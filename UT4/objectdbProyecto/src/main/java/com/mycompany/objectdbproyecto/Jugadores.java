/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproyecto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author usuario
 */
@Entity
public class Jugadores implements Serializable
{
    
    private String idjugador;
    private String nombre;
    private String deporte;
    private String ciudad;
    private String edad;
    private int dorsal;
    private Paises equipo;
    
    @JoinColumn(name="idpais", referencedColumnName="idpais")
    @ManyToOne
    private Paises pais;

 
    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador) {
        this.idjugador = idjugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

  

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Jugadores(String nombre, String deporte, String ciudad, int dorsal, Paises equipo) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }
    
    
    
    
    
 }


