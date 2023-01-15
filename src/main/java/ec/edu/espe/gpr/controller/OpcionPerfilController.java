package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.espe.gpr.response.OpcionPerfilResponseRest;
import ec.edu.espe.gpr.services.IOpcionPerflService;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class OpcionPerfilController {
	
	@Autowired
	private IOpcionPerflService opcperservice;
	
	@GetMapping("/opcionperfil/{id}")
	public ResponseEntity<OpcionPerfilResponseRest> buscarUsuarios(@PathVariable String id){
		ResponseEntity<OpcionPerfilResponseRest> responseEntity=opcperservice.buscarOpcionPorPerfil(id);
		return responseEntity;
	}

}
