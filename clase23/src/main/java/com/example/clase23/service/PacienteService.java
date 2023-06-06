package com.example.clase23.service;

import com.example.clase23.dao.IDao;
import com.example.clase23.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }
    public Paciente buscarPacienteXEmail(String email){
        return pacienteIDao.buscarXString(email);
    }

    public Paciente guardarPaciente(Paciente paciente){ return pacienteIDao.guardar(paciente);}

    public Paciente actualizarPaciente(Paciente paciente, int id){return pacienteIDao.actualizar(paciente,id);}
}
