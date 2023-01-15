/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tarea")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TAREA")
    private Integer codigoTarea;

    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
    
    @Column(name = "FECHA_CREACIONTAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaciontarea;
    
    @Column(name = "PRIORIDAD_TAREA")
    private String prioridadTarea;
    
    @Column(name = "OBSERVACION_TAREA")
    private String observacionTarea;
    
    @Column(name = "ESTADO_TAREA")
    private Character estadoTarea;
    
    @Column(name = "FECHA_ENTREGA_TAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntregaTarea;

    @Column(name = "ARCHIVO_TAREA")
    private String archivoTarea;
    @Column(name = "NOMBRE_ARCHIVO_TAREA")
    private String nombreArchivoTarea;
    @Column(name = "PESO_TAREA")
    private String pesoTarea;
    @Column(name = "VALOR_PESO_TAREA")
    private int valorPesoTarea;

    @Column(name = "ID_DOCENTE_REVISOR")
    private String idDocenteRevisor;

    @Column(name = "NOMBRE_DOCENTE_REVISOR")
    private String nombreDocenteRevisor;

    @JoinColumn(name = "CODIGO_TAREA_PADRE", referencedColumnName = "CODIGO_TAREA")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tarea codigoTareaPadre;

    @JoinColumn(name = "CODIGO_PROYECTO", referencedColumnName = "CODIGO_PROYECTO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto codigoProyecto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTarea",fetch= FetchType.LAZY)
    @JsonBackReference(value="tareaDocenteList")
    private List<TareaDocente> tareaDocenteList;

}
