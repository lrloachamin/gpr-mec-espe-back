package ec.edu.espe.gpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.TipoProceso;

public interface ITipoProceso extends JpaRepository<TipoProceso, Integer> {
}