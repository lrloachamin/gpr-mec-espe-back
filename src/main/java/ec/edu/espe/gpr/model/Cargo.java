/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cargo")
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_CARGO")
    private String codCargo;
    
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    
    @Column(name = "DESCRI_CARGO")
    private String descriCargo;
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "codCargo",fetch= FetchType.LAZY)
    @JsonBackReference(value="docenteList")
    private List<Docente> docenteList;*/
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCargo",fetch= FetchType.LAZY)
    @JsonBackReference(value="cargoDocenteList")
    private List<CargoDocente> cargoDocenteList;*/

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

    /*public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }*/

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCargo == null) ? 0 : codCargo.hashCode());
        result = prime * result + ((nombreCargo == null) ? 0 : nombreCargo.hashCode());
        result = prime * result + ((descriCargo == null) ? 0 : descriCargo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cargo other = (Cargo) obj;
        if (codCargo == null) {
            if (other.codCargo != null)
                return false;
        } else if (!codCargo.equals(other.codCargo))
            return false;
        if (nombreCargo == null) {
            if (other.nombreCargo != null)
                return false;
        } else if (!nombreCargo.equals(other.nombreCargo))
            return false;
        if (descriCargo == null) {
            if (other.descriCargo != null)
                return false;
        } else if (!descriCargo.equals(other.descriCargo))
            return false;
        return true;
    }
}
