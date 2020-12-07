/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "historialprecioventa", catalog = "laspalmeras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialprecioventa.findAll", query = "SELECT h FROM Historialprecioventa h"),
    @NamedQuery(name = "Historialprecioventa.findByIdHistorialPrecioVenta", query = "SELECT h FROM Historialprecioventa h WHERE h.idHistorialPrecioVenta = :idHistorialPrecioVenta"),
    @NamedQuery(name = "Historialprecioventa.findByPrecio", query = "SELECT h FROM Historialprecioventa h WHERE h.precio = :precio")})
public class Historialprecioventa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialPrecioVenta")
    private Integer idHistorialPrecioVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private Double precio;
    @OneToMany(mappedBy = "idHistorialPrecioVenta")
    private List<Detalleventa> detalleventaList;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;

    public Historialprecioventa() {
    }
    
    public Historialprecioventa(Producto idProducto) {
        this.idProducto = idProducto;
        this.precio = idProducto.getPrecio();       
    }
    
    public Historialprecioventa(Integer idHistorialPrecioVenta) {
        this.idHistorialPrecioVenta = idHistorialPrecioVenta;
    }

    public Integer getIdHistorialPrecioVenta() {
        return idHistorialPrecioVenta;
    }

    public void setIdHistorialPrecioVenta(Integer idHistorialPrecioVenta) {
        this.idHistorialPrecioVenta = idHistorialPrecioVenta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialPrecioVenta != null ? idHistorialPrecioVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialprecioventa)) {
            return false;
        }
        Historialprecioventa other = (Historialprecioventa) object;
        if ((this.idHistorialPrecioVenta == null && other.idHistorialPrecioVenta != null) || (this.idHistorialPrecioVenta != null && !this.idHistorialPrecioVenta.equals(other.idHistorialPrecioVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Historialprecioventa[ idHistorialPrecioVenta=" + idHistorialPrecioVenta + " ]";
    }
    
}
