/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdDetalleCompra", query = "SELECT i FROM Inventario i WHERE i.idDetalleCompra = :idDetalleCompra")
    , @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "Inventario.findByCompra", query = "SELECT i FROM Inventario i WHERE i.compra = :compra")
    , @NamedQuery(name = "Inventario.findByVenta", query = "SELECT i FROM Inventario i WHERE i.venta = :venta")
    , @NamedQuery(name = "Inventario.findByExistencia", query = "SELECT i FROM Inventario i WHERE i.existencia = :existencia")
    , @NamedQuery(name = "Inventario.findIdFechaVencimiento",query = "SELECT i.idFechavencimiento FROM Inventario i JOIN Fechavencimiento f WHERE i.existencia >= 1 AND i.idFechavencimiento = F.idFechavencimiento AND i.idProducto = :idProd ORDER BY f.fechavencimiento ASC")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idDetalleCompra")
    private int idDetalleCompra;
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "idFechavencimiento")
    private Integer idFechavencimiento;
    @Column(name = "Compra")
    private Integer compra;
    @Column(name = "Venta")
    private Integer venta;
    @Column(name = "Existencia")
    private Integer existencia;

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
    
    public Integer getCompra() {
        return compra;
    }

    public void setCompra(Integer compra) {
        this.compra = compra;
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    
}
