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

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable int id){
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        Paciente pacientebuscado = pacienteService.buscarPaciente(paciente.getId());
        if(pacientebuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "Paciente Actualizado"+" -"+paciente.getNombre()+" "+paciente.getApellido();
        }else{
            return "Paciente no encontrado: "+paciente.getId();
        }
    }
}
