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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "perfil")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "CODIGO_PERFIL")
    private String codigoPerfil;
    
    @Column(name = "DESC_PERFIL")
    private String descPerfil;
    @Lob
    @Column(name = "OBS_PERFIL")
    private String obsPerfil;

    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPerfil",fetch= FetchType.LAZY)
    @JsonBackReference(value="opcPerList")
    private List<OpcPer> opcPerList;
    
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPerfil",fetch= FetchType.LAZY)
    @JsonBackReference(value="usuperList")
    private List<Usuper> usuperList;

    public Perfil() {
    }

    public Perfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public Perfil(String codigoPerfil, String descPerfil) {
        this.codigoPerfil = codigoPerfil;
        this.descPerfil = descPerfil;
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    public String getObsPerfil() {
        return obsPerfil;
    }

    public void setObsPerfil(String obsPerfil) {
        this.obsPerfil = obsPerfil;
    }

    public List<OpcPer> getOpcPerList() {
        return opcPerList;
    }

    public void setOpcPerList(List<OpcPer> opcPerList) {
        this.opcPerList = opcPerList;
    }

    public List<Usuper> getUsuperList() {
        return usuperList;
    }

    public void setUsuperList(List<Usuper> usuperList) {
        this.usuperList = usuperList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
