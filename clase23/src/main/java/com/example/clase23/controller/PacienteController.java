package com.example.clase23.controller;

import com.example.clase23.model.Paciente;
import com.example.clase23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente, @PathVariable int id){
        return pacienteService.actualizarPaciente(paciente,id);
    }
}
