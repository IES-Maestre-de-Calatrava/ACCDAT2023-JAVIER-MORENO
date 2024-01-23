package com.mycompany.objectdbproyecto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
@Entity
public class Paises implements Serializable
{
    
 private static final long serialVersionUID=1L;

    // atributos
 
 
 
    @Id
    private int id;
    private String nombrepais;

    // significa es el id de esta clase , tiene que estar antes que se referencia a otra tabla
    @OneToMany(mappedBy ="idpais", orphanRemoval=true)
    private List<Jugadores>jugadorespais;

    public Paises(int id, String nombrepais, List<Jugadores> jugadorespais) {
        this.id = id;
        this.nombrepais = nombrepais;
        this.jugadorespais = jugadorespais;
    }

    public Paises(int id, String nombrepais) {
        this.id = id;
        this.nombrepais = nombrepais;
    }
    
    public Paises(String nombrepais, int id ) {
        this.nombrepais = nombrepais;
        this.id = id;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public List<Jugadores> getJugadorespais() {
        return jugadorespais;
    }

    public void setJugadorespais(List<Jugadores> jugadorespais) {
        this.jugadorespais = jugadorespais;
    }
    
    

    @Override
    public String toString() {
        return "Paises{" + "id=" + id + '}';
    }
    
    
    
}
