package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;


public interface IUsuarioPerfilService {
	public ResponseEntity<UsuarioPerfilResponseRest> search();
	public ResponseEntity<UsuarioPerfilResponseRest> save(String codigoperfil,Integer codigousuario , Integer codusuper);
	public ResponseEntity<UsuarioPerfilResponseRest> delete(Integer idUsuPer,Integer codusuper );
	public Perfil obtenerPerfil(Integer codUser);
}
