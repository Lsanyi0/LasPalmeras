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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estadousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadousuario.findAll", query = "SELECT e FROM Estadousuario e")
    , @NamedQuery(name = "Estadousuario.findByIdEstado", query = "SELECT e FROM Estadousuario e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "Estadousuario.findByEstado", query = "SELECT e FROM Estadousuario e WHERE e.estado = :estado")
    , @NamedQuery(name = "Estadousuario.findByInicioLaboral", query = "SELECT e FROM Estadousuario e WHERE e.inicioLaboral = :inicioLaboral")
    , @NamedQuery(name = "Estadousuario.findByFinLaboral", query = "SELECT e FROM Estadousuario e WHERE e.finLaboral = :finLaboral")})
public class Estadousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstado")
    private Integer idEstado;
    @Column(name = "Estado")
    private Character estado;
    @Basic(optional = false)
    @Column(name = "inicioLaboral")
    @Temporal(TemporalType.DATE)
    private Date inicioLaboral;
    @Column(name = "finLaboral")
    @Temporal(TemporalType.DATE)
    private Date finLaboral;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idEstado")
    private List<Historialsalario> historialsalarioList;

    public Estadousuario() {
    }

    public Estadousuario(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Estadousuario(Integer idEstado, Date inicioLaboral) {
        this.idEstado = idEstado;
        this.inicioLaboral = inicioLaboral;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getInicioLaboral() {
        return inicioLaboral;
    }

    public void setInicioLaboral(Date inicioLaboral) {
        this.inicioLaboral = inicioLaboral;
    }

    public Date getFinLaboral() {
        return finLaboral;
    }

    public void setFinLaboral(Date finLaboral) {
        this.finLaboral = finLaboral;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Historialsalario> getHistorialsalarioList() {
        return historialsalarioList;
    }

    public void setHistorialsalarioList(List<Historialsalario> historialsalarioList) {
        this.historialsalarioList = historialsalarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadousuario)) {
            return false;
        }
        Estadousuario other = (Estadousuario) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Estadousuario[ idEstado=" + idEstado + " ]";
    }
    
}
