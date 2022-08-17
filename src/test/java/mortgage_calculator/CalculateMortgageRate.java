package mortgage_calculator;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.BaseClass;
import utilities.DateUtils;

public class CalculateMortgageRate extends BaseClass {


    @Test
    public void calculateMonthlyPayment(){
        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentToDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYear("30")
                .selectMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeIns("1000")
                .typeHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefi("Buy")
                .clickOnCalculateRateButton()
                .validateTotalMonthlyPayment("$1,611.85");




    }

}


