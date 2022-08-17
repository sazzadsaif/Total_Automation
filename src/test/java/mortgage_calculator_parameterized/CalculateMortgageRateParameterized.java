package mortgage_calculator_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRateParameterized {

    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);

    WebDriver driver;


    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        LOGGER.info("-----------test name: Calculate mortgage rate-----------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");

        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateMonthlyPayment() {
        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];



        try {
            ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
            while(rs.next()){
                new NavigationBar(driver)
                        .navigateToHome()
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickDownPaymentToDollar()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYear(rs.getString("loanterm"))
                        .selectMonth(month)
                        .typeYear(year)
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePmi(rs.getString("pmi"))
                        .typeHomeIns(rs.getString("homeowenerinsurance"))
                        .typeHoa(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefi(rs.getString("buyorrefi"))
                        .clickOnCalculateRateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));


            }

        }catch (SQLException e){
            LOGGER.error(e.getMessage());
        }




    }
    @AfterMethod
    public void quitBrowser(){
        LOGGER.info("-----------End test case--------------");
        ActOn.browser(driver).closeBrowser();
    }
}


