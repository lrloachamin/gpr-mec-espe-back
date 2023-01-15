package ec.edu.espe.gpr.dao;


import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Perfil;

public interface IPerfilDao extends CrudRepository<Perfil, String> {
}
