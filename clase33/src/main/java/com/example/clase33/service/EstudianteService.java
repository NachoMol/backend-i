package com.example.clase33.service;

import com.example.clase33.entities.Estudiante;
import com.example.clase33.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    private EstudianteRepository estudianteRepository;
    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
}
