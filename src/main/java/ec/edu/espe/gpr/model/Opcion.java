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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "opcion")
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "CODIGO_OPCION")
    private String codigoOpcion;
    
    @Column(name = "DESC_OPCION")
    private String descOpcion;
    
    @Column(name = "URL_OPCION")
    private String urlOpcion;
    
    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "codigoOpcion")
    @JsonBackReference(value="opcPerList")
    private List<OpcPer> opcPerList;
    
    @JoinColumn(name = "COD_SISTEMA", referencedColumnName = "COD_SISTEMA")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sistema codSistema;

    public Opcion() {
    }

    public Opcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public Opcion(String codigoOpcion, String descOpcion) {
        this.codigoOpcion = codigoOpcion;
        this.descOpcion = descOpcion;
    }

    public String getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public String getDescOpcion() {
        return descOpcion;
    }

    public void setDescOpcion(String descOpcion) {
        this.descOpcion = descOpcion;
    }

    public List<OpcPer> getOpcPerList() {
        return opcPerList;
    }

    public void setOpcPerList(List<OpcPer> opcPerList) {
        this.opcPerList = opcPerList;
    }

    public Sistema getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(Sistema codSistema) {
        this.codSistema = codSistema;
    }
    
    

    public String getUrlOpcion() {
		return urlOpcion;
	}

	public void setUrlOpcion(String urlOpcion) {
		this.urlOpcion = urlOpcion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOpcion != null ? codigoOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.codigoOpcion == null && other.codigoOpcion != null) || (this.codigoOpcion != null && !this.codigoOpcion.equals(other.codigoOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Opcion[ codigoOpcion=" + codigoOpcion + " ]";
    }
    
}
