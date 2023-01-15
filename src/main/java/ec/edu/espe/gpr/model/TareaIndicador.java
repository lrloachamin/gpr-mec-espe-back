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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "tarea_indicador")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TareaIndicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TAREA_INDICADOR")
    private Integer codigoTareaIndicador;
    
    @Column(name = "FECHA_CREACION_INDICADOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionIndicador;
    
    @Column(name = "VALOR_INDICADOR")
    private String valorIndicador;

    @Column(name = "DESCRIPCION_TAREA_INDICADOR")
    private String descripcionTareaIndicador;
    
    @JoinColumn(name = "indicador_CODIGO_INDICADOR", referencedColumnName = "CODIGO_INDICADOR")
    @ManyToOne(optional = false)
    private Indicador indicadorCODIGOINDICADOR;
    
    @JoinColumn(name = "tarea_docente_CODIGO_TAREA_DOCENTE", referencedColumnName = "CODIGO_TAREA_DOCENTE")
    @ManyToOne(optional = false)
    private TareaDocente tareadocenteCODIGOTAREADOCENTE;
}
