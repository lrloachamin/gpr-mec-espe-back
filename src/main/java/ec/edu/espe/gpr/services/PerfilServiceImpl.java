package ec.edu.espe.gpr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IPerfilDao;
import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.PerfilResponseRest;

@Service
public class PerfilServiceImpl implements IPerfilService {
	
	@Autowired
	private IPerfilDao perfilDao;
	



	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<PerfilResponseRest> findAll() {
		PerfilResponseRest response= new PerfilResponseRest();
		try {
			List<Perfil> usuarioperfil= (List<Perfil>) perfilDao.findAll();
			
			response.getPerfilResponse().setPerfil(usuarioperfil);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<PerfilResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<PerfilResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public List<Perfil> listarPerfiles() {
		return (List<Perfil>) perfilDao.findAll();
	}
}
