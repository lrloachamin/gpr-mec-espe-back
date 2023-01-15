package ec.edu.espe.gpr.services;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.ICargoDao;
import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;
import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;
import ec.edu.espe.gpr.response.DocenteResponseRest;




@Service
public class IDocenteServiceImpl implements IDocenteService  {
	
	@Autowired
	private IDocenteDao docenteDao;
	@Autowired
	private IUsuarioPerfilDao usuarioperfilDao;
	@Autowired
	private ICargoDao cargoDao;
	@Autowired
	private IUsuarioDao usuarioDao;
    @Autowired
	private IEmailService emservice;
	
	@Transactional
	@Override
	public ResponseEntity<DocenteResponseRest> save(Docente docente, String id) {
		
		PasswordEncoder passeconder;
		passeconder=new BCryptPasswordEncoder();
		// TODO Auto-generated method stub
		DocenteResponseRest response= new DocenteResponseRest();
		List<Docente> list= new ArrayList<>();
		try {
			Optional<Cargo> cargo=cargoDao.findById(id);
			if(cargo.isPresent()) {
				docente.setCodCargo(cargo.get());
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro la categoria");
				return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			Usuario usuario =new Usuario();
			Long idLoc=usuarioDao.count()+1;
			usuario.setCodigoUsuario(idLoc.intValue());
			String[] parts = docente.getApellidoDocente().split(" ");
			String nombreUsuario=(docente.getNombreDocente().substring(0,1).concat(parts[0])).toLowerCase();
			nombreUsuario=nombreUsuario.replace("ñ","n");
			
			
			nombreUsuario = Normalizer.normalize(nombreUsuario, Normalizer.Form.NFD);
			nombreUsuario = nombreUsuario.replaceAll("[^\\p{ASCII}]","");
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setPasswUsuario(passeconder.encode(docente.getCedulaDocente()));
			usuario.setFechaCreUsu(new Date());
			usuario.setFechaModUsuario(new Date());
			usuario.setEstadoUsuario('0');
			usuarioDao.save(usuario);
			
			Long idLocDoc=docenteDao.count()+1;
			
			docente.setCodigoDocente(idLocDoc.intValue());
			docente.setCodigoUsuario(usuario);
			Docente docentesave=docenteDao.save(docente);
			
			if(docentesave!=null) {
				
				
				list.add(docentesave);
				
				response.getDocenteResponse().setDocente(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				}else {
					response.setMetadata("Respuesta nok", "000", "Error docente no guardado");
					return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al guardar el docente");
			e.getStackTrace();
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<DocenteResponseRest> serach() {
		DocenteResponseRest response= new DocenteResponseRest();
		try {
			List<Docente> usuarioperfil= (List<Docente>) docenteDao.findAll();
			
			response.getDocenteResponse().setDocente(usuarioperfil);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<DocenteResponseRest> serachPorPerfil() {
		DocenteResponseRest response= new DocenteResponseRest();
		try {
			boolean bandera;
			List<Docente> usuarioperfil= (List<Docente>) docenteDao.findAll();
			
			List<Usuper> usuarioperfilP= (List<Usuper>) usuarioperfilDao.findAll();
			
			List<Docente> docentes=new ArrayList<>();
			for(Docente d: usuarioperfil) {
				bandera=false;
				
				for(Usuper up:usuarioperfilP) {
					if(up.getCodigoUsuario().getCodigoUsuario()==d.getCodigoUsuario().getCodigoUsuario()) {
						bandera=true;
						
					}
				}
				if(bandera!=true) {
					docentes.add(d);
				}	
				
			}
			
			response.getDocenteResponse().setDocente(docentes);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}
	
	

	@Override
	public ResponseEntity<DocenteResponseRest> buscarPorUsuario(String usuario) {
		DocenteResponseRest response= new DocenteResponseRest();
		try {
			List<Docente> usuarioperfil= (List<Docente>) docenteDao.findAll();
			List<Docente> docenteList= new ArrayList<>();
			for(Docente d: usuarioperfil) {
				if(d.getCodigoUsuario().getNombreUsuario().equals(usuario)){
					docenteList.add(d);
					response.getDocenteResponse().setDocente(docenteList);
					response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
					
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}



	@Override
	public ResponseEntity<DocenteResponseRest> buscarPorIDEspe(String idespe) {
		DocenteResponseRest response= new DocenteResponseRest();
		try {
			List<Docente> usuarioperfil= (List<Docente>) docenteDao.findAll();
			List<Docente> docenteList= new ArrayList<>();
			for(Docente d: usuarioperfil) {
				if(d.getCedulaDocente().equals(idespe)){
					docenteList.add(d);
					response.getDocenteResponse().setDocente(docenteList);
					response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
					
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DocenteResponseRest> update(Docente docente, Integer id) {
		DocenteResponseRest response= new DocenteResponseRest();

		List<Docente> list= new ArrayList<>();
		try {
			Optional<Docente> usuarioF=docenteDao.findById(id);
			if(usuarioF.isPresent()) {
				
				usuarioF.get().setCodigoDocente(docente.getCodigoDocente());
			    usuarioF.get().setIdDocente(docente.getIdDocente());
			    usuarioF.get().setNombreDocente(docente.getNombreDocente());
			    usuarioF.get().setApellidoDocente(docente.getApellidoDocente());
			    usuarioF.get().setCedulaDocente(docente.getCedulaDocente());
			    usuarioF.get().setTelefonoDocente(docente.getTelefonoDocente());
			    usuarioF.get().setCorreoDocente(docente.getCorreoDocente());
			    usuarioF.get().setSexo(docente.getSexo());
			    usuarioF.get().setPuestoTrabajoDocente(docente.getPuestoTrabajoDocente());
			    usuarioF.get().setCorreoDocente(docente.getCorreoDocente());
			    usuarioF.get().setCodCargo(docente.getCodCargo());

				
				
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el usuario");
				return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
	
			Docente usuuariosave=docenteDao.save(usuarioF.get());
			
			if(usuuariosave!=null) {
				
				list.add(usuuariosave);
				
				response.getDocenteResponse().setDocente(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				}else {
					response.setMetadata("Respuesta nok", "000", "Error usuario no guardado");
					return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al guardar el usuario");
			e.getStackTrace();
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public void resetearPassword(String email){
		PasswordEncoder passeconder = new BCryptPasswordEncoder();
		Docente docente = this.docenteDao.findByCorreoDocente(email);
		docente.getCodigoUsuario().setPasswUsuario(passeconder.encode(docente.getCedulaDocente()));
		docente.getCodigoUsuario().setFechaModUsuario(new Date());
		docente.getCodigoUsuario().setEstadoUsuario('2');
		this.usuarioDao.save(docente.getCodigoUsuario());
		emservice.enviarCorreo(docente.getCorreoDocente(), "GPR - Cambio de Contraseña: ",
							"Se ha solicitado el cambio de su contraseña, Su usuario es: "+docente.getCodigoUsuario().getNombreUsuario() + 
                            ", y su password:"+docente.getCedulaDocente());
		
	}


}

	
	

