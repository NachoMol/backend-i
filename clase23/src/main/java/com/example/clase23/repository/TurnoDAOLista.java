package com.example.clase23.repository;

import com.example.clase23.entities.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TurnoDAOLista implements IDao<Turno> {
    private List<Turno>turnos;

    public TurnoDAOLista() {
        turnos = new ArrayList<>();
    }
    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        Turno turnoBuscado=null;
        for (Turno turno:turnos) {
            if (turno.getId()==id){
                turnoBuscado=turno;
            }
        }
        return turnoBuscado;
    }

    @Override
    public void actualizar(Turno turno) {
        eliminar(turno.getId());
        guardar(turno);
    }
    @Override
    public void eliminar(Integer id) {
        Turno turnoBuscado=buscar(id);
        turnos.remove(turnoBuscado);
    }
    @Override
    public List<Turno> listarTodos() {
        return turnos;
    }

    @Override
    public Turno buscarXString(String valor) {
        return null;
    }
}
