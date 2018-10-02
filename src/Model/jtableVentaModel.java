package Model;

public class jtableVentaModel {
    int cantidad;
    String nombre;
    Double preciounitario;
    private Double subtotal; 
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
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

    public Double getSubtotal() {
        return subtotal;
    }


    public Object[] toArray()
    {
        acutalizarSubtotal();
        Object[] arr = {
                        this.cantidad,
                        this.nombre,
                        this.preciounitario,
                        this.subtotal
                    };
        return arr;
    }

    public jtableVentaModel() {
        this.cantidad = 0;
        this.nombre = "";
        this.preciounitario = 0.00;
        this.subtotal = 0.00;
    }
    
    public jtableVentaModel(int cantidad, String nombre, Double preciounitario) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.preciounitario = preciounitario;
        this.subtotal = cantidad * preciounitario;
    }
    private void acutalizarSubtotal()
    {
        setSubtotal(cantidad * preciounitario);
    }
}
