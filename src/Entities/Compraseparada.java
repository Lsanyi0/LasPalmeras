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
@Table(name = "compraseparada", catalog = "laspalmeras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compraseparada.findAll", query = "SELECT c FROM Compraseparada c ORDER BY c.idFechavencimiento"),
    @NamedQuery(name = "Compraseparada.findByIdComSep", query = "SELECT c FROM Compraseparada c WHERE c.idComSep = :idComSep"),
    @NamedQuery(name = "Compraseparada.findByIdFechavencimiento", query = "SELECT c FROM Compraseparada c WHERE c.idFechavencimiento = :idFechavencimiento"),
    @NamedQuery(name = "Compraseparada.findByCantidad", query = "SELECT c FROM Compraseparada c WHERE c.cantidad = :cantidad"),     
})
public class Compraseparada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComSep")
    private Integer idComSep;
    @Column(name = "idFechavencimiento")
    private Integer idFechavencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad")
    private Double cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;

    public Compraseparada() {
    }

    public Compraseparada(Integer idComSep) {
        this.idComSep = idComSep;
    }

    public Integer getIdComSep() {
        return idComSep;
    }

    public void setIdComSep(Integer idComSep) {
        this.idComSep = idComSep;
    }

    public Integer getIdFechavencimiento() {
        return idFechavencimiento;
    }

    public void setIdFechavencimiento(Integer idFechavencimiento) {
        this.idFechavencimiento = idFechavencimiento;
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
        hash += (idComSep != null ? idComSep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compraseparada)) {
            return false;
        }
        Compraseparada other = (Compraseparada) object;
        if ((this.idComSep == null && other.idComSep != null) || (this.idComSep != null && !this.idComSep.equals(other.idComSep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Compraseparada[ idComSep=" + idComSep + " ]";
    }
    
}
