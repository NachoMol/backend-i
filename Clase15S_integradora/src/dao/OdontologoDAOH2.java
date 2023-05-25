package dao;

import bd.BD;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo>{

    private static final Logger LOGGER= Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_INSERT_ODONTOLOGOS = "INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.debug("ingresamos al metodo guardar de Odontologo en OdontologoDaoH2");
        Connection connection= null;

        try {

            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ODONTOLOGOS);

            preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setString(4, odontologo.getNumeroMatricula());

            preparedStatement.execute();



        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
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
        LOGGER.debug("ingresamos al metodo listar de Odontologo en OdontologoDaoH2");
        Connection connection=null;
        List<Odontologo> odontologos= new ArrayList<>();
        Odontologo odontologo=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectAll= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            while (rs.next()){
                odontologo= new Odontologo(rs.getString(1),rs.getString(2),rs.getString(3));
                odontologos.add(odontologo);

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

    }
