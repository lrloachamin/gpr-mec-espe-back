package ec.edu.espe.gpr.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.IProyectoDao;
import ec.edu.espe.gpr.enums.EstadoProyectoEnum;
import ec.edu.espe.gpr.model.Proyecto;

@Service
public class ProyectoService {
	
	@Autowired
	private IProyectoDao proyectoDao;
	
	public Proyecto obtenerPorCodigoProyecto(Integer codProyecto) {	
		Optional<Proyecto> proyOpt = this.proyectoDao.findById(codProyecto);
		if (proyOpt.isPresent())
			return proyOpt.get();
		else 
			return null;
	}

	public List<Proyecto> listarProyectos() {
        return this.proyectoDao.findAll();
    }
	
    public void crear(Proyecto proyecto) {
        Long codProy = proyectoDao.count()+1;
        proyecto.setCodigoProyecto(codProy.intValue());
        proyecto.setNombreProyecto(proyecto.getNombreProyecto().toUpperCase());
        proyecto.setFechaCreacionproyecto(new Date());
		proyecto.setEstadoProyecto(EstadoProyectoEnum.ACTIVE.getValue());
		this.proyectoDao.save(proyecto);
    }

    public Proyecto modificarDatos(Proyecto proyecto) {
        /*Proyecto proyectoDB = this.obtenerPorCodigoProyecto(proyecto.getCodigoProyecto());
        proyectoDB.setNombreProyecto(proyecto.getNombreProyecto());
		proyectoDB.setDescripcionProyecto(proyecto.getDescripcionProyecto());
		this.proyectoDao.save(proyectoDB);*/
        proyecto.setNombreProyecto(proyecto.getNombreProyecto().toUpperCase());
        this.proyectoDao.save(proyecto);
        //return proyectoDB;
        return proyecto;
    }
	
    public Proyecto cambiarEstadoProyecto(Integer codProyecto) {
        Proyecto proyectoDB = this.obtenerPorCodigoProyecto(codProyecto);
        if(proyectoDB.getEstadoProyecto().equals(EstadoProyectoEnum.ACTIVE.getValue()))
            proyectoDB.setEstadoProyecto(EstadoProyectoEnum.INACTIVE.getValue());
        else 
            proyectoDB.setEstadoProyecto(EstadoProyectoEnum.ACTIVE.getValue());
        this.proyectoDao.save(proyectoDB);
        return proyectoDB;
    }
}
