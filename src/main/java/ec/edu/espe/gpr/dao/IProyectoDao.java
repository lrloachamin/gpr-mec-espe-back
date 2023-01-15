package ec.edu.espe.gpr.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Proyecto;

public interface IProyectoDao extends JpaRepository<Proyecto, Integer> {
}