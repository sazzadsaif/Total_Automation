package mortgage_calculator;

import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.BaseClass;

public class CalculateRealAprRate extends BaseClass {
    @Test
    public void calculateRealApr(){
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice("200000")
                .clickDownPaymentInDollar()
                .typeDownPayment("15000")
                .typeInterestRate("3")
                .clickOnCalculateButton()
                .validateRealApr("3.130%");
    }

}
