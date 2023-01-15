package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.response.DocenteResponseRest;


public interface IDocenteService {
	public ResponseEntity<DocenteResponseRest> serach();
	public ResponseEntity<DocenteResponseRest> save(Docente docente, String id);
	public ResponseEntity<DocenteResponseRest> buscarPorIDEspe(String idespe);
	public ResponseEntity<DocenteResponseRest> buscarPorUsuario(String usuario);
	public ResponseEntity<DocenteResponseRest> update(Docente docente, Integer id);
	public ResponseEntity<DocenteResponseRest> serachPorPerfil();
	public void resetearPassword(String email);
}
