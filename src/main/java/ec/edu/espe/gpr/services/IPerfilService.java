package ec.edu.espe.gpr.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.PerfilResponseRest;

public interface IPerfilService {
	
	public ResponseEntity<PerfilResponseRest> findAll();
	public List<Perfil> listarPerfiles();
}
