package com.example.clase23.dao;

import com.example.clase23.model.Domicilio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomicilioDAOH2 implements IDao<Domicilio>{
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscar(int id) {
        return null;
    }

    @Override
    public List<Domicilio> listarTodos() {
        return null;
    }

    @Override
    public Domicilio buscarXString(String valor) {
        return null;
    }
}
