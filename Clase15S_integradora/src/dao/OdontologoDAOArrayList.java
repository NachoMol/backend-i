package dao;

import bd.BD;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArrayList implements IDao<Odontologo>{

    private static final Logger LOGGER= Logger.getLogger(OdontologoDAOArrayList.class);
    List<Odontologo> odontologos= new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        try {
            LOGGER.debug("ingresamos al metodo listar de Odontologo en OdontologoDAOArrayList");
            odontologos.add(odontologo);


        } catch (Exception e) {
            e.printStackTrace();


        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public void modificar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> listar() {

        try {
            LOGGER.debug("ingresamos al metodo listar de Odontologo en OdontologoDAOArrayList");

        } catch (Exception e) {
            e.printStackTrace();


        }
        return odontologos;
    }
}
