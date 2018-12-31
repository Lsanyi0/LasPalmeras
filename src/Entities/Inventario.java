/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdDetalleCompra", query = "SELECT i FROM Inventario i WHERE i.idDetalleCompra = :idDetalleCompra")
    , @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "Inventario.findByIdFechavencimiento", query = "SELECT i FROM Inventario i WHERE i.idFechavencimiento = :idFechavencimiento")
    , @NamedQuery(name = "Inventario.findByCompra", query = "SELECT i FROM Inventario i WHERE i.compra = :compra")
    , @NamedQuery(name = "Inventario.findByVenta", query = "SELECT i FROM Inventario i WHERE i.venta = :venta")
    , @NamedQuery(name = "Inventario.findByExistencia", query = "SELECT i FROM Inventario i WHERE i.existencia = :existencia")})
public class Inventario implements Serializable {

    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Column(name = "Venta")
    private Integer venta;
    @Column(name = "Existencia")
    private Integer existencia;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDetalleCompra")
    private int idDetalleCompra;
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "idFechavencimiento")
    private Integer idFechavencimiento;
    @Column(name = "Compra")
    private Integer compra;

    public Inventario() {
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdFechavencimiento() {
        return idFechavencimiento;
    }

    public void setIdFechavencimiento(Integer idFechavencimiento) {
        this.idFechavencimiento = idFechavencimiento;
    }

    public Integer getCompra() {
        return compra;
    }

    public void setCompra(Integer compra) {
        this.compra = compra;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    
}
