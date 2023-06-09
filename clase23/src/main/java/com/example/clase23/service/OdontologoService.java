package com.example.clase23.service;

import com.example.clase23.repository.IDao;
import com.example.clase23.model.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    private IDao<Odontologo> odontologoIDao;

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
    public Odontologo buscarOdontologo(Integer id){
        return odontologoIDao.buscar(id);
    }
    public List<Odontologo> listadoOdontologos(){
        return odontologoIDao.listarTodos();
    }
}
