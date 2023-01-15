package ec.edu.espe.gpr.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;

public interface IDocenteDao extends JpaRepository<Docente, Integer> {
    Optional<Docente> findByCodigoDocente(Integer codigoDocente);
    Optional<Docente> findByCodigoUsuario(Usuario codigoUsuario);
    List<Docente> findByCodCargo(Cargo codCargo);
    Docente findByNombreDocente(String nombreDocente);
    Docente findByCorreoDocente(String nombreDocente);
}
