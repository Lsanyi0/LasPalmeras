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
    int cantidad;
    Date fechavencimiento;
    public Productos(int codigo, String categoria, String marca, String producto, String descripcion, Double precio, int cantidad, Date fechavencimiento) {
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

    public int getCantidad() {
        return cantidad;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }
    
}
