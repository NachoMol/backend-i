package com.example.clase33.controller;

import com.example.clase33.entities.Docente;
import com.example.clase33.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocenteController {
    private DocenteService docenteService;

    @Autowired
    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }
    @PostMapping
    public ResponseEntity<Docente> registrarDocente(@RequestBody Docente docente){
        return ResponseEntity.ok(docenteService.guardarDocente(docente));
    }
    @GetMapping
    public ResponseEntity<List<Docente>> listarDocentes(){
        return ResponseEntity.ok(docenteService.listarAllDocentes());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDocente(@PathVariable Long id){
        docenteService.borrarDocente(id);
        return ResponseEntity.ok("Se eliminó al docente con id="+id);
    }
}
