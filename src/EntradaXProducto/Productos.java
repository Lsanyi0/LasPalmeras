/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntradaXProducto;

import java.util.Date;

/**
 *
 * @author Tejada
 */
public class Productos {
    int codigo;
    String categoria;
    String marca;
    String producto;
    String descripcion;
    Double precio;
    Double cantidad;
    Date fechavencimiento;
    public Productos(int codigo, String categoria, String marca, String producto, String descripcion, Double precio, Double cantidad, Date fechavencimiento) {
        this.codigo=codigo;
        this.categoria = categoria;
        this.marca = marca;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechavencimiento = fechavencimiento;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getProducto() {
        return producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }
    
}
