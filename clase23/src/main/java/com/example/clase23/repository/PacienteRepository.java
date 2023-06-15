package com.example.clase23.repository;

import com.example.clase23.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByEmail(String email);
}
