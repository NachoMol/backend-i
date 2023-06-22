package com.example.clase23.controller;

import com.example.clase23.dto.TurnoDTO;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> traerTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnoDTO){
        ResponseEntity<TurnoDTO> respuesta;
        //tratamiento
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPacientePorID(turnoDTO.getPacienteId());
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoPorId(turnoDTO.getOdontologoId());
        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turnoDTO));
        }
        else{
            //solo devolvemos el código bad request
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
}