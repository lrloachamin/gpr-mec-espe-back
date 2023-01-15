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
@Table(name = "docente")
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODIGO_DOCENTE")
    private Integer codigoDocente;
    
    @Column(name = "ID_DOCENTE")
    private String idDocente;
    
    @Column(name = "NOMBRE_DOCENTE")
    private String nombreDocente;
    
    @Column(name = "APELLIDO_DOCENTE")
    private String apellidoDocente;
    
    @Column(name = "CEDULA_DOCENTE")
    private String cedulaDocente;
    
    @Column(name = "TELEFONO_DOCENTE")
    private String telefonoDocente;
    
    @Column(name = "CORREO_DOCENTE")
    private String correoDocente;
    
    @Column(name = "SEXO_DOCENTE")
    private String sexo;
    
    @Column(name = "PUESTO_TRABAJO")
    private String puestoTrabajoDocente;

    @Column(name = "NUM_LOGUEO")
    private Integer numLogueo;
    
    @JoinColumn(name = "COD_CARGO", referencedColumnName = "COD_CARGO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cargo codCargo;

    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario codigoUsuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDocente",fetch= FetchType.LAZY)
    @JsonBackReference(value="tareaDocenteList")
    private List<TareaDocente> tareaDocenteList;
    
    public Docente() {
    }

    public Docente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public Docente(Integer codigoDocente, String idDocente, String nombreDocente, String apellidoDocente, String cedulaDocente, String telefonoDocente, String correoDocente) {
        this.codigoDocente = codigoDocente;
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.cedulaDocente = cedulaDocente;
        this.telefonoDocente = telefonoDocente;
        this.correoDocente = correoDocente;
    }

    public Integer getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getCedulaDocente() {
        return cedulaDocente;
    }

    public void setCedulaDocente(String cedulaDocente) {
        this.cedulaDocente = cedulaDocente;
    }

    public String getTelefonoDocente() {
        return telefonoDocente;
    }

    public void setTelefonoDocente(String telefonoDocente) {
        this.telefonoDocente = telefonoDocente;
    }

    public String getCorreoDocente() {
        return correoDocente;
    }

    public void setCorreoDocente(String correoDocente) {
        this.correoDocente = correoDocente;
    }

    public Cargo getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Cargo codCargo) {
        this.codCargo = codCargo;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    
    public List<TareaDocente> getTareaDocenteList() {
        return tareaDocenteList;
    }

    public void setTareaDocenteList(List<TareaDocente> tareaDocenteList) {
        this.tareaDocenteList = tareaDocenteList;
    }
    
    
    
    
    public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPuestoTrabajoDocente() {
		return puestoTrabajoDocente;
	}

	public void setPuestoTrabajoDocente(String puestoTrabajoDocente) {
		this.puestoTrabajoDocente = puestoTrabajoDocente;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDocente != null ? codigoDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codigoDocente == null && other.codigoDocente != null) || (this.codigoDocente != null && !this.codigoDocente.equals(other.codigoDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Docente[ codigoDocente=" + codigoDocente + " ]";
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getNumLogueo() {
        return numLogueo;
    }

    public void setNumLogueo(Integer numLogueo) {
        this.numLogueo = numLogueo;
    }
    
}
