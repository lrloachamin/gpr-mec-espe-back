package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;



public interface IUsuarioService {
	
	public ResponseEntity<UsuarioResponseRest> search();
	public ResponseEntity<UsuarioResponseRest> login(String usuario,String pass);
	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario);
	public ResponseEntity<UsuarioResponseRest> update(Usuario usuario,Integer id);
	public Docente getDocentByCodeUser(Integer codeUser);

	
			

}
