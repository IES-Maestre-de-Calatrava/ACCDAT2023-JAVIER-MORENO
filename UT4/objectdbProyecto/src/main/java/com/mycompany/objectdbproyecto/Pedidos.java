/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproyecto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author b15-04m
 */
@Entity
@NamedQueries({
    @NamedQuery(name="PEDIDOS.findAll", query="SELECT FROM Pedidos"),
    @NamedQuery(name="PEDIDOS.findById", query="SELECT FROM Pedidos where idpedido=:IDPEDIDOSP")
})
public class Pedidos implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id @GeneratedValue
    private int idpedido;
    private int precioTotal;
    private Date fechaEntrega;
    //Neceisto el id de producto tambien
    @JoinColumn(name="IDPRODUCTO",referencedColumnName="IDPRODUCTO")
    @OneToOne //1 a 1
    private Productos idproducto;
    //Necesito el id de usuario
    @JoinColumn(name="IDUSUARIO",referencedColumnName="IDUSUARIO")
    @ManyToOne //1 a N
    private Usuarios idusuario;
    public Pedidos(){
        
    }
    public Pedidos(int precioTotal, Date fechaEntrega, Productos idproducto, Usuarios idusuario) {
        this.precioTotal = precioTotal;
        this.fechaEntrega = fechaEntrega;
        this.idproducto = idproducto;
        this.idusuario = idusuario;
    }
    
    public Pedidos(int idpedido, int precioTotal, Date fechaEntrega, Productos idproducto, Usuarios idusuario) {
        this.idpedido = idpedido;
        this.precioTotal = precioTotal;
        this.fechaEntrega = fechaEntrega;
        this.idproducto = idproducto;
        this.idusuario = idusuario;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public Productos getIdproducto() {
        return idproducto;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }
    
    
}
