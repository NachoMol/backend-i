package com.example.clase33.service;

import com.example.clase33.entities.Docente;
import com.example.clase33.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {
    private DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }
    public Docente guardarDocente(Docente docente){
        return docenteRepository.save(docente);
    }
    public List<Docente> listarAllDocentes(){
        return docenteRepository.findAll();
    }
    public void borrarDocente(Long id){
        docenteRepository.deleteById(id);
    }
}
