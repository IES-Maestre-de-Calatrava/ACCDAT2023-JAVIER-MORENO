/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author b15-20m
 */
@Entity
class Paises implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int idequipo;
    private String nombrepais;
    @OneToMany (mappedBy="idequipo", orphanRemoval = true)
    private List<Jugadores> jugadoresCollection;

    public Paises() {
    }

    public Paises(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public List<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(List<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
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
        final Paises other = (Paises) obj;
        if (this.idequipo != other.idequipo) {
            return false;
        }
        if (!Objects.equals(this.nombrepais, other.nombrepais)) {
            return false;
        }
        return Objects.equals(this.jugadoresCollection, other.jugadoresCollection);
    }

    @Override
    public String toString() {
        return "Equipos{" + "nombrepais=" + nombrepais + '}';
    }
    
    
    
}
