package com.example.clase23.service;


import com.example.clase23.controller.OdontologoController;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public Optional<Odontologo> buscarOdontologoPorId(Long id){
        return odontologoRepository.findById(id);
    }
    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public List<Odontologo> devolverOdontologos(){
        return odontologoRepository.findAll();
    }

}
