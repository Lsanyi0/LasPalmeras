/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "detalleventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByIdDetalleVenta", query = "SELECT d FROM Detalleventa d WHERE d.idDetalleVenta = :idDetalleVenta")
    , @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalleventa.findByDescuento", query = "SELECT d FROM Detalleventa d WHERE d.descuento = :descuento")})
public class Detalleventa implements Serializable {
    @Column(name = "Ventaproductofracc")
    private Integer ventaproductofracc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad")
    private Double cantidad;
    @JoinColumn(name = "idHistorialPrecioVenta", referencedColumnName = "idHistorialPrecioVenta")
    @ManyToOne
    private Historialprecioventa idHistorialPrecioVenta;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleVenta")
    private Integer idDetalleVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Descuento")
    private Double descuento;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne
    private Venta idVenta;
    @JoinColumn(name = "idFechaVencimiento", referencedColumnName = "idFechavencimiento")
    @ManyToOne
    private Fechavencimiento idFechaVencimiento;

    public Detalleventa() {
    }

    public Detalleventa(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }


    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Fechavencimiento getIdFechaVencimiento() {
        return idFechaVencimiento;
    }

    public void setIdFechaVencimiento(Fechavencimiento idFechaVencimiento) {
        this.idFechaVencimiento = idFechaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVenta != null ? idDetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.idDetalleVenta == null && other.idDetalleVenta != null) || (this.idDetalleVenta != null && !this.idDetalleVenta.equals(other.idDetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Detalleventa[ idDetalleVenta=" + idDetalleVenta + " ]";
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Historialprecioventa getIdHistorialPrecioVenta() {
        return idHistorialPrecioVenta;
    }

    public void setIdHistorialPrecioVenta(Historialprecioventa idHistorialPrecioVenta) {
        this.idHistorialPrecioVenta = idHistorialPrecioVenta;
    }

    public Integer getVentaproductofracc() {
        return ventaproductofracc;
    }

    public void setVentaproductofracc(Integer ventaproductofracc) {
        this.ventaproductofracc = ventaproductofracc;
    }
    
}
