/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpapruebas1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author b15-10m
 */
@Entity
@Table(name = "VENTAS")
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByIdventa", query = "SELECT v FROM Ventas v WHERE v.idventa = :idventa"),
    @NamedQuery(name = "Ventas.findByFechaventa", query = "SELECT v FROM Ventas v WHERE v.fechaventa = :fechaventa"),
    @NamedQuery(name = "Ventas.findByCantidad", query = "SELECT v FROM Ventas v WHERE v.cantidad = :cantidad")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVENTA")
    private Integer idventa;
    @Basic(optional = false)
    @Column(name = "FECHAVENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaventa;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private short cantidad;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clientes idcliente;
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Productos idproducto;

    public Ventas() {
    }

    public Ventas(Integer idventa) {
        this.idventa = idventa;
    }

    public Ventas(Integer idventa, Date fechaventa, short cantidad) {
        this.idventa = idventa;
        this.fechaventa = fechaventa;
        this.cantidad = cantidad;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Clientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientes idcliente) {
        this.idcliente = idcliente;
    }

    public Productos getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Productos idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpapruebas1.Ventas[ idventa=" + idventa + " ]";
    }
    
}
