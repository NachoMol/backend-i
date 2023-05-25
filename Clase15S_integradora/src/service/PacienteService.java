package service;

import dao.IDao;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }
    public Paciente altaPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarPaciente(int id){
        return pacienteIDao.buscar(id);
    }
    public void modificarPaciente(Paciente paciente){
         pacienteIDao.modificar(paciente);
    }
    public void eliminarPaciente(int id){
        pacienteIDao.eliminar(id);
    }
    public List<Paciente> listarPacientes(){
        return pacienteIDao.listar();
    }

}
