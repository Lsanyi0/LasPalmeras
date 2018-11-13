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
public class Detcompra {
//    int idDetalleCompra;
//    int idcompra;
//    int idproducto;
    int cantidad;
    Double preciou;
    Date fechavencimiento; 
    double gananacia;

    public Detcompra(int cantidad, Double preciou, Date fechavencimiento, double gananacia) {
        this.cantidad = cantidad;
        this.preciou = preciou;
        this.fechavencimiento = fechavencimiento;
        this.gananacia = gananacia;
    }
}
