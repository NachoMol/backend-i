package com.example.clase23.controller;

import com.example.clase23.dto.TurnoDTO;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.exception.ResourceNotFoundException;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @PostMapping
    public ResponseEntity<TurnoDTO> guardarTurno(@RequestBody Turno turno){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(turno.getOdontologo().getId());
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPacientePorID(turno.getPaciente().getId());
        if(odontologoBuscado.isPresent()&&pacienteBuscado.isPresent()){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se elimino correctamente el turno solicitado con ID: "+id);
        }else{
            throw new ResourceNotFoundException("Existe el id asociado :"+id);
            //return ResponseEntity.badRequest().body("No existe el turno con ID: "+id);
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarPorID(turno.getId());
        if(turnoBuscado.isPresent()){
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok("Se actualizo correctamente el turno solicitado con ID: "+turno.getId());
        }else{
            return ResponseEntity.badRequest().body("No existe o no se puede actualizar el turno con ID: "+turno.getId());
        }
    }


}
