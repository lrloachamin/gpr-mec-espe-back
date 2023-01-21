package ec.edu.espe.gpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.CargoDocente;

public interface CargoDocenteDao extends JpaRepository<CargoDocente, Integer>{
    
}
