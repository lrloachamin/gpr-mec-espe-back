package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDao usuarioDao;
	@Autowired
	private IEmailService emservice;
	@Autowired
	private IDocenteDao docentedao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> search() {
		UsuarioResponseRest response = new UsuarioResponseRest();
		try {
			List<Usuario> category = (List<Usuario>) usuarioDao.findAll();

			response.getCategoryResponse().setCategory(category);
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			System.out.println("Entra");

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> login(String usuario, String pass) {
		PasswordEncoder passeconder;
		passeconder = new BCryptPasswordEncoder();
		UsuarioResponseRest response = new UsuarioResponseRest();
		System.out.println(pass);
		try {
			List<Usuario> category = (List<Usuario>) usuarioDao.findAll();

			Usuario user = new Usuario();
			List<Usuario> userLogin = new ArrayList<>();

			for (Usuario u : category) {
				if (usuario.equals(u.getNombreUsuario()) && passeconder.matches(pass, u.getPasswUsuario())) {
					user = u;
				}

			}
			userLogin.add(user);
			response.getCategoryResponse().setCategory(userLogin);
			response.getCategoryResponse().setCategory(userLogin);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			System.out.println(usuario);
			System.out.println(pass);

		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioResponseRest> update(Usuario usuario, Integer id) {
		UsuarioResponseRest response = new UsuarioResponseRest();
		PasswordEncoder passeconder;
		passeconder = new BCryptPasswordEncoder();
		List<Usuario> list = new ArrayList<>();
		try {
			Optional<Usuario> usuarioF = usuarioDao.findById(id);
			Character estadoUsuario = '9';
			if (usuarioF.isPresent()) {
				estadoUsuario = usuarioF.get().getEstadoUsuario();
				usuarioF.get().setNombreUsuario(usuario.getNombreUsuario());
				System.out.println("estado:"+estadoUsuario);
				if (estadoUsuario == '2') {
					usuarioF.get().setPasswUsuario(passeconder.encode(usuario.getPasswUsuario()));
				}
				usuarioF.get().setFechaCreUsu(usuario.getFechaCreUsu());
				usuarioF.get().setFechaModUsuario(usuario.getFechaModUsuario());
				usuarioF.get().setEstadoUsuario(usuario.getEstadoUsuario());

			} else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el usuario");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);

			}

			Usuario usuuariosave = usuarioDao.save(usuarioF.get());
			String correo = "";
			String password2 = "";

			if (usuuariosave != null) {
				for (Docente d : usuarioF.get().getDocenteList()) {
					correo = d.getCorreoDocente();
					password2 = d.getCedulaDocente();

				}

				list.add(usuuariosave);

				response.getCategoryResponse().setCategory(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				System.out.println("s" + estadoUsuario);

				if (estadoUsuario == '0') {
					emservice.enviarCorreo(correo, "GPR - Registro completo",
							"Bienvenido el administrador a aceptado su solicitud, sus credenciales de ingreso son las siguientes: Su usuario es "
									+ usuarioF.get().getNombreUsuario() + " y su contraseña es " + password2);

				}

			} else {
				response.setMetadata("Respuesta nok", "000", "Error usuario no guardado");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al guardar el usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	public Usuario getUserByCOdeUser(Integer codeUser) {
		Optional<Usuario> user = this.usuarioDao.findById(codeUser);
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	public Docente getDocentByCodeUserSearch(Integer codeUser) {
		Usuario user = getUserByCOdeUser(codeUser);
		Optional<Docente> docenteOpt = this.docentedao.findByCodigoUsuario(user);
		if (docenteOpt.isPresent())
			return docenteOpt.get();
		else
			return null;
	}

	@Override
	public Docente getDocentByCodeUser(Integer codeUser) {
		Docente docente = this.getDocentByCodeUserSearch(codeUser);
		if(docente.getNumLogueo()==null)
			docente.setNumLogueo(0);
		docente.setNumLogueo(docente.getNumLogueo()+1);
		docente = this.docentedao.save(docente);
		return docente;
	}

}
