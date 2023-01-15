/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author steeven
 */
@Entity
@Table(name = "tipo_proceso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TIPO_PROCESO")
    private Integer codigoTipoProceso;

    @Column(name = "NOMBRE_TIPO_PROCESO")
    private String nombreTipoProceso;
    
    @Column(name = "DESCRIPCION_TIPO_PROCESO")
    private String descripcionTipoProceso;
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoprocesoCODIGOTIPOPROCESO")
    private List<Proyecto> proyectoList;*/
}
