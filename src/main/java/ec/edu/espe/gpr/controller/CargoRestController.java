package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.response.CargoResponseRest;
import ec.edu.espe.gpr.services.ICargoService;


@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class CargoRestController {
	@Autowired
	private ICargoService cargoservice;

	@GetMapping("/cargos")
	public ResponseEntity<CargoResponseRest> buscarcargos(){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.find();
		return responseEntity;
	}

	
	@GetMapping("/cargos/{id}")
	public ResponseEntity<CargoResponseRest> buscarCargosID(@PathVariable String id){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.findById(id);
		return responseEntity;
	}
	

	
	@PostMapping("/cargos")
	public ResponseEntity<CargoResponseRest> saveCargos(@RequestBody Cargo cargo){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.save(cargo);
		return responseEntity;
	}

	@GetMapping("/cargoModel")
	public ResponseEntity<List<Cargo>> buscarCargosModel(){
		try {
            List<Cargo> cargos = this.cargoservice.findAll();
            return ResponseEntity.ok(cargos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
	}

	@GetMapping("/obtenerCargosPorCodCargo/{codCargo}")
	public ResponseEntity<List<Cargo>> obtenerCargosPorPerfil(@PathVariable String codCargo){
		try {
            List<Cargo> cargos = this.cargoservice.findByCodCargo(codCargo);
            return ResponseEntity.ok(cargos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
	}
}
