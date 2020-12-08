/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
        , @NamedQuery(name = "Inventario.findByIdDetalleCompra", query = "SELECT i FROM Inventario i WHERE i.idDetalleCompra = :idDetalleCompra")
        , @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto")
        , @NamedQuery(name = "Inventario.findByIdFechavencimiento", query = "SELECT i FROM Inventario i WHERE i.idFechavencimiento = :idFechavencimiento")
        , @NamedQuery(name = "Inventario.findByCompra", query = "SELECT i FROM Inventario i WHERE i.compra = :compra")
        , @NamedQuery(name = "Inventario.findByVenta", query = "SELECT i FROM Inventario i WHERE i.venta = :venta")
        , @NamedQuery(name = "Inventario.findByExistencia", query = "SELECT i FROM Inventario i WHERE i.existencia = :existencia")
        , @NamedQuery(name = "Inventario.findIdFechaVencimiento",query = "SELECT i.idFechavencimiento FROM Inventario i JOIN Fechavencimiento f WHERE i.existencia >= 1 AND i.idFechavencimiento = F.idFechavencimiento AND i.idProducto = :idProd ORDER BY f.fechavencimiento ASC")})
public class Inventario implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Compra")
    private Double compra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Venta")
    private Double venta;
    @Column(name = "Existencia")
    private Double existencia;
    
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDetalleCompra")
    private int idDetalleCompra;
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "idFechavencimiento")
    private Integer idFechavencimiento;
    
    public Inventario() {
    }
    
    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }
    
    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }
    
    public Integer getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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
    
    public Double getCompra() {
        return compra;
    }
    
    public void setCompra(Double compra) {
        this.compra = compra;
    }
    
    public Double getVenta() {
        return venta;
    }
    
    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }
    
}
