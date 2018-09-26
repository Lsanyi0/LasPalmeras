/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idProducto")
    @Id
    private int idProducto;
    @Column(name = "Compra")
    private BigInteger compra;
    @Column(name = "Venta")
    private BigInteger venta;
    @Column(name = "Existencia")
    private BigInteger existencia;

    public Inventario() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public BigInteger getCompra() {
        return compra;
    }

    public void setCompra(BigInteger compra) {
        this.compra = compra;
    }

    public BigInteger getVenta() {
        return venta;
    }

    public void setVenta(BigInteger venta) {
        this.venta = venta;
    }

    public BigInteger getExistencia() {
        return existencia;
    }

    public void setExistencia(BigInteger existencia) {
        this.existencia = existencia;
    }
    
}
