package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.response.DocenteResponseRest;
import ec.edu.espe.gpr.services.IDocenteService;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class DocenteRestController {
	@Autowired
	private IDocenteService docenteservice;
	
	@GetMapping("/usuarionombre/{id}")
	public ResponseEntity<DocenteResponseRest> buscarUsuarios(@PathVariable String id){
		ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.buscarPorUsuario(id);
		return responseEntity;
	}
	@GetMapping("/usuarioid/{id}")
	public ResponseEntity<DocenteResponseRest> buscarporId(@PathVariable String id){
		ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.buscarPorIDEspe(id);
		return responseEntity;
	}
	
	@GetMapping("/docente")
	public ResponseEntity<DocenteResponseRest> searchUsuarios(){
		try {
			ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.serach();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
	}
	
	@GetMapping("/docentePerfilU")
	public ResponseEntity<DocenteResponseRest> buscarUsuarioPerfil(){
		try {
			ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.serachPorPerfil();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
	}
	
	@PostMapping("/docentes")
	public ResponseEntity<DocenteResponseRest> saveDocentes(
			
			@RequestParam("idDocente") String idDocente,
			@RequestParam("nombreDocente") String nombreDocente,
			@RequestParam("apellidoDocente") String apellidoDocente,
			@RequestParam("cedulaDocente")String cedulaDocente ,
			@RequestParam("telefonoDocente") String telefonoDocente,
			@RequestParam("correoDocente")String correoDocente ,
			@RequestParam("sexooDocente")String sexooDocente,
			@RequestParam("puestoDocente")String puestoDocente,
			@RequestParam("codCargo") String codCargo
	
			){
		
		Docente docente =new Docente();
		
		docente.setIdDocente(idDocente);
		docente.setNombreDocente(nombreDocente);
		docente.setApellidoDocente(apellidoDocente);
		docente.setCedulaDocente(cedulaDocente);
		docente.setTelefonoDocente(telefonoDocente);
		docente.setCorreoDocente(correoDocente);
		
		docente.setSexo(sexooDocente);
		docente.setPuestoTrabajoDocente(puestoDocente);
		System.out.println(docente.getSexo()+docente.getPuestoTrabajoDocente());
		
		
		ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.save(docente,codCargo);
		return responseEntity;
	}
	
	@PutMapping("/updatedocente/{id}")
	public ResponseEntity<DocenteResponseRest> updateCategories(@RequestBody Docente docente,@PathVariable Integer id){
		ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.update(docente, id);
		return responseEntity;
	}
	
	@PutMapping("/resetearPassword")
	public ResponseEntity<String> resetearPassword(@RequestBody String email){
		try {
            this.docenteservice.resetearPassword(email);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
	}
	
}
