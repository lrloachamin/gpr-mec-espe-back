package ec.edu.espe.gpr.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.response.CargoResponseRest;

public interface ICargoService {
	public ResponseEntity<CargoResponseRest> find();
	public ResponseEntity<CargoResponseRest> findById(String codCargo);
	public ResponseEntity<CargoResponseRest> save(Cargo cargo);
	public List<Cargo> findAll();
	public List<Cargo> findByCodCargo(String codCargo);
}
