/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproyecto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author b15-04m
 */
@Entity
@NamedQueries({
    @NamedQuery(name="PRODUCTOS.findAll", query="SELECT FROM Productos"),
    @NamedQuery(name="PRODUCTOS.findById", query="SELECT FROM Productos where idproducto=:IDPRODUCTOP")
})
public class Productos implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id @GeneratedValue
    private int idproducto;
    private String nombre;
    private int precio;
    
    @OneToOne(mappedBy="idproducto",orphanRemoval=true)
    private Pedidos pedido;

    public Productos(int idproducto) {
        this.idproducto = idproducto;
    }
    public Productos(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Productos(int idproducto, String nombre, int precio) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Productos(int idproducto, String nombre, int precio, Pedidos pedido) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.pedido = pedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    
}
