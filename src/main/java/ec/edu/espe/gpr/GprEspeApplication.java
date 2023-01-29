package ec.edu.espe.gpr;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;


import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.services.FileService;
import ec.edu.espe.gpr.services.IEmailService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GprEspeApplication {
	
	@Autowired
	private IEmailService emservice;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	

	public static void main(String[] args) {

		
		
		SpringApplication.run(GprEspeApplication.class, args);
		

		
	}
	
	
	@Bean
	CommandLineRunner init(FileService fileService) {
		return (args) -> {
			fileService.deleteAllFileGuia();
			fileService.deleteAll();
			fileService.init();
			fileService.initFileGuia();
		};
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendmail(){
		
		
		
		//emservice.enviarCorreo("lrloachamin@espe.edu.ec", "Mensaje confirmaicon", "body");
	}
	
		
	

}
