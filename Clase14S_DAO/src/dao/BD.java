package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//drop create
public class BD {
    //ID, CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS MEDICAMENTOS; " +
            "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY, CODIGO INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL," +
            " LABORATORIO VARCHAR(100) NOT NULL, CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL)";
    private static final Logger LOGGER= Logger.getLogger(BD.class);
    public static void crearTabla(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            LOGGER.info("Se ha creado con éxito la tabla");
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
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c14","sa","sa");
    }
}
