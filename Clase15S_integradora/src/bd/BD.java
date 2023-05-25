package bd;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {


    private static final String SQL_DROP_CREATE_DOMICILIOS="DROP TABLE IF EXISTS DOMICILIOS; " +
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "CALLE VARCHAR(100), NUMERO VARCHAR(100), LOCALIDAD VARCHAR(100)," +
            "PROVINCIA VARCHAR(100))";

    private static final String SQL_DROP_CREATE_PACIENTES="DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, " +
            " APELLIDO VARCHAR(100) NOT NULL, DOCUMENTO VARCHAR(100) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT)";

    private final static String SQL_PRUEBA="INSERT INTO DOMICILIOS (CALLE,NUMERO,LOCALIDAD,PROVINCIA) " +
            "VALUES('CALLE 210A','1234','SOURIGUES', 'BS AS'),('CALLE SIEMPRE VIVA','742','SPRINGFIELD','USA'); " +
            "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOCUMENTO, FECHA_INGRESO, DOMICILIO_ID) VALUES('PEPE','MUJICA','123','2022-05-08',1),('SOL','VAZQUEZ','1223','2022-10-25',2)";
    private static final Logger LOGGER= Logger.getLogger(BD.class);
    public static void crearTablas(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIOS);
            statement.execute(SQL_DROP_CREATE_PACIENTES);
            statement.execute(SQL_PRUEBA);
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
        return DriverManager.getConnection("jdbc:h2:~/c15","sa","sa");
    }

}
