package com.dh.DirectoresYJugadores.controller;

import com.dh.DirectoresYJugadores.entities.DirectorTecnico;
import com.dh.DirectoresYJugadores.service.DirectorTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directores")
public class DirectorTecnicoController {
    @Autowired
    private DirectorTecnicoService directorTecnicoService;
    @GetMapping("/{nombre}")
    public ResponseEntity<DirectorTecnico> buscarTecnicoPorNombre(@PathVariable String nombre) {
        Optional<DirectorTecnico> tecnicoBuscado = directorTecnicoService.buscarPorNombre(nombre);
        if (tecnicoBuscado.isPresent()) {
            return ResponseEntity.ok(tecnicoBuscado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/mayor/{edad}")
    public ResponseEntity<List<DirectorTecnico>> buscarTecnicosMayoresQue(@PathVariable Integer edad){
        return ResponseEntity.ok(directorTecnicoService.buscarPorEdadMayorA(edad));
    }
    @PostMapping
    public ResponseEntity<DirectorTecnico> guardarTecnico(@RequestBody DirectorTecnico directorTecnico){
        return ResponseEntity.ok(directorTecnicoService.guardarTecnico(directorTecnico));
    }
}
