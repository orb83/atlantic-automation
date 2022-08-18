package parameters_DDT;

import org.testng.annotations.Test;
import page_objects.utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSqlParameters {

    @Test
    public void testDatabaseValue() throws SQLException {

        ResultSet resultSet = SqlConnector.readData("select * from monthly_mortgage");
        try {
            while (resultSet.next()){
                System.out.println("The home price is " +resultSet.getString("homevalue"));
                System.out.println("The home price is " +resultSet.getString("downpayment"));
                System.out.println("The home price is " +resultSet.getString("loanamount"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
