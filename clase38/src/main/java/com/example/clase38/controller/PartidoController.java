package com.example.clase38.controller;

import com.example.clase38.entities.Partido;
import com.example.clase38.service.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    private PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }
    @PostMapping
    public ResponseEntity<Partido> agregarPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(partidoService.agregar(partido));
    }

    @GetMapping
    public ResponseEntity<List<Partido>> listarPartidos(){
        return ResponseEntity.ok(partidoService.listarPartidos());
    }

    @GetMapping("/en_vivo")
    public ResponseEntity<List<Partido>> listarPartidosEnVivo(){
        return ResponseEntity.ok(partidoService.listarPartidosEnVivo());
    }
}
