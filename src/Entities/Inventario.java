/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "Inventario.findByCompra", query = "SELECT i FROM Inventario i WHERE i.compra = :compra")
    , @NamedQuery(name = "Inventario.findByVenta", query = "SELECT i FROM Inventario i WHERE i.venta = :venta")
    , @NamedQuery(name = "Inventario.findByExistencia", query = "SELECT i FROM Inventario i WHERE i.existencia = :existencia")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idProducto", unique = true, nullable = false)
    private Integer idProducto;
    private BigInteger compra;
    private BigInteger venta;
    private BigInteger existencia;

    public Inventario() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public BigInteger getCompra() {
        return compra;
    }

    public BigInteger getVenta() {
        return venta;
    }


    public BigInteger getExistencia() {
        return existencia;
    }
    
}
