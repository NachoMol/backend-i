package service;

import dao.IDao;
import model.Odontologo;
import model.Paciente;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo altaOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.listar();
    }



}
