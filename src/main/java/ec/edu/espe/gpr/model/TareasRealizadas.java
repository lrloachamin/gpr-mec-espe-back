package ec.edu.espe.gpr.model;

import java.util.Date;
import java.util.List;

public class TareasRealizadas {
    private String nombreDocenteRevisor;
    private String tipoProceso;
    private String nombreProyecto;
    private String nombreTarea;
    private String prioridadTarea;
    private String pesoTarea;
    private Date fechaCreaciontarea;
    private Date fechaEntregaTarea;
    private String responsable;
    private List<TareaIndicador> tareaIndicadors;
    private String nombreArchivo;
    private String urlArchivo;
    

    public TareasRealizadas(String nombreDocenteRevisor, String tipoProceso, String nombreProyecto,
            String nombreTarea, String prioridadTarea, String pesoTarea, Date fechaCreaciontarea,
            Date fechaEntregaTarea, String responsable, List<TareaIndicador> tareaIndicadors, String nombreArchivo,
            String urlArchivo) {
        this.nombreDocenteRevisor = nombreDocenteRevisor;
        this.tipoProceso = tipoProceso;
        this.nombreProyecto = nombreProyecto;
        this.nombreTarea = nombreTarea;
        this.prioridadTarea = prioridadTarea;
        this.pesoTarea = pesoTarea;
        this.fechaCreaciontarea = fechaCreaciontarea;
        this.fechaEntregaTarea = fechaEntregaTarea;
        this.responsable = responsable;
        this.tareaIndicadors = tareaIndicadors;
        this.nombreArchivo = nombreArchivo;
        this.urlArchivo = urlArchivo;
    }

    public TareasRealizadas() {
    }

    public String getNombreDocenteRevisor() {
        return nombreDocenteRevisor;
    }

    public void setNombreDocenteRevisor(String nombreDocenteRevisor) {
        this.nombreDocenteRevisor = nombreDocenteRevisor;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }

    public String getPesoTarea() {
        return pesoTarea;
    }

    public void setPesoTarea(String pesoTarea) {
        this.pesoTarea = pesoTarea;
    }

    public Date getFechaCreaciontarea() {
        return fechaCreaciontarea;
    }

    public void setFechaCreaciontarea(Date fechaCreaciontarea) {
        this.fechaCreaciontarea = fechaCreaciontarea;
    }

    public Date getFechaEntregaTarea() {
        return fechaEntregaTarea;
    }

    public void setFechaEntregaTarea(Date fechaEntregaTarea) {
        this.fechaEntregaTarea = fechaEntregaTarea;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<TareaIndicador> getTareaIndicadors() {
        return tareaIndicadors;
    }

    public void setTareaIndicadors(List<TareaIndicador> tareaIndicadors) {
        this.tareaIndicadors = tareaIndicadors;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

}
