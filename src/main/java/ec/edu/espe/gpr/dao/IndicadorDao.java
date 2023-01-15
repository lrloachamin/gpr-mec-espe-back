package ec.edu.espe.gpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Indicador;

public interface IndicadorDao extends JpaRepository<Indicador, Integer> {
    
}
