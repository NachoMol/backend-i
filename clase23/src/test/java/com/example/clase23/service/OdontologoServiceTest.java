package com.example.clase23.service;

import com.example.clase23.entities.Odontologo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;

    @Test
    @Order(1)
    void guardarOdontologo(){
        Odontologo odontologoAGuardar= new Odontologo("Juan","Muelas","MP541");
        Odontologo odontologoGuardado= odontologoService.guardarOdontologo(odontologoAGuardar);
        assertEquals(1L,odontologoGuardado.getId());
    }

    @Test
    @Order(2)
    void buscarOdontologo(){
        Long idABuscar=1L;
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoPorId(idABuscar);
        assertTrue(odontologoBuscado.isPresent());
    }

    @Test
    @Order(3)
    void actualizarOdontologo(){
        Odontologo odontologoAActualizar= new Odontologo("TestOdontologo","Test","123");
        odontologoService.actualizarOdontologo(odontologoAActualizar);
        assertEquals("Caries",odontologoService.buscarOdontologoPorId(1L).get().getApellido());
    }

    @Test
    @Order(4)
    void buscarTodosOdontologos(){
        //agregar otros
        List<Odontologo> listaEncontrada= odontologoService.devolverOdontologos();
        assertEquals(1,listaEncontrada.size());
    }

    @Test
    @Order(5)
    void eliminarOdontologo(){
        Long idAEliminar=1L;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoEliminado= odontologoService.buscarOdontologoPorId(idAEliminar);
        assertFalse(odontologoEliminado.isPresent());
    }


}