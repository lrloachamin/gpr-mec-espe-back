/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "opc_per")
public class OpcPer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "COD_OPCPER")
    private String codOpcper;
    
    @Column(name = "FECHA_ASG_OPCPER")
    @Temporal(TemporalType.DATE)
    private Date fechaAsgOpcper;
    
    @Column(name = "FECHA_RET_OPCPER")
    @Temporal(TemporalType.DATE)
    private Date fechaRetOpcper;
    
    @JoinColumn(name = "CODIGO_OPCION", referencedColumnName = "CODIGO_OPCION")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Opcion codigoOpcion;
    
    @JsonIgnore
    @JoinColumn(name = "CODIGO_PERFIL", referencedColumnName = "CODIGO_PERFIL")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Perfil codigoPerfil;

    public OpcPer() {
    }

    public OpcPer(String codOpcper) {
        this.codOpcper = codOpcper;
    }

    public OpcPer(String codOpcper, Date fechaAsgOpcper, Date fechaRetOpcper) {
        this.codOpcper = codOpcper;
        this.fechaAsgOpcper = fechaAsgOpcper;
        this.fechaRetOpcper = fechaRetOpcper;
    }

    public String getCodOpcper() {
        return codOpcper;
    }

    public void setCodOpcper(String codOpcper) {
        this.codOpcper = codOpcper;
    }

    public Date getFechaAsgOpcper() {
        return fechaAsgOpcper;
    }

    public void setFechaAsgOpcper(Date fechaAsgOpcper) {
        this.fechaAsgOpcper = fechaAsgOpcper;
    }

    public Date getFechaRetOpcper() {
        return fechaRetOpcper;
    }

    public void setFechaRetOpcper(Date fechaRetOpcper) {
        this.fechaRetOpcper = fechaRetOpcper;
    }

    public Opcion getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(Opcion codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOpcper != null ? codOpcper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcPer)) {
            return false;
        }
        OpcPer other = (OpcPer) object;
        if ((this.codOpcper == null && other.codOpcper != null) || (this.codOpcper != null && !this.codOpcper.equals(other.codOpcper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.OpcPer[ codOpcper=" + codOpcper + " ]";
    }
    
}
