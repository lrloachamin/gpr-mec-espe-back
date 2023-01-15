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
@Table(name = "indicador")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Indicador implements Serializable {

    private static final long serialVersionUID = 1123123123L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_INDICADOR")
    private Integer codigoIndicador;
    
    @Column(name = "NOMBRE_INDICADOR")
    private String nombreIndicador;
    
    @Column(name = "ESTADO_INDICADOR")
    private String estadoIndicador;
    
    @Column(name = "DESCRIPCION_INDICADOR")
    private String descripcionIndicador;

}
