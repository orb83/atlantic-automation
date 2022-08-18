package automation_test.parallelTesting;


import org.testng.annotations.Test;
import page_objects.Home;
import page_objects.utilities.DateUtils;
import page_objects.utilities.SqlConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRate_ParallelTesting extends BaseUIClass {

    @Test
    public void calculateMonthlyPayment(){
        String[] date = DateUtils.returnNextMonth();
        try {
            ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
            while (rs.next()){
                new Home(driver)
                        .typeHomePrice(rs.getString("homevalue"))
                        .clickDownPaymentInDollar()
                        .typeDownPayment(rs.getString("downpayment"))
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(date[0])
                        .typeYear(date[1])
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePMI(rs.getString("pmi"))
                        .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                        .typeMOnthlyHOA(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefinance(rs.getString("buyorrefi"))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
            }
        }catch (SQLException e){
            LOGGER.error("SQL Data Read Exception: " +e.getMessage());
        }
    }
}
