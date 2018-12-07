package Model;

import java.text.DecimalFormat;

public class jtableVentaModel {
    private int idProducto;
    private int cantidad;
    private String nombre;
    private Double preciounitario;
    private Double descuento;
    private Double subtotal;
    private final DecimalFormat df = new DecimalFormat("$ 0.00");
    private final DecimalFormat dfd = new DecimalFormat("-$ 0.00");
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getIdProducto() {
        return idProducto;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Double getPreciounitario() {
        return preciounitario;
    }

    public Double getDescuento() {
        return descuento;
    }
    
    public Double getSubtotal() {
        acutalizarSubtotal();
        return subtotal;
    }
    public Double getSubtotalSinDescuento()
    {
        return preciounitario * cantidad;
    }
    public Object[] toArray()
    {
        acutalizarSubtotal();
        Object[] arr = {
            this.cantidad,
            this.nombre,
            df.format(this.preciounitario),
            dfd.format(this.descuento),
            df.format(this.subtotal)
        };
        return arr;
    }
    
    public jtableVentaModel() {
        this.cantidad = 0;
        this.nombre = "";
        this.preciounitario = 0.00;
        this.subtotal = 0.00;
        this.descuento = 0.00;
    }
    
    public jtableVentaModel(int idProducto,int cantidad, String nombre, Double preciounitario, Double descuento) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.preciounitario = preciounitario;
        this.descuento = descuento;
        acutalizarSubtotal();
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    private void acutalizarSubtotal()
    {
        setSubtotal((cantidad * preciounitario)-descuento);
    }
}
