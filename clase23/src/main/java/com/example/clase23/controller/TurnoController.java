package com.example.clase23.controller;

import com.example.clase23.model.Odontologo;
import com.example.clase23.model.Paciente;
import com.example.clase23.model.Turno;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;



    @GetMapping
    public ResponseEntity<List<Turno>> traerTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PostMapping
    public ResponseEntity<?> registrarTurno(@RequestBody Turno turno){
         ResponseEntity<?> respuesta = null;
        //tratamiento
         Paciente pacienteBuscado=pacienteService.buscarPaciente(turno.getPaciente().getId());
         Odontologo odontologoBuscado=odontologoService.buscarOdontologo(turno.getOdontologo().getId());

        if (pacienteBuscado!=null && odontologoBuscado!=null){
           respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));


        }
        else{
            //solo devolvemos el código bad request
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).body(odontologoBuscado);
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        ResponseEntity respuesta;

        Turno turnoBuscado = turnoService.buscarTurno(turno.getId());

        if(turnoBuscado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable int id) {
        ResponseEntity<?> response;

        Turno turnoBuscado = turnoService.buscarTurno(id);

        if (turnoBuscado != null) {
            turnoService.eliminarTurno(id);
            response = ResponseEntity.ok().build();
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id no existe");
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable int id) {

        Turno turnoBuscado = turnoService.buscarTurno(id);

        if (turnoBuscado != null) {
            return ResponseEntity.ok(turnoBuscado);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }





}
