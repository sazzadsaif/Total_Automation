package mortgage_calculator_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import parameters.DataProviderLesson;
import utilities.BaseClass;
import utilities.ReadConfigFiles;

public class CalculateRealAprRateParameterized extends BaseClass {

    @Test(dataProvider="RealAprRate",dataProviderClass = DataProviderLesson.class)
    public void calculateRealApr(String homePrice,String downPayment, String interestRate,String actualApr){
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton()
                .validateRealApr(actualApr);
    }



}
