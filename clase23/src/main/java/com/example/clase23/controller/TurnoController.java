package com.example.clase23.controller;

import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.exception.BadRequestException;
import com.example.clase23.exception.ResourceNotFoundException;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger logger= Logger.getLogger(TurnoController.class);
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        logger.info("Procesando solicitud de listar turnos");
        return ResponseEntity.ok(turnoService.devolverTurnos());
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        logger.info("Procesando solicitud de registrar un turno");

        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacientePorID(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());

        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()) {
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        } else {
            logger.error("Falló la solicitud de registrar un turno");
            throw new BadRequestException("No existe el id asociado en la base de datos");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Procesando solicitud de eliminar un turno");
        Optional<Turno> turnoBuscado= turnoService.buscarTurnoPorId(id);
        if(turnoBuscado.isPresent()){
            turnoService.eliminarTurno(turnoBuscado.get().getId());
            return ResponseEntity.ok("Se elimino el turno corrrectamente con id: " + id);
        }else{
            logger.error("Falló la solicitud de eliminar un turno");
            throw new ResourceNotFoundException("No existe el id asociado en la base de datos" + id);
        }
    }

}