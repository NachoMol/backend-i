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
        ResponseEntity<Turno> response;

        Paciente pacienteBuscado = pacienteService.buscarPaciente(turno.getPaciente().getId());

        Odontologo odontologoBuscado = odontologoService.buscarOdongoloto(turno.getOdontologo().getId());

        if(pacienteBuscado!=null && odontologoBuscado!=null){
            response=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else{
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }



        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminarTurno(@PathVariable Integer id){
        ResponseEntity<Turno> response;

        Turno turnoBuscado = turnoService.buscarTurno(id);

        if(turnoBuscado!=null){
            turnoService.eliminarTurno(id);
            response = ResponseEntity.ok().build();
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(Turno turno){
        ResponseEntity<Turno> response;

        Turno turnoBuscado = turnoService.buscarTurno(turno.getId());

        if(turnoBuscado!=null){
            turnoService.actualizarTurno(turno);
            response = ResponseEntity.ok(turno);
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Integer id){

        Turno turnoBuscado = turnoService.buscarTurno(id);

        if(turnoBuscado!= null){
            return ResponseEntity.ok(turnoBuscado);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
