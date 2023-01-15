package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaIndicador;

public interface TareaIndicadorDao extends JpaRepository<TareaIndicador, Integer>{
    List<TareaIndicador> findByTareadocenteCODIGOTAREADOCENTE(TareaDocente tareadocenteCODIGOTAREADOCENTE);
}
