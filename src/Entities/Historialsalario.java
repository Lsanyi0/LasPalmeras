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
@Table(name = "historialsalario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialsalario.findAll", query = "SELECT h FROM Historialsalario h")
    , @NamedQuery(name = "Historialsalario.findByIdHistorial", query = "SELECT h FROM Historialsalario h WHERE h.idHistorial = :idHistorial")
    , @NamedQuery(name = "Historialsalario.findByAumentoParcial", query = "SELECT h FROM Historialsalario h WHERE h.aumentoParcial = :aumentoParcial")})
public class Historialsalario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorial")
    private Integer idHistorial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AumentoParcial")
    private Double aumentoParcial;
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    @ManyToOne
    private Estadousuario idEstado;

    public Historialsalario() {
    }

    public Historialsalario(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Double getAumentoParcial() {
        return aumentoParcial;
    }

    public void setAumentoParcial(Double aumentoParcial) {
        this.aumentoParcial = aumentoParcial;
    }

    public Estadousuario getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estadousuario idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialsalario)) {
            return false;
        }
        Historialsalario other = (Historialsalario) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Historialsalario[ idHistorial=" + idHistorial + " ]";
    }
    
}
