package presencial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {

    private static final String SQL_CREATE_TABLE="DROP TABLE IF EXISTS ANIMALES;" +
            "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERT="INSERT INTO ANIMALES VALUES (1,'Pancho','Perro')," + "(2,'Pepe','Gato')";

    private static final String SQL_DELETE="DELETE FROM ANIMALES WHERE ID=2";

    public static void main(String[] args) {
        Connection connection=null;

        try{
            connection = getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_INSERT);
            verAnimales(connection);
            statement.execute(SQL_DELETE);
            verAnimales(connection);
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
    private static void verAnimales(Connection connection)throws Exception{
        String sql="SELECT * FROM ANIMALES";
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3));
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11","sa","sa");
    }

}
