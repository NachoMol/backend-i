package com.example.clase23.service;

import com.example.clase23.dao.IDao;
import com.example.clase23.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno guardarTurno(Turno turno){
        return turnoIDao.guardar(turno);
    }

    public List<Turno> listarTurnos(){
        return turnoIDao.listarTodos();
    }
}
