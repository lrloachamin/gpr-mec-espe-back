package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.PerfilResponseRest;

import ec.edu.espe.gpr.services.IPerfilService;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class PerfilRestController {
	
	@Autowired
	private IPerfilService perfilservice;
	
	@GetMapping("/perfil")
	public ResponseEntity<PerfilResponseRest> searchPerfil(){
		try {
			ResponseEntity<PerfilResponseRest> responseEntity=perfilservice.findAll();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
	}

	@GetMapping(path = "/listarPerfiles")
    public ResponseEntity<List<Perfil>> listarPerfiles() {
        try {
            List<Perfil> perfiles = this.perfilservice.listarPerfiles();
            return ResponseEntity.ok(perfiles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
