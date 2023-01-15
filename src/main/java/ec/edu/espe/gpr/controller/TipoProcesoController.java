package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.TipoProceso;
import ec.edu.espe.gpr.services.TipoProcesoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping(path = "/tipoProceso")
@RequiredArgsConstructor
public class TipoProcesoController {
    @Autowired
    private TipoProcesoService tipoProcesoService;

    @GetMapping(path = "/listarTiposProcesos")
    public ResponseEntity<List<TipoProceso>> listarTiposProcesos() {
        try {
            List<TipoProceso> tipoProcesos = this.tipoProcesoService.listarTiposProcesos();
            return ResponseEntity.ok(tipoProcesos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody TipoProceso tipoProceso) {
        try {
            this.tipoProcesoService.crear(tipoProceso);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<TipoProceso> modificar(@RequestBody TipoProceso tipoProceso) {
        try {
            this.tipoProcesoService.modificarDatos(tipoProceso);
            return ResponseEntity.ok(tipoProceso);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
