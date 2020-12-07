/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "medida", catalog = "laspalmeras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medida.findAll", query = "SELECT m FROM Medida m"),
    @NamedQuery(name = "Medida.findByIdmedida", query = "SELECT m FROM Medida m WHERE m.idmedida = :idmedida"),
    @NamedQuery(name = "Medida.findByMedida", query = "SELECT m FROM Medida m WHERE m.medida = :medida")})
public class Medida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedida")
    private Integer idmedida;
    @Basic(optional = false)
    @Column(name = "medida")
    private String medida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedida")
    private List<Medidaproducto> medidaproductoList;

    public Medida() {
    }

    public Medida(Integer idmedida) {
        this.idmedida = idmedida;
    }

    public Medida(Integer idmedida, String medida) {
        this.idmedida = idmedida;
        this.medida = medida;
    }

    public Integer getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(Integer idmedida) {
        this.idmedida = idmedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @XmlTransient
    public List<Medidaproducto> getMedidaproductoList() {
        return medidaproductoList;
    }

    public void setMedidaproductoList(List<Medidaproducto> medidaproductoList) {
        this.medidaproductoList = medidaproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedida != null ? idmedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medida)) {
            return false;
        }
        Medida other = (Medida) object;
        if ((this.idmedida == null && other.idmedida != null) || (this.idmedida != null && !this.idmedida.equals(other.idmedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Medida[ idmedida=" + idmedida + " ]";
    }
    
}
