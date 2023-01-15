package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.ICargoDao;
import ec.edu.espe.gpr.model.Cargo;
/*import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.IPerfilDao;
import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;*/
import ec.edu.espe.gpr.response.CargoResponseRest;


@Service
public class ICargoServiceImpl implements ICargoService{
	@Autowired
	private ICargoDao cargodao;
	/*@Autowired
	private IUsuarioPerfilDao usuarioperfilDao;
	@Autowired
	private IDocenteDao docenteDao;
	@Autowired
	private IPerfilDao perfilDao;
	*/
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CargoResponseRest> find() {
		CargoResponseRest response= new CargoResponseRest();
		try {
			List<Cargo> cargo= (List<Cargo>) cargodao.findAll();
			response.getCargoResponse().setCargo(cargo);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			return new ResponseEntity<CargoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
		
	}

	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<CargoResponseRest> findById(String codCargo) {
		CargoResponseRest response= new CargoResponseRest();
		List<Cargo> list= new ArrayList<>();
		try {
			Optional<Cargo> category=cargodao.findById(codCargo);
			if(category.isPresent()) {
				list.add(category.get());
				response.getCargoResponse().setCargo(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				
			}else {
				response.setMetadata("Respuesta nok", "000", "Error cargo no encontrada");
				return new ResponseEntity<CargoResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
				
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar por id");
			e.getStackTrace();
			
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CargoResponseRest> save(Cargo cargo) {
		CargoResponseRest response= new CargoResponseRest();
		List<Cargo> list= new ArrayList<>();
		try {
			
			Cargo cargosave=cargodao.save(cargo);
			if(cargosave!=null) {
			list.add(cargosave);
			
			response.getCargoResponse().setCargo(list);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			}else {
				response.setMetadata("Respuesta nok", "000", "Error categoria no guardada");
				return new ResponseEntity<CargoResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error al guardar categoria");
			e.getStackTrace();
			return new ResponseEntity<CargoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
	}
	
	public List<Cargo> findAll(){
		return this.cargodao.findAll();
	}

	/*private Docente obtenerDocentePorCodigoUsuario(Usuario usuario) {	
		Optional<Docente> docenteOpt = this.docenteDao.findByCodigoUsuario(usuario);
		if (docenteOpt.isPresent())
			return docenteOpt.get();
		else 
			return null;
	}

	private List<Cargo> obtenerCargosPorCargoPadre(Perfil perfil){
		List<Usuper> usupers= this.usuarioperfilDao.findByCodigoPerfil(perfil);
		List<Cargo> cargos = new ArrayList<>();
		for (Usuper usuper : usupers) {
			Docente docente = this.obtenerDocentePorCodigoUsuario(usuper.getCodigoUsuario());
			if(!cargos.contains(docente.getCodCargo()))
				cargos.add(docente.getCodCargo());
		}
		return cargos;
	}*/

	private Cargo obtenerCargoPorCodCargo(String codCargo) {	
		Optional<Cargo> cargoOpt = this.cargodao.findById(codCargo);
		if (cargoOpt.isPresent())
			return cargoOpt.get();
		else 
			return null;
	}

	@Override
	public List<Cargo> findByCodCargo(String codCargo){
		Cargo cargo = this.obtenerCargoPorCodCargo(codCargo);
		return this.cargodao.findByCodCargoPadre(cargo);
	}

}
