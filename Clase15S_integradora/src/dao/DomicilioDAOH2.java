package dao;

import bd.BD;
import model.Domicilio;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection = null;
        try{
            connection= BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIOS" +
                    "(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,domicilio.getCalle());
            preparedStatement.setString(2,domicilio.getNumero());
            preparedStatement.setString(3,domicilio.getLocalidad());
            preparedStatement.setString(4,domicilio.getProvincia());
            preparedStatement.execute();
            //que pasa con la clave que se genera?
            ResultSet clave = preparedStatement.getGeneratedKeys();
            while (clave.next()){
                domicilio.setId(clave.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return domicilio;
    }

    @Override
    public Domicilio buscar(int i) {
        return null;
    }

    @Override
    public void eliminar(int i) {

    }

    @Override
    public Domicilio modificar(Domicilio domicilio) {
        return null;
    }

    @Override
    public List<Domicilio> listar() {
        return null;
    }
}
