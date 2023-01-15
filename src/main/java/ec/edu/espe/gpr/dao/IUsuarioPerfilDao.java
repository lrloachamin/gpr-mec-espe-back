package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;

public interface IUsuarioPerfilDao extends CrudRepository<Usuper, Integer>{
    List<Usuper> findByCodigoUsuario(Usuario codigoUsuario);
    List<Usuper> findByCodigoPerfil(Perfil codigoPerfil);
}
