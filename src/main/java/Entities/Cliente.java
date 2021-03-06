/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
        , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
        , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
        , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
        , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
        , @NamedQuery(name = "Cliente.findByDui", query = "SELECT c FROM Cliente c WHERE c.dui = :dui")})
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "DUI")
    private String dui;
    @OneToMany(mappedBy = "idCliente")
    private List<Venta> ventaList;
    @OneToMany(mappedBy = "idCliente")
    private List<Telefono> telefonoList;
    
    public Cliente() {
        direccion = "";
    }
    
    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    public Integer getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDui() {
        return dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    
    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }
    
    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }
    
    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }
    
    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }
    
    public Object[] toArray()
    {
        return new Object[]
        {
            this.getIdCliente(),
            this.getNombre(),
            this.getApellido(),
            this.getDui(),
            this.getDireccion(),
        };
    }
    
    @Override
    public String toString() {
        return nombre+" "+apellido+", "+dui;
    }
    public String Validar()
    {

        if (!this.getNombre().trim().isEmpty())
        {
//            if(!this.getNombre().matches("^([\\u00c0-\\u01ffa-zA-Z'\\-])+$")) error = "Nombre no válido";
            if (this.getApellido().length()>25) return "Apellido muy largo Max{25}";
        }    
        else return "Nombre vacío";
        if (!this.getNombre().equals(Forms.GenerarVenta.rbAnonimo.getText()))
        {
            if (this.getApellido().trim().isEmpty()) return "Apellido vacío";
//            if(!this.getApellido().matches("^([\\u00c0-\\u01ffa-zA-Z'\\-])+$")) error = "Apellido no válido";
            if (this.getApellido().length()>25) return "Apellido muy largo Max{25}";
        }
        if (!this.getDui().trim().isEmpty())
        {
            if (!this.getDui().matches("\\d{8}[-]\\d{1}")) return "Formato de dui incorrecto";
        }
        if(!this.getDireccion().trim().isEmpty())
        {
            if (this.getDireccion().length() > 75) return "Direccion muy larga Max{75}";
        }
        return "OK";
    }
}
