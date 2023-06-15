package com.dh.DirectoresYJugadores.service;

import com.dh.DirectoresYJugadores.entities.DirectorTecnico;
import com.dh.DirectoresYJugadores.repository.DirectorTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorTecnicoService {
    @Autowired
    private DirectorTecnicoRepository directorTecnicoRepository;
    public DirectorTecnico guardarTecnico(DirectorTecnico directorTecnico){
        return directorTecnicoRepository.save(directorTecnico);
    }
    public List<DirectorTecnico> buscarPorEdadMayorA(Integer edad){
        return directorTecnicoRepository.findByEdadGreaterThan(edad);
    }
    public Optional<DirectorTecnico> buscarPorNombre(String nombre){
        return directorTecnicoRepository.buscarTecnicoPorNombre(nombre);
    }
}
