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
@Table(name = "ventaseparada", catalog = "laspalmeras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventaseparada.findAll", query = "SELECT v FROM Ventaseparada v"),
    @NamedQuery(name = "Ventaseparada.findByIdVentaSep", query = "SELECT v FROM Ventaseparada v WHERE v.idVentaSep = :idVentaSep"),
    @NamedQuery(name = "Ventaseparada.findByIdfechavencimiento", query = "SELECT v FROM Ventaseparada v WHERE v.idfechavencimiento = :idfechavencimiento"),
    @NamedQuery(name = "Ventaseparada.findByIdProducto", query = "SELECT v FROM Ventaseparada v where v.idProducto = :idProducto"),
    @NamedQuery(name = "Ventaseparada.findByCantidad", query = "SELECT v FROM Ventaseparada v WHERE v.cantidad = :cantidad")})
public class Ventaseparada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentaSep")
    private Integer idVentaSep;
    @Column(name = "idfechavencimiento")
    private Integer idfechavencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad")
    private Double cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;

    public Ventaseparada() {
    }

    public Ventaseparada(Integer idVentaSep) {
        this.idVentaSep = idVentaSep;
    }

    public Integer getIdVentaSep() {
        return idVentaSep;
    }

    public void setIdVentaSep(Integer idVentaSep) {
        this.idVentaSep = idVentaSep;
    }

    public Integer getIdfechavencimiento() {
        return idfechavencimiento;
    }

    public void setIdfechavencimiento(Integer idfechavencimiento) {
        this.idfechavencimiento = idfechavencimiento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
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
        hash += (idVentaSep != null ? idVentaSep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventaseparada)) {
            return false;
        }
        Ventaseparada other = (Ventaseparada) object;
        if ((this.idVentaSep == null && other.idVentaSep != null) || (this.idVentaSep != null && !this.idVentaSep.equals(other.idVentaSep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Ventaseparada[ idVentaSep=" + idVentaSep + " ]";
    }
    
}
