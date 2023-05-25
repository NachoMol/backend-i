package dao;

import bd.BD;
import model.Domicilio;
import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PacienteDAOH2 implements IDao<Paciente>{

    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_ONE="SELECT * FORM PACIENTES WHERE ID = ?";

    @Override
    public Paciente guardar(Paciente paciente) {



        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        try{
            connection = BD.getConnection();
            PreparedStatement ps_SelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            ps_SelectOne.setInt(1,id);
            ResultSet rsPaciente= ps_SelectOne.executeQuery();
            DomicilioDAOH2 domAux = new DomicilioDAOH2();
            while (rsPaciente.next()){
                domicilio = domAux.buscar(rsPaciente.getInt(6));
                paciente = new Paciente(rsPaciente.getInt(1),rsPaciente.getString(2),rsPaciente.getString(3),rsPaciente.getString(4),rsPaciente.getDate(5).toLocalDate(),domicilio);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            };
        }

        return paciente;
    }

    @Override
    public void eliminar(int i) {

    }

    @Override
    public void modificar(Paciente paciente) {

    }

    @Override
    public List<Paciente> listar() {

        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente = null;
        Domicilio domicilio = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psSelectAll=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            DomicilioDAOH2 domAux = new DomicilioDAOH2();
            while (rs.next()){
                domicilio = domAux.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
                pacientes.add(paciente);
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

        return pacientes;
    }
}
