package com.example.clase23.controller;

import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.exception.ResourceNotFoundException;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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
        return ResponseEntity.ok(turnoService.devolverTurnos());
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //tratamiento
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPacientePorID(turno.getId());
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());
        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            //solo devolvemos el código bad request
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @DeleteMapping("/{id")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Turno> turnoBuscado= turnoService.buscarTurnoPorId(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok("Se elimino el turno corrrectamente con id: " + id);
        }else{
            throw new ResourceNotFoundException("No existe el id asociado en la base de datos" + id);
        }
    }

}