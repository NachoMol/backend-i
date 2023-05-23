package presencial;

import java.sql.*;

public class Cliente {
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS CUENTAS; " +
            "CREATE TABLE CUENTAS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, NUM_CUENTA INT NOT NULL, SALDO NUMERIC(10,2) NOT NULL )";
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS SET SALDO=? WHERE ID= ?";
    private static final String SQL_SELECT="SELECT * FROM CUENTAS";
    public static void main(String[] args) {
        Connection  connection= null;
        try{
            //necesito conectarme a la bdd
            connection= getConnection();
            //necesito crear la tabla
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            //necesito ahora insertar valores
            PreparedStatement ps_Insert= connection.prepareStatement(SQL_INSERT);
            //por que ahora debo cargar los valores 1 a 1
            //primer 1 referencia a primer signo ?, segundo al valor.
            ps_Insert.setInt(1,1);
            ps_Insert.setString(2,"Cecilia Audap");
            ps_Insert.setInt(3,1234567);
            ps_Insert.setDouble(4,300);
            ps_Insert.execute();
            //ahora debemos actualizar +10 al saldo
            PreparedStatement ps_update= connection.prepareStatement(SQL_UPDATE);
            //fijarme el orden de los ???
            ps_update.setDouble(1,300+10);
            ps_update.setInt(2,1);
            ps_update.execute();
            //aca volveria el rollback
            //desactivo los commit de tal manera que los cambios no se vean reflejados en la bdd
            connection.setAutoCommit(false);
            //vuelvo a actualizar el valor del saldo
            PreparedStatement ps_tx= connection.prepareStatement(SQL_UPDATE);
            ps_tx.setDouble(1,300+10+15);
            ps_tx.setInt(2,1);
            ps_tx.execute();
            //confirmo el cambio en la bdd
          
            connection.commit();
            //como buena practica lo correcto es volver a ponerlo en true
            connection.setAutoCommit(true);





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
        return DriverManager.getConnection("jdbc:h2:~/c13","sa","sa");
    }
}
