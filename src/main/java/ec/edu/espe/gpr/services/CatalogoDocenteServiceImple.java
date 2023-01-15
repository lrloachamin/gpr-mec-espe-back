package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.ICatalogoDocente;
import ec.edu.espe.gpr.model.CatalogoDocente;
import ec.edu.espe.gpr.response.CatalogoDocenteResponseRest;

@Service
public class CatalogoDocenteServiceImple implements ICatalogoDocenteService {
	
	@Autowired
	private ICatalogoDocente catalagodocenteDao;

	@Override
	public ResponseEntity<CatalogoDocenteResponseRest> findById(String cedula) {
		CatalogoDocenteResponseRest response= new CatalogoDocenteResponseRest();
		try {
			List<CatalogoDocente> listacatalogo= new ArrayList<>();
			
			Optional<CatalogoDocente> category=catalagodocenteDao.findById(cedula);
			if(category.isPresent()) {
				listacatalogo.add(category.get());
				response.getDocenteResponse().setDocente(listacatalogo);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				
			}else {
				listacatalogo.add(new CatalogoDocente());
				response.getDocenteResponse().setDocente(listacatalogo);
				response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			}

		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<CatalogoDocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<CatalogoDocenteResponseRest>(response,HttpStatus.OK);
	}
	

}
