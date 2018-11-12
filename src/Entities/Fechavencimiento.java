/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "fechavencimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechavencimiento.findAll", query = "SELECT f FROM Fechavencimiento f")
    , @NamedQuery(name = "Fechavencimiento.findByIdFechavencimiento", query = "SELECT f FROM Fechavencimiento f WHERE f.idFechavencimiento = :idFechavencimiento")
    , @NamedQuery(name = "Fechavencimiento.findByFechavencimiento", query = "SELECT f FROM Fechavencimiento f WHERE f.fechavencimiento = :fechavencimiento")})
public class Fechavencimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFechavencimiento")
    private Integer idFechavencimiento;
    @Basic(optional = false)
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @OneToMany(mappedBy = "idFechaVencimiento")
    private List<Detalleventa> detalleventaList;
    @OneToMany(mappedBy = "idFechaVencimiento")
    private List<Detallecompra> detallecompraList;

    public Fechavencimiento() {
    }

    public Fechavencimiento(Integer idFechavencimiento) {
        this.idFechavencimiento = idFechavencimiento;
    }

    public Fechavencimiento(Integer idFechavencimiento, Date fechavencimiento) {
        this.idFechavencimiento = idFechavencimiento;
        this.fechavencimiento = fechavencimiento;
    }

    public Integer getIdFechavencimiento() {
        return idFechavencimiento;
    }

    public void setIdFechavencimiento(Integer idFechavencimiento) {
        this.idFechavencimiento = idFechavencimiento;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    @XmlTransient
    public List<Detallecompra> getDetallecompraList() {
        return detallecompraList;
    }

    public void setDetallecompraList(List<Detallecompra> detallecompraList) {
        this.detallecompraList = detallecompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFechavencimiento != null ? idFechavencimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechavencimiento)) {
            return false;
        }
        Fechavencimiento other = (Fechavencimiento) object;
        if ((this.idFechavencimiento == null && other.idFechavencimiento != null) || (this.idFechavencimiento != null && !this.idFechavencimiento.equals(other.idFechavencimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Fechavencimiento[ idFechavencimiento=" + idFechavencimiento + " ]";
    }
    
}
