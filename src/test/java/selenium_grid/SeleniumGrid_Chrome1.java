package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Chrome1 {
    @Test
    public void executeInAweDocker() throws MalformedURLException {

        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.mortgagecalculator.org/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
