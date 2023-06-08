package com.example.clase23.repository;

import com.example.clase23.model.Odontologo;
import org.h2.engine.ConnectionInfo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoDAOH2 implements IDao<Odontologo> {
    //FALTA EL INSERT INTO PARA GUARDAR ODONTOLOGOS
    private static final SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        List<Odontologo> listaOdontologos= new ArrayList<>();
        Odontologo odontologo;
        try{
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                odontologo=new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                listaOdontologos.add(odontologo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return listaOdontologos;

    }

    @Override
    public Odontologo buscarXString(String valor) {
        return null;
    }
}
