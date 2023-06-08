package com.example.clase23.controller;

import com.example.clase23.model.Odontologo;
import com.example.clase23.model.Paciente;
import com.example.clase23.model.Turno;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //tratamiento
        Paciente pacienteBuscado=pacienteService.buscarPaciente(turno.getPaciente().getId());
        Odontologo odontologoBuscado=odontologoService.buscarOdontologo(turno.getOdontologo().getId());
        if (pacienteBuscado!=null && odontologoBuscado!=null){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            //solo devolvemos el código bad request
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
}
