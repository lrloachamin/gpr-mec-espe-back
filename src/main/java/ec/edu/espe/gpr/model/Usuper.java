/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuper")
public class Usuper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_USUPER")
    private Integer codUsuper;
    
    @Column(name = "FECHA_ASG_USUPER")
    @Temporal(TemporalType.DATE)
    private Date fechaAsgUsuper;
    @Column(name = "FECH_RETIRO_USUPER_OPCPER")
    @Temporal(TemporalType.DATE)
    private Date fechRetiroUsuperOpcper;
    
    @JsonIgnore 
    @JoinColumn(name = "CODIGO_PERFIL", referencedColumnName = "CODIGO_PERFIL")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Perfil codigoPerfil;
    
    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Usuario codigoUsuario;

    public Usuper() {
    }

    public Usuper(Integer codUsuper) {
        this.codUsuper = codUsuper;
    }

    public Usuper(Integer codUsuper, Date fechaAsgUsuper) {
        this.codUsuper = codUsuper;
        this.fechaAsgUsuper = fechaAsgUsuper;
    }

    public Integer getCodUsuper() {
        return codUsuper;
    }

    public void setCodUsuper(Integer codUsuper) {
        this.codUsuper = codUsuper;
    }

    public Date getFechaAsgUsuper() {
        return fechaAsgUsuper;
    }

    public void setFechaAsgUsuper(Date fechaAsgUsuper) {
        this.fechaAsgUsuper = fechaAsgUsuper;
    }

    public Date getFechRetiroUsuperOpcper() {
        return fechRetiroUsuperOpcper;
    }

    public void setFechRetiroUsuperOpcper(Date fechRetiroUsuperOpcper) {
        this.fechRetiroUsuperOpcper = fechRetiroUsuperOpcper;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuper != null ? codUsuper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuper)) {
            return false;
        }
        Usuper other = (Usuper) object;
        if ((this.codUsuper == null && other.codUsuper != null) || (this.codUsuper != null && !this.codUsuper.equals(other.codUsuper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Usuper[ codUsuper=" + codUsuper + " ]";
    }
    
}
