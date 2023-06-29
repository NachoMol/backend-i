package com.example.clase23;

import com.example.clase23.controller.OdontologoController;
import com.example.clase23.controller.PacienteController;
import com.example.clase23.controller.TurnoController;
import com.example.clase23.entities.Domicilio;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.repository.OdontologoRepository;
import com.example.clase23.service.OdontologoService;
import com.example.clase23.service.PacienteService;
import com.example.clase23.service.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Clase23Application {



	public static void main(String[] args) {
		SpringApplication.run(Clase23Application.class, args);
	}

}
