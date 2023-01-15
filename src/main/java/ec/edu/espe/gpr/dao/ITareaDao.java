package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Tarea;

public interface ITareaDao extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByIdDocenteRevisor(String idDocenteRevisor);
}