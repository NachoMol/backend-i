package mesa;

import org.apache.log4j.Logger;

import java.rmi.server.ExportException;
import java.sql.*;

public class Cliente {

    private static final Logger LOGGER= Logger.getLogger(Cliente.class);

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c12","jorgito","jorgito");
    }

    private static final String SQL_DROP_SELECT="DROP TABLE IF EXISTS EMPLEADOS;" +
            "CREATE TABLE EMPLEADOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL,  APELLIDO VARCHAR(100) NOT NULL, PAIS VARCHAR(100), " +
            " EDAD INT NOT NULL)";
    private static final String SQL_INSERT="INSERT INTO EMPLEADOS VALUES(1,'Ema','Michael', 'Argentina',30),(2,'David','Bolivar', 'Colombia',29),(2,'Ramiro','Cespedes', 'Brasil',18)";
    private static final String SQL_SELECT="SELECT * FROM EMPLEADOS";
    private static final String SQL_SELECT_ID2="SELECT * FROM EMPLEADOS WHERE ID = 2";
    private static final String SQL_UPDATE= "UPDATE EMPLEADOS SET EDAD = 21 WHERE ID = 2";
    private static final String SQL_DELETE="DELETE FROM EMPLEADOS WHERE ID= 2";
    private static final String SQL_DELETE_NOMBRE="DELETE FROM EMPLEADOS WHERE NOMBRE= 'Ema'";

    public static void main(String[] args) {
        Connection connection=null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            //llamar al drop create
            statement.execute(SQL_DROP_SELECT);
            //insertar valores
            statement.execute(SQL_INSERT);
            LOGGER.error("Estás intentando insertar 2 id´s iguales");
            statement.execute(SQL_UPDATE);
            ResultSet rs = statement.executeQuery(SQL_SELECT_ID2);
            String resultado = funcionWhile(rs);
            LOGGER.debug(resultado);
            LOGGER.info(rs);

            statement.execute(SQL_DELETE);

            /* ResultSet rsDeleteNombre = statement.execute(SQL_DELETE_NOMBRE);
            LOGGER.info(rsDeleteNombre); */

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

        public String funcionWhile(ResultSet rs) throws SQLException {

            while (rs.next()) {
                return ("ID: " + rs.getString(1)) + " Nombre: " + rs.getString(2) +
                        " Apellido: " + rs.getString(3)+" Nacionalidad :" + rs.getString(4) + " Edad: " + rs.getString(5);

            }

    }

}

