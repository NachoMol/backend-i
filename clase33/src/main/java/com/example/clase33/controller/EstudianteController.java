package com.example.clase33.controller;

import com.example.clase33.entities.Estudiante;
import com.example.clase33.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;
    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }
    @PostMapping
    public ResponseEntity<Estudiante> registrarEstudiante(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteService.guardarEstudiante(estudiante));
    }
}
