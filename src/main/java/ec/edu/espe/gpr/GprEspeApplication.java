package ec.edu.espe.gpr;

import java.io.FileInputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import ec.edu.espe.gpr.services.IEmailService;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GprEspeApplication {
	
	@Autowired
	private IEmailService emservice;
	
	

	public static void main(String[] args) {


		

		SpringApplication.run(GprEspeApplication.class, args);
		

		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendmail(){
		//emservice.enviarCorreo("lrloachamin@espe.edu.ec", "Mensaje confirmaicon", "body");
	}
	
		
	

}
