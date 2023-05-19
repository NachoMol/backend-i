import org.apache.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Cliente {
    private static final String SQL_DROP_SELECT="DROP TABLE IF EXISTS USUARIOS;" +
            "CREATE TABLE USUARIOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL," +
            " APELLIDO VARCHAR(100) NOT NULL, EDAD INT NOT NULL)";
    private static final String SQL_INSERT="INSERT INTO USUARIOS " +
            "VALUES(1,'Ema','Michael',32),(2,'Nicolas','Perez',46),(3,'Agustin','Carrizo',25)";
    private static final String SQL_SELECT="SELECT * FROM USUARIOS";
    private static final String SQL_DELETE="DELETE FROM USUARIOS WHERE ID= 2";
    private static final Logger LOGGER= Logger.getLogger(Cliente.class);
    public static void main(String[] args) {
        //conectarme a la base de datos usando el metodo
        Connection connection=null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            //llamar al drop create
            statement.execute(SQL_DROP_SELECT);
            //insertar valores
            statement.execute(SQL_INSERT);
            //mostrar mediante un RS
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()) {
                //mostrarlo
                System.out.println("ID: " + rs.getInt(1) + ".-Nombre: " + rs.getString(2) +
                        ".-Apellido: " + rs.getString(3)+".-Edad :" + rs.getInt(4));
            }
            System.out.println("**************************************************");
            statement.execute(SQL_DELETE);
            LOGGER.warn("Prestá atención a lo que se acaba de eliminar ID 2");
            rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()) {
                //mostrarlo
                System.out.println("ID: " + rs.getInt(1) + "Nombre: " + rs.getString(2) +
                        "Apellido: " + rs.getString(3)+"Edad :" + rs.getInt(4));
            }
            System.out.println("**************************************************");
        }

        catch (Exception e){
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
        return DriverManager.getConnection("jdbc:h2:~/c12","jorgito","jorgito");
    }
}
