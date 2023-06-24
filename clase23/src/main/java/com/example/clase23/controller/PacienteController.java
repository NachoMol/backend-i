package com.example.clase23.controller;

import com.example.clase23.entities.Paciente;
import com.example.clase23.exception.BadRequestException;
import com.example.clase23.exception.ResourceNotFoundException;
import com.example.clase23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger= Logger.getLogger(PacienteController.class);
   @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente){
        logger.info("Procesando solicitud de agregar paciente");
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) throws BadRequestException{
        logger.info("Procesando solicitud de buscar paciente");
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPacientePorID(id);
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }else{
            logger.error("Falló la solicitud de buscar paciente");
            throw new BadRequestException("Paciente no encontrado");
        }


    }

    @GetMapping("/{correo}")
    public ResponseEntity<Paciente> buscarPacientePorCorreo(@PathVariable String correo) throws ResourceNotFoundException{
        logger.info("Procesando solicitud de buscar paciente por correo");
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPacientePorCorreo(correo);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }else{
            logger.error("Falló la solicitud de buscar paciente por correo");
            throw new ResourceNotFoundException("No existe el correo asociado en la base de datos.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        logger.info("Procesando solicitud de listar pacientes");
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @PutMapping
    public ResponseEntity<String> modificarPaciente(@RequestBody Paciente paciente) throws ResourceNotFoundException{
        logger.info("Procesando solicitud de modificar paciente");
        //vamos a consultar si ese paciente existe
        Optional<Paciente> pacientebuscado= pacienteService.buscarPacientePorID(paciente.getId());
        if(pacientebuscado.isPresent()){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("Paciente Actualizado -"+paciente.getNombre()+" "+paciente.getApellido());
        }
        else{
            logger.error("Falló la solicitud de modificar paciente");
            throw new ResourceNotFoundException("Paciente No Encontrado: "+ "Id: " + paciente.getId()+ "Nombre: "+paciente.getNombre());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable long id) throws ResourceNotFoundException {
        logger.info("Procesando solicitud de eliminar paciente");
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacientePorID(id);

        if(pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se elimino correctamente el paciente");
        }else{
            logger.error("Falló la solicitud de eliminar paciente");
            throw new ResourceNotFoundException("No existe el id asociado en la base de datos" + id);
        }
    }
}
