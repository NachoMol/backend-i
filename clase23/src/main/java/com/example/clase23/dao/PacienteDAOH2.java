package com.example.clase23.dao;

import com.example.clase23.dao.BD;
import com.example.clase23.model.Domicilio;
import com.example.clase23.model.Paciente;
import com.example.clase23.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements IDao<Paciente> {
    private static final Logger LOGGER=Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_BY_EMAIL="SELECT *FROM PACIENTES WHERE EMAIL=?";


    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Iniciando la operacion de guardado de un Paciente");
                return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection=null;
        List<Paciente> pacientes= new ArrayList<>();
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectAll= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            DomicilioDAOH2 domAux= new DomicilioDAOH2();
            while (rs.next()){
                domicilio=domAux.buscar(rs.getInt(6));
                //VALUES(1,'Jorgito','Pereyra','123345','2023-05-24',5)<--FK
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),domicilio, rs.getString(7));
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

    @Override
    public Paciente buscarXString(String valor) {
        LOGGER.info("iniciando la busqueda del paciente con email: "+valor);
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try {
            connection= BD.getConnection();
            PreparedStatement ps_SelectEmail= connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            ps_SelectEmail.setString(1,valor);
            ResultSet rs= ps_SelectEmail.executeQuery();
            DomicilioDAOH2 domAux= new DomicilioDAOH2();
            while (rs.next()){
                domicilio=domAux.buscar(rs.getInt(6));
                //VALUES(1,'Jorgito','Pereyra','123345','2023-05-24',5)<--FK
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));

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
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection= null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps_SelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            ps_SelectOne.setInt(1,id);
            ResultSet rsPaciente= ps_SelectOne.executeQuery();
            DomicilioDAOH2 domAux= new DomicilioDAOH2();
            while (rsPaciente.next()){
                domicilio=domAux.buscar(rsPaciente.getInt(6));
                //VALUES(1,'Jorgito','Pereyra','123345','2023-05-24',5)<--FK
                paciente= new Paciente(rsPaciente.getInt(1),rsPaciente.getString(2),rsPaciente.getString(3),rsPaciente.getString(4), rsPaciente.getDate(5).toLocalDate(),domicilio,rsPaciente.getString(7));

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
        return paciente;

    }


}
