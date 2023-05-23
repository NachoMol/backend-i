package mesa;

import java.sql.*;

public class Cliente {

    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, APELLIDO VARCHAR(100) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, MATRICULA VARCHAR(100) NOT NULL)";
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID= ?";
    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGOS";

    public static void main(String[] args) {
        Connection  connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            PreparedStatement ps_Insert= connection.prepareStatement(SQL_INSERT);
            ps_Insert.setInt(1,1);
            ps_Insert.setString(2,"Cespedes");
            ps_Insert.setString(3,"Ramiro");
            ps_Insert.setString(4,"ASD123");

            ps_Insert.execute();

              connection.setAutoCommit(false);

            PreparedStatement ps_select = connection.prepareStatement(SQL_SELECT);
            ResultSet rs_select = ps_select.executeQuery();
            while (rs_select.next()){
                System.out.println(rs_select.getInt(1));
            }

            connection.commit();


            PreparedStatement ps_update= connection.prepareStatement(SQL_UPDATE);
            ps_update.setString(1,"SD123");
            ps_update.setInt(2,1);

            ps_update.execute();

            PreparedStatement ps_select2 = connection.prepareStatement(SQL_SELECT);
            ResultSet rs_select2 = ps_select2.executeQuery();
            while (rs_select2.next()){
                System.out.println(rs_select2.getString(4));
            }


            connection.commit();



        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();

            }catch (SQLException sql){
                sql.printStackTrace();

            }
        }finally {
            try{
                connection.close();

            } catch (SQLException ex){
                ex.printStackTrace();

            }
        }
    }



    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase13","sa","sa");
    }


    }
