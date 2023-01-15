/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sistema")
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "COD_SISTEMA")
    private String codSistema;
    
    @Column(name = "DESCRI_SISTEMA")
    private String descriSistema;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSistema",fetch= FetchType.LAZY)
    @JsonBackReference(value="opcionList")
    private List<Opcion> opcionList;

    public Sistema() {
    }

    public Sistema(String codSistema) {
        this.codSistema = codSistema;
    }

    public Sistema(String codSistema, String descriSistema) {
        this.codSistema = codSistema;
        this.descriSistema = descriSistema;
    }

    public String getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(String codSistema) {
        this.codSistema = codSistema;
    }

    public String getDescriSistema() {
        return descriSistema;
    }

    public void setDescriSistema(String descriSistema) {
        this.descriSistema = descriSistema;
    }

    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSistema != null ? codSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.codSistema == null && other.codSistema != null) || (this.codSistema != null && !this.codSistema.equals(other.codSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Sistema[ codSistema=" + codSistema + " ]";
    }
    
}
