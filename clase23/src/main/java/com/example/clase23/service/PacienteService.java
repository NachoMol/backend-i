package com.example.clase23.service;

import com.example.clase23.repository.IDao;
import com.example.clase23.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private IDao<Paciente> pacienteIDao;

    public Paciente buscarPacienteXEmail(String email){
        return pacienteIDao.buscarXString(email);
    }
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }
    public void actualizarPaciente(Paciente paciente){
        pacienteIDao.actualizar(paciente);
    }
}
