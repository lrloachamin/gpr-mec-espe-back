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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tarea_docente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TareaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TAREA_DOCENTE")
    private Integer codigoTareaDocente;

    @Column(name = "ARCHIVO_TAREA_DOCENTE")
    private String archivoTareaDocente;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "DESCRIPCION_TAREADOCENTE")
    private String descripcionTareadocente;

    @Column(name = "ESTADO_TAREA_DOCENTE")
    private String estadoTareaDocente;

    @Column(name = "NOMBRE_ARCHIVO_TAREA_DOCENTE")
    private String nombreArchivoTareaDocente;

    @Column(name = "FECHA_ENTREGADA_TAREA_DOCENTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntregadaTareaDocente;

    @Column(name = "CEDULA_DOCENTE_REVISOR")
    private String cedulaDocenteRevisor;

    @JoinColumn(name = "CODIGO_DOCENTE", referencedColumnName = "CODIGO_DOCENTE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Docente codigoDocente;

    @JoinColumn(name = "CODIGO_TAREA", referencedColumnName = "CODIGO_TAREA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tarea codigoTarea;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tareadocenteCODIGOTAREADOCENTE",fetch= FetchType.LAZY)
    @JsonBackReference(value="tareaIndicadorList")
    private List<TareaIndicador> tareaIndicadorList;
}