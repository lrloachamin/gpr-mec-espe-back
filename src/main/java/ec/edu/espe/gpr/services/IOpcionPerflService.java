package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;


import ec.edu.espe.gpr.response.OpcionPerfilResponseRest;

public interface IOpcionPerflService {
	
	public ResponseEntity<OpcionPerfilResponseRest> buscarOpcionPorPerfil(String idPerfil);

}
