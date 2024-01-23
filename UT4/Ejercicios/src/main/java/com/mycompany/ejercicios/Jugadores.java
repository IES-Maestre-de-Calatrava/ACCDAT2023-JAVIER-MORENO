/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author b15-20m
 */
@Entity
public class Jugadores implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int idjugador;
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;
    @JoinColumn (name = "idequipo", referencedColumnName="idequipo")
    @ManyToOne
    private Paises idequipo;

    public Jugadores() {
    }
    
    public Jugadores(String nombre, String deporte, String ciudad, int edad, Paises equipo) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.edad = edad;
        this.idequipo = equipo;
    }

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Paises getEquipo() {
        return idequipo;
    }

    public void setEquipo(Paises equipo) {
        this.idequipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugadores other = (Jugadores) obj;
        if (this.idjugador != other.idjugador) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.deporte, other.deporte)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        return Objects.equals(this.idequipo, other.idequipo);
    }

    @Override
    public String toString() {
        return "{idjugador=" + idjugador + ", nombre=" + nombre + ", deporte=" + deporte + ", ciudad=" + ciudad + ", edad=" + edad + ", equipo=" + idequipo + '}';
    }
    
    
}
