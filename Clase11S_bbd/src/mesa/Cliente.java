package mesa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11","sa","sa");
    }

    private static final String SQL_CREATE_TABLE="DROP TABLE IF EXISTS FORMAS;" +
            "CREATE TABLE FORMAS (ID INT PRIMARY KEY, FORMA VARCHAR(100) NOT NULL, COLOR VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERT="INSERT INTO FORMAS VALUES (1,'circulo','azul')," + "(2,'circulo','rojo')," + "(3,'cuadrado','rojo')";



    private static void verFormas(Connection connection)throws Exception {
        String sql = "SELECT * FROM FORMAS";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3));
        }
    }

    private static void verCirculosRojos(Connection connection) throws Exception{
        String SQL_SELECT="SELECT * FROM FORMAS WHERE FORMA = 'circulo' AND COLOR= 'rojo'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT);
        while (resultSet.next()) {
            System.out.println("Los circulos rojos son: " + resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3));
        }
    }

    public static void main(String[] args) {
            Connection connection=null;

            try{
                connection = getConnection();
                Statement statement= connection.createStatement();
                statement.execute(SQL_CREATE_TABLE);
                statement.execute(SQL_INSERT);
                verCirculosRojos(connection);
                verFormas(connection);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
                try{
                    connection.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
    }


}
