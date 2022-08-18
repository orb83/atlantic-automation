package jDBC_practice;

import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestWithoutConfigProperties {

    @Test
    public void testDatabaseValue() throws SQLException {

        ResultSet resultSet = SqlConnectionWithoutConfigProperties.readData("select * from monthly_mortgage");
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

