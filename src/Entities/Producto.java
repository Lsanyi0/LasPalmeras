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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByProducto", query = "SELECT p FROM Producto p WHERE p.producto LIKE :producto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p.idProducto FROM Producto p WHERE p.producto LIKE :producto")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")})
 @NamedStoredProcedureQueries ({
    @NamedStoredProcedureQuery(
        name="Producto.insertprod",
        procedureName="insertProd",
        parameters = {
        @StoredProcedureParameter(name = "pidcat",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pidmarca",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pproducto",mode = ParameterMode.IN,type = String.class),
        @StoredProcedureParameter(name = "pdescripcion",mode = ParameterMode.IN,type = String.class),
        @StoredProcedureParameter(name = "pprecio",mode = ParameterMode.IN,type = Double.class),
        @StoredProcedureParameter(name = "minsert",mode = ParameterMode.OUT,type = Integer.class),
        }),
    @NamedStoredProcedureQuery(
        name="Producto.UpdateProd",
        procedureName="actualizarProd",
        parameters = {
        @StoredProcedureParameter(name = "pidProducto",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pidCategoria",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pidMarca",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pproducto",mode = ParameterMode.IN,type = String.class),
        @StoredProcedureParameter(name = "pdescripcion",mode = ParameterMode.IN,type = String.class),
        @StoredProcedureParameter(name = "pprecio",mode = ParameterMode.IN,type = Double.class),
        @StoredProcedureParameter(name = "x",mode = ParameterMode.OUT,type = Integer.class),
        })
 })

//in pidProducto int,in pidCategoria int,in pidMarca int, in pproducto varchar(60),in pdescripcion varchar(60),in pprecio double(5,2),out x int

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "Producto")
    private String producto;
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private Double precio;
    @OneToMany(mappedBy = "idProducto")
    private List<Detalleventa> detalleventaList;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
    @ManyToOne
    private Marca idMarca;
    @OneToMany(mappedBy = "idProducto")
    private List<Detallecompra> detallecompraList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String producto) {
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
