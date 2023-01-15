package ec.edu.espe.gpr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Prueba {
	/*@Autowired
	private IUsuarioService usuarioService;*/
	

	@GetMapping("/prueba")
	public String prueba(){

		return "Prueba 3";
	}
	
	

}
