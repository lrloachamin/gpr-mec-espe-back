package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.TipoProceso;

public interface ITipoProceso extends JpaRepository<TipoProceso, Integer> {
    List<TipoProceso> findByEstadoTipoProceso(String estadoTipoProceso);
}