package Model;

public class Lote {

    public Lote() {
    }

    public Lote(Integer fechavencimiento, Integer cantidad) {
        this.idfechavencimiento = fechavencimiento;
        this.cantidad = cantidad;
    }

    Integer idfechavencimiento;
    Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdFechavencimiento() {
        return idfechavencimiento;
    }

    public void setIdFechavencimiento(Integer fechavencimiento) {
        this.idfechavencimiento = fechavencimiento;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
