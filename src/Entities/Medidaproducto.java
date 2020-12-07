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
@Table(name = "medidaproducto", catalog = "laspalmeras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidaproducto.findAll", query = "SELECT m FROM Medidaproducto m"),
    @NamedQuery(name = "Medidaproducto.findByIdmedidaproducto", query = "SELECT m FROM Medidaproducto m WHERE m.idmedidaproducto = :idmedidaproducto"),
    @NamedQuery(name = "Medidaproducto.findByCantidaddisponible", query = "SELECT m FROM Medidaproducto m WHERE m.cantidaddisponible = :cantidaddisponible")})
public class Medidaproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedidaproducto")
    private Integer idmedidaproducto;
    @Column(name = "cantidaddisponible")
    private Integer cantidaddisponible;
    @JoinColumn(name = "idmedida", referencedColumnName = "idmedida")
    @ManyToOne(optional = false)
    private Medida idmedida;
    @JoinColumn(name = "idproducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Medidaproducto() {
    }

    public Medidaproducto(Integer idmedidaproducto) {
        this.idmedidaproducto = idmedidaproducto;
    }

    public Integer getIdmedidaproducto() {
        return idmedidaproducto;
    }

    public void setIdmedidaproducto(Integer idmedidaproducto) {
        this.idmedidaproducto = idmedidaproducto;
    }

    public Integer getCantidaddisponible() {
        return cantidaddisponible;
    }

    public void setCantidaddisponible(Integer cantidaddisponible) {
        this.cantidaddisponible = cantidaddisponible;
    }

    public Medida getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(Medida idmedida) {
        this.idmedida = idmedida;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedidaproducto != null ? idmedidaproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidaproducto)) {
            return false;
        }
        Medidaproducto other = (Medidaproducto) object;
        if ((this.idmedidaproducto == null && other.idmedidaproducto != null) || (this.idmedidaproducto != null && !this.idmedidaproducto.equals(other.idmedidaproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Medidaproducto[ idmedidaproducto=" + idmedidaproducto + " ]";
    }
    
}
