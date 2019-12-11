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
public class Compra {
//    int idCompra;
    int idProveedor;
    Date fecha;
    String representante;
    String duir;
//int idCompra,
    public Compra( int idProveedor, Date fecha, String representante, String duir) {
//        this.idCompra = idCompra;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.representante = representante;
        this.duir = duir;
    }
}
