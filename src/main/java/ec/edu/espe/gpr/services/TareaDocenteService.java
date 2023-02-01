package ec.edu.espe.gpr.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ec.edu.espe.gpr.controller.FileController;
import ec.edu.espe.gpr.dao.CargoDocenteDao;
import ec.edu.espe.gpr.dao.ICargoDao;
import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.ITareaDao;
import ec.edu.espe.gpr.dao.ITareaDocenteDao;
import ec.edu.espe.gpr.dao.IndicadorDao;
import ec.edu.espe.gpr.dao.TareaIndicadorDao;
import ec.edu.espe.gpr.enums.EstadoTareaDocenteEnum;
import ec.edu.espe.gpr.enums.EstadoTareaEnum;
import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.CargoDocente;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Indicador;
import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaDocenteProyecto;
import ec.edu.espe.gpr.model.TareaIndicador;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
/*import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;
import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;
import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.dao.IPerfilDao;
import ec.edu.espe.gpr.dao.IPerfilDao;*/
import ec.edu.espe.gpr.model.TareasRealizadas;

@Service
public class TareaDocenteService {

    @Autowired
    private ITareaDao tareaDao;
    @Autowired
    private ITareaDocenteDao tareaDocenteDao;
    @Autowired
    private IDocenteDao docenteDao;
    @Autowired
    private IndicadorDao indicadorDao;
    @Autowired
    private TareaIndicadorDao tareaIndicadorDao;
    @Autowired
    private ICargoDao cargoDao;
    @Autowired
    private CargoDocenteDao cargoDocenteDao;
    /*
     * @Autowired
     * private IPerfilDao perfilDao;
     * 
     * @Autowired
     * private IUsuarioPerfilDao usuarioperfilDao;
     */
    @Autowired
    private IEmailService emservice;

    private final Path root = Paths.get("uploads");
    private final Path rootFileGuia = Paths.get("archivo_guia");

    public Tarea obtenerTareaPorCodigoTarea(Integer codTarea) {
        Optional<Tarea> tareaOpt = this.tareaDao.findById(codTarea);
        if (tareaOpt.isPresent())
            return tareaOpt.get();
        else
            return null;
    }

    public Cargo obtenerCargoPorCodigoCargo(String codigoCargo) {
        Optional<Cargo> cargoOpt = this.cargoDao.findById(codigoCargo);
        if (cargoOpt.isPresent())
            return cargoOpt.get();
        else
            return null;
    }

    /*
     * private Docente obtenerDocentePorCodigoUsuario(Usuario usuario) {
     * Optional<Docente> docenteOpt = this.docenteDao.findByCodigoUsuario(usuario);
     * if (docenteOpt.isPresent())
     * return docenteOpt.get();
     * else
     * return null;
     * }
     * 
     * private List<Docente> obtenerDocentesPorPerfil(Perfil perfil){
     * List<Usuper> usupers= this.usuarioperfilDao.findByCodigoPerfil(perfil);
     * List<Docente> docentes = new ArrayList<>();
     * for (Usuper usuper : usupers) {
     * Docente docente =
     * this.obtenerDocentePorCodigoUsuario(usuper.getCodigoUsuario());
     * docentes.add(docente);
     * }
     * return docentes;
     * }
     * 
     * private Perfil obtenerPerfilPorCodigoPerfil(String codPerfil) {
     * Optional<Perfil> perfilOpt = this.perfilDao.findById(codPerfil);
     * if (perfilOpt.isPresent())
     * return perfilOpt.get();
     * else
     * return null;
     * }
     * 
     */
    /*
     * private Perfil obtenerPerfilPorCodigoPerfilPadre(Perfil codPerfil) {
     * Optional<Perfil> perfilOpt =
     * this.perfilDao.findByCodigoPerfilPadre(codPerfil);
     * if (perfilOpt.isPresent())
     * return perfilOpt.get();
     * else
     * return null;
     * }
     */

    public List<Docente> obtenerDocentesPorCargo(String codigoCargo, Integer codigoDocente) {
        Cargo cargo = this.obtenerCargoPorCodigoCargo(codigoCargo);
        // Docente docente = this.obtenerDocentePorCodigoDocente(codigoDocente);
        List<CargoDocente> cargoDocentes = this.cargoDocenteDao.findByCodCargo(cargo);
        // Cargo cargo = obtenerCargoPorCodigoCargo(codigoCargo);
        /*
         * Perfil perfil =
         * obtenerPerfilPorCodigoPerfilPadre(obtenerPerfilPorCodigoPerfil(codigoPerfil))
         * ;
         * List<Docente> docentes = this.obtenerDocentesPorPerfil(perfil);
         * List<Docente> docentesPerfil = new ArrayList<>();
         */
        List<Docente> docentes = new ArrayList<>();
        for (CargoDocente cargoDocente : cargoDocentes) {
            if (cargoDocente.getCodigoDocente().getCodigoDocente() != codigoDocente)
                docentes.add(cargoDocente.getCodigoDocente());
        }
        return docentes;// this.docenteDao.findByCodCargo(cargo);
        /*
         * for (Docente docente : docentes) {
         * if(docente.getCodCargo().equals(cargo))
         * docentesPerfil.add(docente);
         * }
         */
        /*
         * Docente docente = docenteDao.findByNombreDocente("Admin");
         * int indice = docentes.indexOf(docente);
         * if(indice != -1)
         * docentes.remove(indice);
         */

        // return docentesPerfil;
    }

    public Docente obtenerDocentePorCodigoDocente(Integer codigoDocente) {
        Optional<Docente> docenteOpt = this.docenteDao.findByCodigoDocente(codigoDocente);
        if (docenteOpt.isPresent())
            return docenteOpt.get();
        else
            return null;
    }

    public TareaDocente obtenerIndicadorPorCodigoTareaDocente(Integer codigoTareaDocente) {
        Optional<TareaDocente> tareaDocenteOpt = this.tareaDocenteDao.findById(codigoTareaDocente);
        if (tareaDocenteOpt.isPresent())
            return tareaDocenteOpt.get();
        else
            return null;
    }

    public List<TareaDocenteProyecto> listarTareasDocentes(String idDocente) {
        List<TareaDocenteProyecto> tListDocenteProyecto = new ArrayList<>();
        List<Tarea> tarea = this.tareaDao.findByIdDocenteRevisor(idDocente);
        for (Tarea t : tarea) {
            TareaDocenteProyecto tDocenteProyecto = new TareaDocenteProyecto();
            tDocenteProyecto.setTarea(t);
            Boolean check = true;
            List<Docente> docentes = new ArrayList<>();
            for (TareaDocente tDocente : t.getTareaDocenteList()) {
                if (check) {
                    List<Indicador> tareaIndicadors = new ArrayList<>();

                    for (TareaIndicador tareaIndicador : tDocente.getTareaIndicadorList()) {
                        Indicador indicador = new Indicador(
                                tareaIndicador.getIndicadorCODIGOINDICADOR().getCodigoIndicador(),
                                tareaIndicador.getIndicadorCODIGOINDICADOR().getNombreIndicador(),
                                tareaIndicador.getIndicadorCODIGOINDICADOR().getEstadoIndicador(),
                                tareaIndicador.getDescripcionTareaIndicador());
                        tareaIndicadors.add(indicador);
                    }
                    tDocenteProyecto.setIndicadors(tareaIndicadors);
                    check = false;
                }
                docentes.add(tDocente.getCodigoDocente());
            }
            tDocenteProyecto.setDocentes(docentes);
            tListDocenteProyecto.add(tDocenteProyecto);
        }
        return tListDocenteProyecto;
    }

    public List<Docente> listarDocentes() {
        List<Docente> docentes = this.docenteDao.findAll();
        Docente docente = docenteDao.findByNombreDocente("Admin");
        int indice = docentes.indexOf(docente);
        if (indice != -1)
            docentes.remove(indice);
        return docentes;
    }

    public List<Docente> listarDocentesTareasAsignadas() {
        List<Docente> docentes = this.docenteDao.findAll();
        List<Docente> docentesAsignados = new ArrayList<>();
        
        for (Docente docente : docentes) {
            for (TareaDocente tareaDocente : docente.getTareaDocenteList()) {
                if(!tareaDocente.getEstadoTareaDocente().equals(EstadoTareaDocenteEnum.ACEPTADO.getValue())) {
                    docentesAsignados.add(docente);
                    break;
                }
            }  
        }
        return docentesAsignados;
    }

    public List<Indicador> listarIndicadores() {
        return this.indicadorDao.findAll();
    }

    public List<TareaDocente> listarTareasEntregadas(String cedulaDocenteRevisor) {
        return this.tareaDocenteDao.findByEstadoTareaDocenteAndCedulaDocenteRevisor(
                EstadoTareaDocenteEnum.EN_REVISION.getText(), cedulaDocenteRevisor);
    }

    public List<TareaDocente> listarTareasAceptadas() {
        return this.tareaDocenteDao.findByEstadoTareaDocente(EstadoTareaDocenteEnum.ACEPTADO.getText());
    }

    public List<Docente> listarDocentesTareaAsignada(Tarea codigoTarea) {
        List<TareaDocente> tareas = this.tareaDocenteDao.findByCodigoTarea(codigoTarea);
        List<Docente> docentes = new ArrayList<>();
        for (TareaDocente tarea : tareas) {
            docentes.add(tarea.getCodigoDocente());
        }
        return docentes;
    }

    public List<TareaDocente> listarTareaAsignadaPorDocente(Integer codigoDocente) {
        Docente docente = this.obtenerDocentePorCodigoDocente(codigoDocente);
        List<TareaDocente> tareas = this.tareaDocenteDao.findByCodigoDocente(docente);
        return tareas;
    }

    public List<TareaIndicador> listarIndicadoresPorTarea(Integer codigoTareaDocente) {
        TareaDocente tareaDocente = this.obtenerIndicadorPorCodigoTareaDocente(codigoTareaDocente);
        return tareaDocente.getTareaIndicadorList();
    }

    public List<TareaDocente> listarDocentesTareasAsignadas(Integer codigoDocente) {
        Docente docente = this.obtenerDocentePorCodigoDocente(codigoDocente);
        return this.tareaDocenteDao.findByCodigoDocenteAndEstadoTareaDocenteNot(docente,
                EstadoTareaDocenteEnum.ACEPTADO.getValue());
    }

    public List<CargoDocente> listarCargoDocentePorCodDocente(Integer codigoDocente) {
        Docente docente = this.obtenerDocentePorCodigoDocente(codigoDocente);
        return this.cargoDocenteDao.findByCodigoDocente(docente);
    }

    public List<TareaDocente> listarTodasTareasRevisar() {
        return this.tareaDocenteDao.findByEstadoTareaDocente(EstadoTareaDocenteEnum.EN_REVISION.getValue());
    }

    public List<TareasRealizadas> listarTodasTareasRevisadas() {
        List<TareaDocente> tareaDocentes = this.tareaDocenteDao
                .findByEstadoTareaDocente(EstadoTareaDocenteEnum.ACEPTADO.getValue());
        List<TareasRealizadas> tRealizadas = new ArrayList<>();
        for (TareaDocente tareaDocente : tareaDocentes) {
            TareasRealizadas tRealizada = new TareasRealizadas();
            tRealizada.setNombreDocenteRevisor(tareaDocente.getCodigoTarea().getNombreDocenteRevisor());
            tRealizada.setTipoTarea(tareaDocente.getCodigoTarea().getTipoTarea());
            tRealizada.setTipoProceso(
                    tareaDocente.getCodigoTarea().getCodigoProyecto().getTipoProceso().getNombreTipoProceso());
            tRealizada.setNombreProyecto(tareaDocente.getCodigoTarea().getCodigoProyecto().getNombreProyecto());
            tRealizada.setNombreTarea(tareaDocente.getCodigoTarea().getNombreTarea());
            tRealizada.setPrioridadTarea(tareaDocente.getCodigoTarea().getPrioridadTarea());
            tRealizada.setPesoTarea(tareaDocente.getCodigoTarea().getValorPesoTarea() + " "
                    + tareaDocente.getCodigoTarea().getPesoTarea());
            tRealizada.setFechaCreaciontarea(tareaDocente.getCodigoTarea().getFechaCreaciontarea());
            tRealizada.setFechaEntregaTarea(tareaDocente.getCodigoTarea().getFechaEntregaTarea());
            tRealizada.setResponsable(tareaDocente.getCodigoDocente().getNombreDocente() + " "
                    + tareaDocente.getCodigoDocente().getApellidoDocente());
            tRealizada.setTareaIndicadors(this.tareaIndicadorDao.findByTareadocenteCODIGOTAREADOCENTE(tareaDocente));
            if (tareaDocente.getNombreArchivoTareaDocente() != ""
                    || tareaDocente.getNombreArchivoTareaDocente() != null) {
                tRealizada.setNombreArchivo(tareaDocente.getNombreArchivoTareaDocente());
                String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile",
                        tareaDocente.getArchivoTareaDocente()).build().toString();
                tRealizada.setUrlArchivo(url);
            }
            tRealizadas.add(tRealizada);
        }
        return tRealizadas;
    }

    public void crear(TareaDocenteProyecto tareaDocenteProyecto, MultipartFile file) {
        tareaDocenteProyecto.getTarea().setFechaCreaciontarea(new Date());
        tareaDocenteProyecto.getTarea().setEstadoTarea(EstadoTareaEnum.ACTIVE.getValue().charAt(0));

        Tarea tarea = this.tareaDao.save(tareaDocenteProyecto.getTarea());

        if (file != null) {
            String extensionArchivo = "";
            int i = file.getOriginalFilename().toString().lastIndexOf('.');

            if (i > 0)
                extensionArchivo = file.getOriginalFilename().toString().substring(i + 1);

            tarea.setArchivoTarea(tarea.getCodigoTarea().toString() + "." + extensionArchivo);
            tarea.setNombreArchivoTarea(file.getOriginalFilename());
            tarea = this.tareaDao.save(tarea);
            this.saveFileGuia(file, tarea.getArchivoTarea());
        }

        for (Docente docente : tareaDocenteProyecto.getDocentes()) {
            TareaDocente t = new TareaDocente();
            t.setEstadoTareaDocente(EstadoTareaDocenteEnum.ASIGNADA.getValue());
            t.setCodigoDocente(docente);
            t.setCodigoTarea(tarea);
            t.setCedulaDocenteRevisor(tarea.getIdDocenteRevisor());
            emservice.enviarCorreo(docente.getCorreoDocente(), "GPR - Nueva Tarea: " + tarea.getNombreTarea(),
                    "Se ha asignado una nueva tarea de prioridad " + tarea.getPrioridadTarea() +
                            ", y debe ser realizada hasta la fecha de:" + tarea.getFechaEntregaTarea());

            TareaDocente tDocenteBD = this.tareaDocenteDao.save(t);
            for (Indicador indicador : tareaDocenteProyecto.getIndicadors()) {
                TareaIndicador indicadorBD = new TareaIndicador();
                indicadorBD.setFechaCreacionIndicador(new Date());
                indicadorBD.setIndicadorCODIGOINDICADOR(indicador);
                indicadorBD.setDescripcionTareaIndicador(indicador.getDescripcionIndicador());
                indicadorBD.setTareadocenteCODIGOTAREADOCENTE(tDocenteBD);
                this.tareaIndicadorDao.save(indicadorBD);
            }
        }
    }

    private void saveFileGuia(MultipartFile file, String nameFile) {
        try {
            Files.deleteIfExists(this.rootFileGuia.resolve(nameFile));
            Files.copy(file.getInputStream(), this.rootFileGuia.resolve(nameFile));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }
    }

    public TareaDocente modificarDatos(TareaDocenteProyecto tareaDocenteProyecto, MultipartFile file) {
        Tarea tarea = this.tareaDao.save(tareaDocenteProyecto.getTarea());
        if (file != null) {
            try {
                Files.deleteIfExists(this.rootFileGuia.resolve(tarea.getArchivoTarea()));
            } catch (IOException e) {
                throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
            }
            String extensionArchivo = "";
            int i = file.getOriginalFilename().toString().lastIndexOf('.');

            if (i > 0)
                extensionArchivo = file.getOriginalFilename().toString().substring(i + 1);

            tarea.setArchivoTarea(tarea.getCodigoTarea().toString() + "." + extensionArchivo);
            tarea.setNombreArchivoTarea(file.getOriginalFilename());
            tarea = this.tareaDao.save(tarea);
            this.saveFileGuia(file, tarea.getArchivoTarea());
        }
        List<TareaDocente> tareaDocentes = this.tareaDocenteDao.findByCodigoTarea(tareaDocenteProyecto.getTarea());
        int indice;
        // Boolean check = true;
        // TareaDocente tareaD = new TareaDocente();
        for (TareaDocente tareaDocente : tareaDocentes) {
            /*
             * if(check){
             * tareaD = tareaDocente;
             * check = false;
             * }
             */
            indice = tareaDocenteProyecto.getDocentes().indexOf(tareaDocente.getCodigoDocente());
            if (indice == -1) {

                for (TareaIndicador tIndicador : tareaDocente.getTareaIndicadorList())
                    this.tareaIndicadorDao.delete(tIndicador);

                this.tareaDocenteDao.delete(tareaDocente);
            } else
                tareaDocenteProyecto.getDocentes().remove(indice);
        }

        if (tareaDocenteProyecto.getDocentes().size() > 0) {
            for (Docente docente : tareaDocenteProyecto.getDocentes()) {
                TareaDocente t = new TareaDocente();
                t.setEstadoTareaDocente(EstadoTareaDocenteEnum.ASIGNADA.getValue());
                t.setCodigoDocente(docente);
                t.setCodigoTarea(tareaDocenteProyecto.getTarea());
                emservice.enviarCorreo(docente.getCorreoDocente(),
                        "GPR - Nueva Tarea: " + tareaDocenteProyecto.getTarea().getNombreTarea(),
                        "Se ha asignado una nueva tarea de prioridad "
                                + tareaDocenteProyecto.getTarea().getPrioridadTarea() +
                                ", y debe ser realizada hasta la fecha de:"
                                + tareaDocenteProyecto.getTarea().getFechaEntregaTarea());
                TareaDocente tDocenteBD = this.tareaDocenteDao.save(t);
                for (Indicador indicador : tareaDocenteProyecto.getIndicadors()) {
                    TareaIndicador indicadorBD = new TareaIndicador();
                    indicadorBD.setFechaCreacionIndicador(new Date());
                    indicadorBD.setIndicadorCODIGOINDICADOR(indicador);
                    indicadorBD.setDescripcionTareaIndicador(indicador.getDescripcionIndicador());
                    indicadorBD.setTareadocenteCODIGOTAREADOCENTE(tDocenteBD);
                    this.tareaIndicadorDao.save(indicadorBD);
                }
            }
        }

        /*
         * 
         * List<TareaIndicador> tareaIndicadors =
         * this.tareaIndicadorDao.findByTareadocenteCODIGOTAREADOCENTE(tareaD);
         * for(TareaIndicador tareaIndicador : tareaIndicadors){
         * indice = tareaDocenteProyecto.getIndicadors().indexOf(tareaIndicador.
         * getIndicadorCODIGOINDICADOR());
         * if(indice == -1)
         * this.tareaIndicadorDao.delete(tareaIndicador);
         * else
         * tareaDocenteProyecto.getIndicadors().remove(indice);//eliminar los
         * indicadores de esta tarea
         * }
         */

        /*
         * if(tareaDocenteProyecto.getIndicadors().size() > 0){
         * for(Indicador indicador : tareaDocenteProyecto.getIndicadors()){
         * TareaIndicador indicadorBD = new TareaIndicador();
         * indicadorBD.setFechaCreacionIndicador(new Date());
         * indicadorBD.setIndicadorCODIGOINDICADOR(indicador);
         * indicadorBD.setTareadocenteCODIGOTAREADOCENTE(tDocenteBD);
         * this.tareaIndicadorDao.save(indicadorBD);
         * this.tareaIndicadorDao.save(tIndicador);
         * }
         * }
         */
        return new TareaDocente();
    }

    public void guardarTareaAsignadaAlProfesor(List<TareaIndicador> tareaIndicadors, MultipartFile file,
            Integer codigoTareaDocente) {
        TareaDocente tareaDocente = this.obtenerIndicadorPorCodigoTareaDocente(codigoTareaDocente);
        if (file != null) {
            /*
             * String extensionArchivo = "";
             * int i = file.getOriginalFilename().toString().lastIndexOf('.');
             * 
             * if (i > 0)
             * extensionArchivo = file.getOriginalFilename().toString().substring(i+1);
             */
            tareaDocente.setArchivoTareaDocente(tareaDocente.getCodigoTareaDocente().toString() + ".pdf");// Revisar
            tareaDocente.setNombreArchivoTareaDocente(file.getOriginalFilename());

            this.saveFile(file, tareaDocente.getArchivoTareaDocente());
        }

        for (TareaIndicador tIndicador : tareaIndicadors)
            this.tareaIndicadorDao.save(tIndicador);

        tareaDocente.setEstadoTareaDocente(EstadoTareaDocenteEnum.EN_REVISION.getValue());
        this.tareaDocenteDao.save(tareaDocente);
        Tarea tarea = tareaDocente.getCodigoTarea();
        tarea.setEstadoTarea(EstadoTareaEnum.INACTIVE.getValue().charAt(0));
        this.tareaDao.save(tarea);
        Docente docenteRevisor = this.docenteDao.findByCedulaDocente(tarea.getIdDocenteRevisor());
        emservice.enviarCorreo(docenteRevisor.getCorreoDocente(),
                "GPR - Actividad: " + tareaDocente.getCodigoTarea().getNombreTarea(),
                "La Actividad perteneciente a: " + tareaDocente.getCodigoDocente().getNombreDocente() + " " +
                        tareaDocente.getCodigoDocente().getApellidoDocente() + " ha sido enviada y debe ser revisada ");

    }

    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta uploads");
        }
    }

    private void saveFile(MultipartFile file, String nameFile) {
        try {
            // copy (que queremos copiar, a donde queremos copiar)
            // File archivo = new File(this.root.resolve(nameFile).toString());
            // if (archivo.exists())
            // archivo.delete();
            Files.deleteIfExists(this.root.resolve(nameFile));
            Files.copy(file.getInputStream(), this.root.resolve(nameFile));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }
    }

    public void guardarArchivoTareaAsignadaAlProfesor(MultipartFile file, Integer codigoTareaDocente) {
        /*
         * TareaDocente tareaDocente =
         * this.obtenerIndicadorPorCodigoTareaDocente(codigoTareaDocente);
         * this.saveFile(file,tareaDocente.getCodigoTareaDocente().toString()+".pdf");
         * tareaDocente.setArchivoTareaDocente(tareaDocente.getCodigoTareaDocente().
         * toString()+".pdf");//Revisar
         * tareaDocente.setNombreArchivoTareaDocente(file.getOriginalFilename());
         * tareaDocente.setEstadoTareaDocente(EstadoTareaDocenteEnum.EN_REVISION.
         * getValue());
         * this.tareaDocenteDao.save(tareaDocente);
         */
    }

    public void aprobarTareaDocente(TareaDocente tareaDocente) {
        /*DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
        String date = dateFormat.format(new Date());*/
        tareaDocente.setEstadoTareaDocente(EstadoTareaDocenteEnum.ACEPTADO.getValue());
        emservice.enviarCorreo(tareaDocente.getCodigoDocente().getCorreoDocente(),
                "GPR - Actividad: " + tareaDocente.getCodigoTarea().getNombreTarea(),
                "Su Actividad ha sido aprobada: ");
        this.tareaDocenteDao.save(tareaDocente);
    }

    public void denegarTareaDocente(TareaDocente tareaDocente) {
        tareaDocente.setEstadoTareaDocente(EstadoTareaDocenteEnum.DENEGADO.getValue());
        /*DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
        String date = dateFormat.format(new Date());*/
        emservice.enviarCorreo(tareaDocente.getCodigoDocente().getCorreoDocente(),
                "GPR - Actividad: " + tareaDocente.getCodigoTarea().getNombreTarea(),
                "Su Actividad ha sido Denegada: ");
        this.tareaDocenteDao.save(tareaDocente);
    }
}