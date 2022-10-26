package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Firefox1 {
    @Test
    public void executeInAweDocker(){

        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
