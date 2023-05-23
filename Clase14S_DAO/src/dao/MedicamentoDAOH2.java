package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentoDAOH2 implements iDao<Medicamento> {
    //ID, CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM MEDICAMENTOS WHERE ID=?;";
    private static final Logger LOGGER= Logger.getLogger(MedicamentoDAOH2.class);

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        //cargar, ejecutar y guardar el prepared statement
        LOGGER.info("Inicio de Operatoria de Guardado ;) de un medicamento");
        Connection connection= null;
        try{
            //conectarme a la bd
            connection= BD.getConnection();
            PreparedStatement ps_insert= connection.prepareStatement(SQL_INSERT);
            //ID, CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO
            ps_insert.setInt(1,medicamento.getId());
            ps_insert.setInt(2,medicamento.getCodigo());
            ps_insert.setString(3, medicamento.getNombre());
            ps_insert.setString(4, medicamento.getLaboratorio());
            ps_insert.setInt(5,medicamento.getCantidad());
            ps_insert.setDouble(6,medicamento.getPrecio());
            //tenemos que ejecutarlo
            ps_insert.execute();



        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try {
                connection.close();

            }catch (SQLException ex){
                ex.printStackTrace();

            }
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {

        //cargar, ejecutar y guardar el prepared statement
        LOGGER.info("Inicio de Operatoria de Busqueda ;) de un medicamento");
        Connection connection= null;
        try{
            //conectarme a la bd
            connection= BD.getConnection();
            PreparedStatement ps_select= connection.prepareStatement(SQL_SELECT);
            //ID, CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO
            ps_select.setInt(1,id);
            //Guardamos un resultSet
            ResultSet rs_select = ps_select.executeQuery();
            while (rs_select.next()){
                LOGGER.info("El resultado de la busqueda es: " + rs_select.getString("nombre"));
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
        return null;
    }


}
