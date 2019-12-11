/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntradaXProducto;

/**
 *
 * @author Tejada
 */
public class prodexistentes {
    int idProducto;
    int idcategoria;
    int idMarca;
    String producto;
    String descripcion;
    double precio;
 public prodexistentes
(int IdProducto,int IdCategoria,int Idmarca,String Producto,String Descripcion,Double Precio){
    this.idProducto=IdProducto;
    this.idcategoria=IdCategoria;
    this.idMarca=Idmarca;
    this.producto=Producto;
    this.descripcion=Descripcion;
    this.precio=Precio;
 }
    public int getIdProducto() {
        return idProducto;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getProducto() {
        return producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

}
