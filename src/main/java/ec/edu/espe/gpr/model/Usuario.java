/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODIGO_USUARIO")
    private Integer codigoUsuario;
    
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    
    @Column(name = "PASSW_USUARIO")
    private String passwUsuario;
    
    @Column(name = "FECHA_CRE_USU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreUsu;
    
    @Column(name = "FECHA_MOD_USUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModUsuario;
    
    @Column(name = "ESTADO_USUARIO")
    private Character estadoUsuario;
    
    @OneToMany( fetch= FetchType.LAZY,mappedBy = "codigoUsuario")
    @JsonBackReference(value="usuperList")
    private List<Usuper> usuperList;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "codigoUsuario")
    @JsonBackReference(value="docenteList")
    private List<Docente> docenteList;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(Integer codigoUsuario, String nombreUsuario, String passwUsuario, Date fechaCreUsu, Date fechaModUsuario, Character estadoUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwUsuario = passwUsuario;
        this.fechaCreUsu = fechaCreUsu;
        this.fechaModUsuario = fechaModUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswUsuario() {
        return passwUsuario;
    }

    public void setPasswUsuario(String passwUsuario) {
        this.passwUsuario = passwUsuario;
    }

    public Date getFechaCreUsu() {
        return fechaCreUsu;
    }

    public void setFechaCreUsu(Date fechaCreUsu) {
        this.fechaCreUsu = fechaCreUsu;
    }

    public Date getFechaModUsuario() {
        return fechaModUsuario;
    }

    public void setFechaModUsuario(Date fechaModUsuario) {
        this.fechaModUsuario = fechaModUsuario;
    }

    public Character getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Character estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public List<Usuper> getUsuperList() {
        return usuperList;
    }

    public void setUsuperList(List<Usuper> usuperList) {
        this.usuperList = usuperList;
    }

    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
