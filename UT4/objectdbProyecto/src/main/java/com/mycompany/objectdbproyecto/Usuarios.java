/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproyecto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author b15-04m
 */

@Entity
@NamedQueries({
    @NamedQuery(name="USUARIOS.findAll", query="SELECT FROM Usuarios"),
    @NamedQuery(name="USUARIOS.findById", query="SELECT FROM Usuarios where idusuario=:IDUSUARIOP")
})
public class Usuarios implements Serializable {
    private static final long serialVersionUID= 1L;
    
    @Id @GeneratedValue
    private int idusuario;
    
    private String nombre;
    private String contra;
    
    
    @OneToMany(mappedBy="idusuario",orphanRemoval=true)
    private List<Pedidos> pedidosCollection;
    
    public Usuarios() {
    }
        public Usuarios(int idusuario, String nombre, String contra) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contra = contra;
    }
    public Usuarios(int idusuario, String nombre, String contra, List<Pedidos> pedidosCollection) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contra = contra;
        this.pedidosCollection=pedidosCollection;
    }

    public List<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(List<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }
    public int getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContra(String contra) {
        this.contra = contra;
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
        final Usuarios other = (Usuarios) obj;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.contra, other.contra);
    }
    
    
}
