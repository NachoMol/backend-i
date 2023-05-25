package service;

import dao.IDao;
import model.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente altaPaciente(Paciente p){
        return pacienteIDao.guardar(p);
    }

    public Paciente buscarPaciente(int id){
        return pacienteIDao.buscar(id);
    }

    public void modificarPaciente(Paciente p){
        pacienteIDao.modificar(p);
    }

    public void eliminarPaciente (int id){
        pacienteIDao.eliminar(id);
    }

    public List<Paciente> listarPaciente(){
        return pacienteIDao.listar();
    }

}
