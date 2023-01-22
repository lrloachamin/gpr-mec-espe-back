package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.CargoDocente;
import ec.edu.espe.gpr.model.Docente;

public interface CargoDocenteDao extends JpaRepository<CargoDocente, Integer>{
    List<CargoDocente> findByCodigoDocente(Docente codigoDocente);
    List<CargoDocente> findByCodCargo(Cargo codCargo);
}
