package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.IOpcionPerfilDao;
import ec.edu.espe.gpr.model.OpcPer;
import ec.edu.espe.gpr.response.OpcionPerfilResponseRest;

@Service
public class OpcionPerfilServiceImpl implements IOpcionPerflService {
	
	@Autowired
	private IOpcionPerfilDao opcionPerfildao;

	@Override
	public ResponseEntity<OpcionPerfilResponseRest> buscarOpcionPorPerfil(String idPerfil) {
		OpcionPerfilResponseRest response= new OpcionPerfilResponseRest();
		List<OpcPer> list= new ArrayList<>();
		try {
			List<OpcPer> opcperf= (List<OpcPer>) opcionPerfildao.findAll();
			
			for(OpcPer op : opcperf) {
				if(op.getCodigoPerfil().getCodigoPerfil().equals(idPerfil)) {
				
					list.add(op);
				}
			}
			
			System.out.println(opcperf.toString());
			
			response.getOpcionPerfilResponse().setOpcper(list);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar por id");
			e.getStackTrace();
			
			
		}
		return new ResponseEntity<OpcionPerfilResponseRest>(response,HttpStatus.OK);
	}

}
