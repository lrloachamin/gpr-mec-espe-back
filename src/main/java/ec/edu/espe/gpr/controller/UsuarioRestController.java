package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;
import ec.edu.espe.gpr.services.IUsuarioService;

//@CrossOrigin(origins= {"http://localhost:4200"})
@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;
	

	
	/**
	 * 
	 * Obtener todas las usuarios del sistema gpr 
	 */
	
	@GetMapping("/usuario")
	public ResponseEntity<UsuarioResponseRest> searchUsuarios(){
		try {
			ResponseEntity<UsuarioResponseRest> responseEntity=usuarioService.search();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
		
		
	}
	@GetMapping("/login/{user}/{pass}")
	public ResponseEntity<UsuarioResponseRest> login(@PathVariable String user,@PathVariable String pass){
		try {
			ResponseEntity<UsuarioResponseRest> responseEntity=usuarioService.login(user, pass);
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
		
		
	}

	@GetMapping("/obtenerDocente/{codeUser}")
	public ResponseEntity<Docente> obtenerDocente(@PathVariable Integer codeUser){
		try {
			Docente docente=usuarioService.getDocentByCodeUser(codeUser);
			return ResponseEntity.ok(docente);
		}catch(Exception c) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioResponseRest> updateCategories(@RequestBody Usuario usuario,@PathVariable Integer id){
		ResponseEntity<UsuarioResponseRest> responseEntity=usuarioService.update(usuario, id);
		return responseEntity;
	}
	
	
}

