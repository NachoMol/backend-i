package dao;

import bd.BD;
import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;
import service.PacienteService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";

    private static final String SQL_MODIFICAR="UPDATE PACIENTES SET APELLIDO=?, NOMBRE=?, DNI=?, FECHA=? WHERE ID = ?";

    private static final String SQL_INSERT_PACIENTE = "INSERT INTO PACIENTES VALUES(?,?,?,?,?,?)";

    private static final String SQL_ELIMINAR="DELETE FROM PACIENTES WHERE ID = ?";

    private static final Logger LOGGER= Logger.getLogger(PacienteDAOH2.class);

    @Override
    public Paciente guardar(Paciente paciente) {

        LOGGER.debug("ingresamos al metodo guardar de paciente en PacienteDaoH2");
        Connection connection= null;
        Domicilio domicilio = null;
        DomicilioDAOH2 domicilioAux = new DomicilioDAOH2();
        domicilio=domicilioAux.buscar(paciente.getDomicilio().getId());

        try {
            //ID, APELLIDO,NOMBRE,DNI(S),FECHA INGRESO,DOMICILIO
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PACIENTE);

            preparedStatement.setInt(1,paciente.getId());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3, paciente.getNombre());
            preparedStatement.setString(4, paciente.getDocumento());
            //??? preguntar!!!!!!!!
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, domicilio.getId());
            // ejecutamos
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
                paciente= new Paciente(rsPaciente.getInt(1),rsPaciente.getString(2),rsPaciente.getString(3),rsPaciente.getString(4), rsPaciente.getDate(5).toLocalDate(),domicilio);

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
    public void modificar(Paciente paciente) {
        LOGGER.info("ingresamos al metodo modificar el id: " + paciente.getId());
        Connection connection=null;

        try{
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_MODIFICAR);
            //APELLIDO,NOMBRE,DNI(S),FECHA INGRESO
            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setDate(3, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(4,paciente.getId());
            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        LOGGER.debug("INGRESAMOS AL METODO DE eliminar ID POR paciente : " + id);
        Connection connection=null;
        try{
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Paciente> listar() {
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
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),domicilio);
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
