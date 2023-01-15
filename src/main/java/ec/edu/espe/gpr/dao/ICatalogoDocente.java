package ec.edu.espe.gpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import ec.edu.espe.gpr.model.CatalogoDocente;

public interface ICatalogoDocente extends JpaRepository<CatalogoDocente, String> {

}
