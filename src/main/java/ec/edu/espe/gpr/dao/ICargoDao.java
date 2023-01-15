package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Cargo;

public interface ICargoDao extends JpaRepository<Cargo, String>{
    List<Cargo> findByCodCargoPadre(Cargo codCargoPadre);
}