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
    public String actualizarPaciente(@RequestBody Paciente paciente, @PathVariable int id){
        Paciente pacientebuscado = pacienteService.buscarPaciente(paciente.getId());
        if(pacientebuscado!=null){
            pacienteService.actualizarPaciente(paciente,id);
        }
        return "Paciente Actualizado"+" -"+paciente.getNombre()+" "+paciente.getApellido();
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable int id){
        return pacienteService.buscarPaciente(id);
    }

}
