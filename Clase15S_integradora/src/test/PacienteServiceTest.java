package test;

import bd.BD;
import dao.IDao;
import dao.PacienteDAOH2;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.List;

public class PacienteServiceTest {

    @Test
    public void TestBuscarTodosOK(){
        //DADO
        BD.crearTablas();
        PacienteService pacienteService = new PacienteService(new PacienteDAOH2());

        //CUANDO
        List<Paciente> pacientes = pacienteService.listarPacientes();

        //ENTONCES
        Assertions.assertEquals(2,pacientes.size());
    }

    @Test
    public void testBuscar(){
        BD.crearTablas();
        PacienteService pacienteService = new PacienteService(new PacienteDAOH2());

        Integer idABuscar = 2;

        Paciente paciente = pacienteService.buscarPaciente(idABuscar);

        Assertions.assertTrue(paciente!=null);

    }


}
