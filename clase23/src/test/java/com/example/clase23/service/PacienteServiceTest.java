package com.example.clase23.service;

import com.example.clase23.entities.Domicilio;
import com.example.clase23.entities.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    @Test
    @Order(1)
    void guardarPaciente(){
        Paciente pacienteAGuardar= new Paciente("TestPaciente","Test","111111", LocalDate.of(2023,06,28),
                new Domicilio("Calle 1","123","La Boca","CABA"),"testPaciente@gmail.com");
        Paciente pacienteGuardado= pacienteService.guardarPaciente(pacienteAGuardar);
        assertEquals(1L,pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    void buscarPaciente(){
        Long idABuscar=1L;
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPacientePorID(idABuscar);
        assertTrue(pacienteBuscado.isPresent());
    }

    @Test
    @Order(3)
    void actualizarPaciente(){
        Long idABuscar=1L;
        Paciente pacienteAActualizar= new Paciente("TestPaciente","Test","111111", LocalDate.of(2023,06,28),
                new Domicilio("Calle 1","123","La Boca","CABA"),"testPaciente@gmail.com");
        pacienteAActualizar.setId(idABuscar);
        pacienteService.actualizarPaciente(pacienteAActualizar);
        assertEquals("Test",pacienteService.buscarPacientePorID(1L).get().getApellido());
    }

    @Test
    @Order(4)
    void listarTodosPacientes(){
        //agregar otros
        List<Paciente> listaEncontrada= pacienteService.listarPacientes();
        assertEquals(1,listaEncontrada.size());
    }

    @Test
    @Order(5)
    void eliminarPaciente(){
        Long idAEliminar=1L;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminado= pacienteService.buscarPacientePorID(idAEliminar);
        assertFalse(pacienteEliminado.isPresent());
    }


}