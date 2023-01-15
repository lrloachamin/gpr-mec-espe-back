package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;


import ec.edu.espe.gpr.response.CatalogoDocenteResponseRest;

public interface ICatalogoDocenteService {
	
	public ResponseEntity<CatalogoDocenteResponseRest> findById(String cedula);

}
