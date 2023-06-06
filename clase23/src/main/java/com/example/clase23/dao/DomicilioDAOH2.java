package com.example.clase23.dao;

import com.example.clase23.model.Domicilio;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Component
public class DomicilioDAOH2 implements IDao<Domicilio>{

    private final static String SQL_INSERT="INSERT INTO DOMICILIOS(CALLE,NUMERO,LOCALIDAD,PROVINCIA) VALUES (?,?,?,?)";
    private final static String SQL_SEARCH="SELECT * FROM DOMICILIOS WHERE ID = ?";
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement ps_insert=connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps_insert.setString(1,domicilio.getCalle());
            ps_insert.setString(2,domicilio.getNumero());
            ps_insert.setString(3,domicilio.getLocalidad());
            ps_insert.setString(4,domicilio.getProvincia());

            ps_insert.execute();

            ResultSet rs_insert = ps_insert.getGeneratedKeys();

            while (rs_insert.next()){
                domicilio.setId(rs_insert.getInt(1));
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
        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection = null;
        Domicilio domicilio = null;
        try{
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH);
            ps.setInt(1,id);
            ResultSet rs_search = ps.executeQuery();
            while (rs_search.next()){
                domicilio= new Domicilio(rs_search.getInt(1),rs_search.getString(2),rs_search.getString(3),rs_search.getString(4),rs_search.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        return null;
    }

    @Override
    public Domicilio buscarXString(String valor) {
        return null;
    }

    @Override
    public void actualizar(Domicilio domicilio, int id) {
    }
}
