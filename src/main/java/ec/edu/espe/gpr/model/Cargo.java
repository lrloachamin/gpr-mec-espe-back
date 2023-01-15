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

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cargo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_CARGO")
    private String codCargo;
    
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    
    @Column(name = "DESCRI_CARGO")
    private String descriCargo;

    @JoinColumn(name = "COD_CARGO_PADRE", referencedColumnName = "COD_CARGO")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cargo codCargoPadre;

    @Column(name = "COD_PERFIL_PADRE")
    private String codPerfilPadre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCargo",fetch= FetchType.LAZY)
    @JsonBackReference(value="docenteList")
    private List<Docente> docenteList;

    public Cargo() {
    }

    public Cargo(String codCargo) {
        this.codCargo = codCargo;
    }

    public Cargo(String codCargo, String nombreCargo, String descriCargo) {
        this.codCargo = codCargo;
        this.nombreCargo = nombreCargo;
        this.descriCargo = descriCargo;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescriCargo() {
        return descriCargo;
    }

    public void setDescriCargo(String descriCargo) {
        this.descriCargo = descriCargo;
    }

    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Cargo getCodCargoPadre() {
        return codCargoPadre;
    }

    public void setCodCargoPadre(Cargo codCargoPadre) {
        this.codCargoPadre = codCargoPadre;
    }

    public String getCodPerfilPadre() {
        return codPerfilPadre;
    }

    public void setCodPerfilPadre(String codPerfilPadre) {
        this.codPerfilPadre = codPerfilPadre;
    }
    
}
