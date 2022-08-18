package jDBC_practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page_objects.utilities.SqlConnector;

import java.sql.*;

public class ConnectToPostgreSQL {
    final Logger LOGGER = LogManager.getLogger(SqlConnector.class);
    Statement stmt=null;
    Connection conn = null;
    public void createconnection()  {

      try {
          //Create a connection to pgadmin4
           conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user","postgres","7744");

          // Create Statement / Query
          stmt = conn.createStatement();


      }
      catch (SQLException e){
          LOGGER.error("SQL Connection Exception" +e.getMessage());
      }
  }
  public void UsesDMLanguage(){
      // String str = "insert into student values(106,'Henry',206,'CSE')";
      //String str= "update student set s_name='Howard' where s_id=102";
      //String str = "delete from student where s_id =106";
          //Execute DMl Query
      //stmt.executeQuery(str);
      System.out.println("Query  Executed Successfully.......");

  }
  public void  readdatafrompgadmin4(){

      String columnfromtable = "select * from student";
      System.out.println("Display the student table: ");
      System.out.println();
      System.out.println("s_id    s_name    s_roll    s_department");
        try {

            ResultSet rs = stmt.executeQuery(columnfromtable);

            while (rs.next()){
                int sid = rs.getInt("s_id");
                String sname = rs.getString("s_name");
                int sroll = rs.getInt("s_roll");
                String sdept = rs.getString("s_department");


                System.out.println(sid+"     "+sname+"     "+sroll+"     "+sdept+"     ");
            }
        }
        catch (SQLException e){
            LOGGER.error("SQL Connection Exception" +e.getMessage());
        }
  }
    @Test
    public void testpgadmin4()  {
        createconnection();
        UsesDMLanguage();
        readdatafrompgadmin4();

        // Close connection;
        try {
            conn.close();
        }
        catch (SQLException e){

            System.out.println();
        }
    }
}

