package com.example.clase23.repository;

import com.example.clase23.entities.Domicilio;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class DomicilioDAOH2 implements IDao<Domicilio>{

    private final static String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO,LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
    private final static String SQL_BUSCAR="SELECT * FROM DOMICILIOS WHERE ID=?";
    private final static String  SQL_UPDATE="UPDATE DOMICILIOS SET CALLE =? , NUMERO =? , LOCALIDAD =? , PROVINCIA =? WHERE ID=?";

    private static final Logger LOGGER= Logger.getLogger(DomicilioDAOH2.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,domicilio.getCalle());
            ps.setString(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();
            ResultSet rs= ps.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_BUSCAR);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                domicilio=new Domicilio(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {

        LOGGER.info("Iniciando la operacion de Actualizacion de domiclio");

        Connection connection = null;

        try{
            connection=BD.getConnection();

            PreparedStatement ps_update = connection.prepareStatement(SQL_UPDATE,Statement.RETURN_GENERATED_KEYS);

            ps_update.setString(1,domicilio.getCalle());
            ps_update.setString(2,domicilio.getNumero());
            ps_update.setString(3,domicilio.getLocalidad());
            ps_update.setString(4,domicilio.getProvincia());
            ps_update.setInt(5,domicilio.getId());

            ps_update.execute();

            ResultSet rs=ps_update.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Domicilio> listarTodos() {
        return null;
    }

    @Override
    public Domicilio buscarXString(String valor) {
        return null;
    }
}
