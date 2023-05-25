package test;

import bd.BD;
import dao.OdontologoDAOArrayList;
import dao.OdontologoDAOH2;
import dao.PacienteDAOH2;
import model.Odontologo;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

import java.util.List;

public class OdontologoServiceTest {

    @Test
    public void TestListarOdontologosH2OK(){

        //DADO
        BD.crearTablas();

        OdontologoService odontologoService= new OdontologoService(new OdontologoDAOH2());

        Odontologo odontologo1 = new Odontologo(1,"1234asd","Jorge","Test");
        Odontologo odontologo2 = new Odontologo(2,"12345asdf","Ignacio","Molina");
        odontologoService.altaOdontologo(odontologo1);
        odontologoService.altaOdontologo(odontologo2);
        //CUANDO
        List<Odontologo> odontologos= odontologoService.listarOdontologos();
        //ENTONCES
        Assertions.assertEquals(2,odontologos.size());
    }

    @Test
    public void TestListarOdontologosArrayListOK(){
        OdontologoService odontologoService= new OdontologoService(new OdontologoDAOArrayList());

        Odontologo odontologo1 = new Odontologo(1,"1234asd","Jorge","Test");
        Odontologo odontologo2 = new Odontologo(2,"12345asdf","Ignacio","Molina");
        odontologoService.altaOdontologo(odontologo1);
        odontologoService.altaOdontologo(odontologo2);
        //CUANDO
        List<Odontologo> odontologos= odontologoService.listarOdontologos();
        //ENTONCES
        Assertions.assertEquals(2,odontologos.size());
    }

}
