package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IPerfilDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;
import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;
import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;

@Service
public class UsuarioPerfilServiceImpl implements IUsuarioPerfilService {
	@Autowired
	private IUsuarioPerfilDao usuarioperfilDao;
	@Autowired
	private IUsuarioDao usuarioDao;
	@Autowired
	private IPerfilDao perfilDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioPerfilResponseRest> search() {
		UsuarioPerfilResponseRest response= new UsuarioPerfilResponseRest();
		try {
			List<Usuper> usuarioperfil= (List<Usuper>) usuarioperfilDao.findAll();
			
			response.getUsuarioPerfilResponse().setUsuarioPerfil(usuarioperfil);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<UsuarioPerfilResponseRest> save(String codigoperfil,Integer codigousuario, Integer codusuper) {
		UsuarioPerfilResponseRest response = new UsuarioPerfilResponseRest();
		List<Usuper> list= new ArrayList<>();
		try {
			
			Optional<Usuper> usuarioperfil=usuarioperfilDao.findById(codusuper);
			
			if(usuarioperfil.isPresent()) {
				
				list.add(usuarioperfil.get());
				response.getUsuarioPerfilResponse().setUsuarioPerfil(list); 
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa docente repetido");
				
			}else {
			
			Optional<Usuario> usuario=usuarioDao.findById(codigousuario);
			
			Usuper usuper= new Usuper();
		
			
			
			if(usuario.isPresent()) {
				usuper.setCodigoUsuario(usuario.get());

			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el usuario");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			Optional<Perfil> perfil=perfilDao.findById(codigoperfil);
			if(perfil.isPresent()) {
				usuper.setCodigoPerfil(perfil.get());
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el perfil");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			usuper.setFechaAsgUsuper(new Date());
			usuper.setFechRetiroUsuperOpcper(new Date());
			
			
			
			List<Usuper> usurioID=(List<Usuper>)usuarioperfilDao.findAll();
			
			System.out.println("no entra");
			List<Integer> listaCodigoUsuper = new ArrayList<Integer>();
			
			System.out.println("ndeclarar arrays");
			
			for(Usuper u :usurioID) {
			
				listaCodigoUsuper.add(u.getCodUsuper().intValue());
				
				
			}
		
			int idLocUsuPer=1;
			 boolean isEmpty = isEmpty(listaCodigoUsuper);
		        if (isEmpty) {
		        	idLocUsuPer=1;
		        	//usuper.setCodUsuper(Integer.toString(idLocUsuPer));
		        } else {
		        	idLocUsuPer=Collections.max(listaCodigoUsuper)+1;
					//usuper.setCodUsuper(Integer.toString(idLocUsuPer));
				
		        }
		    	Usuper usupersave=usuarioperfilDao.save(usuper);
		
			
			if(usupersave!=null) {
				list.add(usupersave);
				response.getUsuarioPerfilResponse().setUsuarioPerfil(list); 
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				
			}else {
				response.setMetadata("Respuesta nok", "000", "Error docente no guardado");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.BAD_REQUEST);
				
			}
		}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al el perfil del usuario");
			e.getStackTrace();
			
		}
		
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
	}

	public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
 
	
	@Override
	@Transactional
	public ResponseEntity<UsuarioPerfilResponseRest> delete(Integer idUsuPer, Integer codusuper) {
		UsuarioPerfilResponseRest response= new UsuarioPerfilResponseRest();
		
		try {
		
			Optional<Usuper> usuarioperfil=usuarioperfilDao.findById(codusuper);
			
			if(usuarioperfil.isPresent()) {
				usuarioperfilDao.deleteById(idUsuPer);
				response.setMetadata("Respuesta nok", "000", "Registro eliminado");
				
			}else {
				response.setMetadata("Respuesta nok", "000", "Registro no eliminado docente repetido");

				
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error eliminar por id");
			e.getStackTrace();
			
			
		}
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
	}

	private Usuario getUser(Integer codUser){
		Optional<Usuario> userOpt = this.usuarioDao.findById(codUser);
		if (userOpt.isPresent())
			return userOpt.get();
		else 
			return null;
	}


	@Override
	public Perfil obtenerPerfil(Integer codUser){
		Usuario usuario = this.getUser(codUser);
		List<Usuper> usupers = this.usuarioperfilDao.findByCodigoUsuario(usuario);
		return usupers.get(0).getCodigoPerfil();
	}
}