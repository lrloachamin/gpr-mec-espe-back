package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Proyecto;
import ec.edu.espe.gpr.services.ProyectoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping(path = "/proyecto")
@RequiredArgsConstructor
public class ProyectoRestController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping(path = "/listarProyectos")
    public ResponseEntity<List<Proyecto>> listarProyectos() {
        try {
            List<Proyecto> proyectos = this.proyectoService.listarProyectos();
            return ResponseEntity.ok(proyectos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Proyecto proyecto) {
        try {
            this.proyectoService.crear(proyecto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<Proyecto> modificar(@RequestBody Proyecto proyecto) {
        try {
            this.proyectoService.modificarDatos(proyecto);
            return ResponseEntity.ok(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/cambiarEstado/{codigoProyecto}")
    public ResponseEntity<String> cambiarEstado(@PathVariable Integer codigoProyecto) {
        try {
            this.proyectoService.cambiarEstadoProyecto(codigoProyecto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
