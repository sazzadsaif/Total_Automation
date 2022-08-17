package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ElementActions {
    WebDriver driver;
    By locator;
    public ElementActions(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement getElement(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        }catch (Exception e){
            System.out.println(" message is " + e);
        }

        return element;
    }
    public ElementActions click(){
        getElement().click();
        return this;
    }
    public ElementActions setValue(String value){
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }
    public ElementActions selectValue(String value){
        Select select = new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }
    public ElementActions mouseHover(){
        Actions action = new Actions(driver);
        action.moveToElement(getElement()).perform();
        return this;

    }
    public String getTextValue(){

        return getElement().getText();
    }

}
