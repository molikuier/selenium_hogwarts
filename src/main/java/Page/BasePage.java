package Page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver =  Driver.getInstance().getWebDriver();


    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void action(String key){
        Actions actions = new Actions(driver);
        switch (key.toUpperCase()){
            case "ENTER":
                System.out.println("执行enter");
                actions.sendKeys(Keys.ENTER).perform();
                break;
            default:
                break;

        }
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public void waitUntil(By by){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
