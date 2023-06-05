package com.example.clase23.dao;

import com.example.clase23.dao.BD;
import com.example.clase23.model.Domicilio;
import com.example.clase23.model.Paciente;
import com.example.clase23.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements IDao<Paciente> {
    private static final Logger LOGGER=Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_BY_EMAIL="SELECT *FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE,APELLIDO,DOCUMENTO,FECHA_INGRESO,DOMICILIO,EMAIL) VALUES (?,?,?,?,?,?)";


    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Iniciando la operacion de guardado de un Paciente");
                Connection connection = null;
                DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
                Domicilio domicilio=domicilioDAOH2.guardar(paciente.getDomicilio());
                try{
                   connection = BD.getConnection();
                   PreparedStatement ps_insert=connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
                   ps_insert.setString(1,paciente.getNombre());
                    ps_insert.setString(2,paciente.getApellido());
                    ps_insert.setString(3,paciente.getDocumento());
                    ps_insert.setDate(4,Date.valueOf(paciente.getFechaIngreso()));
                    ps_insert.setInt(5,domicilio.getId());
                    ps_insert.setString(6,paciente.getEmail());
                    ps_insert.execute();

                    ResultSet rs_insert = ps_insert.getGeneratedKeys();

                    while (rs_insert.next()){
                        paciente.setId(rs_insert.getInt(1));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        connection.close();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
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
