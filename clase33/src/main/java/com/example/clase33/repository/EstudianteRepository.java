package com.example.clase33.repository;

import com.example.clase33.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
