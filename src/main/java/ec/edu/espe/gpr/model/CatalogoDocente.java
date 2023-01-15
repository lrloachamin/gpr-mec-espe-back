package ec.edu.espe.gpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogoDocente")
public class CatalogoDocente implements Serializable  {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CEDULA_DOCENTE")
    private String cedulaDocente;
    
    @Column(name = "CODIGO_DOCENTE")
    private Integer codigoDocente;
    
    @Column(name = "ID_DOCENTE")
    private String idDocente;
    
    @Column(name = "NOMBRE_DOCENTE")
    private String nombreDocente;
    
    @Column(name = "APELLIDO_DOCENTE")
    private String apellidoDocente;
    
    @Column(name = "TELEFONO_DOCENTE")
    private String telefonoDocente;
    
    @Column(name = "CORREO_DOCENTE")
    private String correoDocente;
    
    @Column(name = "SEXO_DOCENTE")
    private String sexo;
    @Column(name = "PUESTO_DOCENTE")
    private String puesto;
    
    
    
    
	public CatalogoDocente() {
		
	}
	public String getCedulaDocente() {
		return cedulaDocente;
	}
	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    

}
