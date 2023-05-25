package dao;

import bd.BD;
import model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    private static final Logger LOGGER= Logger.getLogger(DomicilioDAOH2.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        LOGGER.info("Guardado de un Domicilio ubicado en : "+domicilio.getCalle());
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO DOMICILIOS " +
                    "(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.execute();
            //qué pasa con la clave que se genera
            ResultSet clave= preparedStatement.getGeneratedKeys();
            while (clave.next()){
                domicilio.setId(clave.getInt(1));
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
    public Domicilio buscar(int id) {
        LOGGER.info("iniciando operaciones de busqueda por IO: "+id);
        Connection connection= null;
        Domicilio domicilio=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps_Select= connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID=?");
            ps_Select.setInt(1,id);
            ResultSet rsDom= ps_Select.executeQuery();
            while (rsDom.next()){
                domicilio= new Domicilio(rsDom.getInt(1),rsDom.getString(2),rsDom.getString(3),rsDom.getString(4),rsDom.getString(5));
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
        return domicilio;
    }

    @Override
    public void modificar(Domicilio domicilio) {
        LOGGER.info("Iniciando operaciones de actualizar o modificar un domicilio por IO:"+domicilio);
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps_Update= connection.prepareStatement("UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID =?");
            ps_Update.setString(1, domicilio.getCalle());
            ps_Update.setString(2, domicilio.getNumero());
            ps_Update.setString(3, domicilio.getLocalidad());
            ps_Update.setString(4, domicilio.getProvincia());
            ps_Update.setInt(5,domicilio.getId());
            ps_Update.execute();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void eliminar(int id) {
        LOGGER.info("iniciando operaciones de eliminado por IO: "+id);
        Connection connection=null;
         try{
             connection =BD.getConnection();
             PreparedStatement ps_delete= connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID=?");
             ps_delete.setInt(1,id);
             ps_delete.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Domicilio> listar() {
        LOGGER.info("iniciando operaciones de listar a todos los domicilios");
        Connection connection=null;
        List<Domicilio> domicilios=new ArrayList<>();
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectAll= connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet rs= psSelectAll.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                domicilios.add(domicilio);
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
        return domicilios;
    }
}
