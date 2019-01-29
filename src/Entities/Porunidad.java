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
@Table(name = "porunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porunidad.findAll", query = "SELECT p FROM Porunidad p")
        , @NamedQuery(name = "Porunidad.findByIdporunidad", query = "SELECT p FROM Porunidad p WHERE p.idporunidad = :idporunidad")
        , @NamedQuery(name = "Porunidad.findByIdProducto", query = "SELECT p FROM Porunidad p WHERE p.idProducto = :idproducto")})
public class Porunidad implements Serializable {

    @JoinColumn(name = "idUnidadProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idUnidadProducto;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idporunidad")
    private Integer idporunidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;
    
    public Porunidad() {
    }
    
    public Porunidad(Integer idporunidad) {
        this.idporunidad = idporunidad;
    }
    
    public Integer getIdporunidad() {
        return idporunidad;
    }
    
    public void setIdporunidad(Integer idporunidad) {
        this.idporunidad = idporunidad;
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
        hash += (idporunidad != null ? idporunidad.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porunidad)) {
            return false;
        }
        Porunidad other = (Porunidad) object;
        if ((this.idporunidad == null && other.idporunidad != null) || (this.idporunidad != null && !this.idporunidad.equals(other.idporunidad))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entities.Porunidad[ idporunidad=" + idporunidad + " ]";
    }

    public Producto getIdUnidadProducto() {
        return idUnidadProducto;
    }

    public void setIdUnidadProducto(Producto idUnidadProducto) {
        this.idUnidadProducto = idUnidadProducto;
    }
    
}
