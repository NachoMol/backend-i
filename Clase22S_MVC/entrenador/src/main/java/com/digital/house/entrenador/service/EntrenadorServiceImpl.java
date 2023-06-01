package com.digital.house.entrenador.service;


import com.digital.house.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{
    @Override
    public List<Entrenador> obtenerEntrenadores() {
        return Arrays.asList(new Entrenador("Claudio"),new Entrenador("Agustin"), new Entrenador("Ramiro"));
    }
}
