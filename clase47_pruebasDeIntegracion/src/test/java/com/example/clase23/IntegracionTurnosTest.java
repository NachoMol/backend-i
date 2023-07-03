package com.example.clase23;

import com.example.clase23.dto.TurnoDTO;
import com.example.clase23.entities.Domicilio;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    //necesito cargar los datos iniciales
    public void cargadorDeDatos(){
        Paciente pacienteAgregado= pacienteService.guardarPaciente(new Paciente("Jorgito","Pereyra","111111", LocalDate.of(2023,06,28),
                new Domicilio("Calle 1","1223","La Rioja","La Rioja"),"jorgito@digitalhouse.com"));
        Odontologo odontologoAgregado= odontologoService.guardarOdontologo(new Odontologo("Guillermo","Gardella","MP30"));
        TurnoDTO turnoAgregado= turnoService.guardarTurno(new Turno(pacienteAgregado,odontologoAgregado,LocalDate.of(2023,07,20)));
    }
    @Test
    public void listarTurnosTest() throws Exception{
        cargadorDeDatos();
        MvcResult resultado=mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
       assertFalse(resultado.getResponse().getContentAsString().isEmpty());

    }
}
