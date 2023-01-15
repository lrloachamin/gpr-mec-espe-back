package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.espe.gpr.response.CatalogoDocenteResponseRest;
import ec.edu.espe.gpr.services.ICatalogoDocenteService;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class CatalagoDocenteController {
	@Autowired
	private ICatalogoDocenteService catalogodocenteservice;

	@GetMapping("/catalogodocente/{id}")
	public ResponseEntity<CatalogoDocenteResponseRest> buscarCargosID(@PathVariable String id){
		ResponseEntity<CatalogoDocenteResponseRest> responseEntity=catalogodocenteservice.findById(id);
		return responseEntity;
	}
	
}
