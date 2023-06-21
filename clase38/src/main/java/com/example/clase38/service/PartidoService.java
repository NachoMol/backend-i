package com.example.clase38.service;

import com.example.clase38.entities.Partido;
import com.example.clase38.repository.PartidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
    private PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }
    public Partido agregar(Partido partido){
        return partidoRepository.save(partido);
    }
}
