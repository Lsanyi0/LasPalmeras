/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredFunctionQuery;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByDui", query = "SELECT u FROM Usuario u WHERE u.dui = :dui")
    , @NamedQuery(name = "Usuario.findBySalario", query = "SELECT u FROM Usuario u WHERE u.salario = :salario")
    , @NamedQuery(name = "Usuario.findByNUsuario", query = "SELECT u FROM Usuario u WHERE u.nUsuario = :nUsuario")})
@NamedStoredFunctionQuery(
                           name="Usuario.login",
                           functionName="login",
                           parameters={
                           @org.eclipse.persistence.annotations.StoredProcedureParameter(
                                        direction = Direction.IN,
                                        name = "usser",
                                        queryParameter = "usser",
                                        type = String.class),
                           @org.eclipse.persistence.annotations.StoredProcedureParameter(
                                        direction = Direction.IN,
                                        name = "pssword",
                                        queryParameter = "pssword",
                                        type = String.class)},
                           returnParameter = @org.eclipse.persistence.annotations.StoredProcedureParameter(
                                    queryParameter = "RETURN",
                                    type = Boolean.class
                           ))
@NamedStoredProcedureQuery(
    name="Usuario.addUser",
    procedureName = "addUser",
    parameters = 
       {
            @StoredProcedureParameter(name = "Uname",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "ULname",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "UDUI",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "URole",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "Uposition",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "Usalary",mode = ParameterMode.IN,type = Double.class),
            @StoredProcedureParameter(name = "Usser",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "Upassword",mode = ParameterMode.IN,type = String.class),
            @StoredProcedureParameter(name = "Ustart",mode = ParameterMode.IN,type = Date.class),
            @StoredProcedureParameter(name = "MSG",mode = ParameterMode.OUT,type = String.class),
        })

public class Usuario implements Serializable {

    @Column(name = "uPassword")
    private String uPassword;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "DUI")
    private String dui;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salario")
    private Double salario;
    @Column(name = "nUsuario")
    private String nUsuario;
    @OneToMany(mappedBy = "idUsuario")
    private List<Venta> ventaList;
    @OneToMany(mappedBy = "idUsuario")
    private List<Estadousuario> estadousuarioList;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    @ManyToOne
    private Rol idRol;
    @JoinColumn(name = "idCargo", referencedColumnName = "idCargo")
    @ManyToOne
    private Cargo idCargo;
    @OneToMany(mappedBy = "idUsuario")
    private List<Telefono> telefonoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNUsuario() {
        return nUsuario;
    }

    public void setNUsuario(String nUsuario) {
        this.nUsuario = nUsuario;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Estadousuario> getEstadousuarioList() {
        return estadousuarioList;
    }

    public void setEstadousuarioList(List<Estadousuario> estadousuarioList) {
        this.estadousuarioList = estadousuarioList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }
    
}
