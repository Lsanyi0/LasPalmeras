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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "detallecompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompra.findAll", query = "SELECT d FROM Detallecompra d")
    , @NamedQuery(name = "Detallecompra.findByIdDetalleCompra", query = "SELECT d FROM Detallecompra d WHERE d.idDetalleCompra = :idDetalleCompra")
    , @NamedQuery(name = "Detallecompra.findByCantidad", query = "SELECT d FROM Detallecompra d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallecompra.findByPrecioUnitario", query = "SELECT d FROM Detallecompra d WHERE d.precioUnitario = :precioUnitario")})
@NamedStoredProcedureQuery(
        name="DetalleCompra.InsertDCompra",
        procedureName="GenerarDCompra",
        parameters = {
        @StoredProcedureParameter(name = "pidcompra",mode = ParameterMode.IN,type = Integer.class),
            @StoredProcedureParameter(name = "pidproducto",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "pcantidad",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "ppreciou",mode = ParameterMode.IN,type = Double.class),
        @StoredProcedureParameter(name = "pidfechaVencimiento",mode = ParameterMode.IN,type = Integer.class),
        @StoredProcedureParameter(name = "x",mode = ParameterMode.OUT,type = Integer.class),
    }
)
public class Detallecompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCompra")
    private Integer idDetalleCompra;
    @Column(name = "Cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecioUnitario")
    private Double precioUnitario;
    @JoinColumn(name = "idCompra", referencedColumnName = "idCompra")
    @ManyToOne
    private Compra idCompra;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "idFechaVencimiento", referencedColumnName = "idFechavencimiento")
    @ManyToOne
    private Fechavencimiento idFechaVencimiento;

    public Detallecompra() {
    }

    public Detallecompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Fechavencimiento getIdFechaVencimiento() {
        return idFechaVencimiento;
    }

    public void setIdFechaVencimiento(Fechavencimiento idFechaVencimiento) {
        this.idFechaVencimiento = idFechaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCompra != null ? idDetalleCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompra)) {
            return false;
        }
        Detallecompra other = (Detallecompra) object;
        if ((this.idDetalleCompra == null && other.idDetalleCompra != null) || (this.idDetalleCompra != null && !this.idDetalleCompra.equals(other.idDetalleCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Detallecompra[ idDetalleCompra=" + idDetalleCompra + " ]";
    }
    
}
