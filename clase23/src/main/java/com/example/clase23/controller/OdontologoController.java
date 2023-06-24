package com.example.clase23.controller;

import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.exception.ResourceNotFoundException;
import com.example.clase23.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger logger= Logger.getLogger(OdontologoController.class);

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        logger.info("Procesando solicitud de agregar Odontologo");
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Procesando solicitud de buscar odontologo");
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologoPorId(id);

        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }else{
            logger.error("Falló la solicitud de buscar odontologo");
            throw new ResourceNotFoundException("No existe el id asociado en la base de datos. Id: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        logger.info("Procesando solicitud de listar odontologos");
        return ResponseEntity.ok(odontologoService.devolverOdontologos());
    }

    @PutMapping
    public ResponseEntity<String> modificarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        //vamos a consultar si ese paciente existe
        logger.info("Procesando solicitud de modificar odontologos");
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoPorId(odontologo.getId());
        if (odontologoBuscado.isPresent()) {
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok("Odontologo Actualizado -" + odontologo.getNombre() + " " + odontologo.getApellido());
        } else {
            logger.error("Falló la solicitud de modificar odontologo");
            throw new ResourceNotFoundException("No existe el id asociado en la base de datos. Id: " + odontologo.getId());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("Procesando solicitud de eliminar odontologo");
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoPorId(id);
                if (odontologoBuscado.isPresent()){
                    odontologoService.eliminarOdontologo(id);
                    return ResponseEntity.ok().build();
                }else{
                 logger.error("Falló la solicitud de eliminar odontologo");
                 throw new ResourceNotFoundException("No existe el id asociado en la base de datos. Id: " + id);
                }
    }
}
