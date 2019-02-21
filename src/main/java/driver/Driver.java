package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Driver {

    static private WebDriver webDriver;
    static Driver driver;
    private static final String CONFIG ="/config.yaml";
    private static final String CHROMEDRIVER = Driver.class.getResource("/chromedriver").getFile();
    private static final String FIREFOXDRIVER = Driver.class.getResource("/geckodriver").getFile();

    public static Driver getInstance(){
        if(driver == null){
            driver = new Driver();
        }
        return driver;
    }

    public void start(){
        GlobalConfig globalConfig = GlobalConfig.load(CONFIG);
        switch (globalConfig.browers.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",CHROMEDRIVER);
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.geckodriver.driver",FIREFOXDRIVER);
                webDriver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",CHROMEDRIVER);
                webDriver = new ChromeDriver();
                break;

        }
        webDriver.manage().timeouts().implicitlyWait(globalConfig.timeout, TimeUnit.SECONDS);
        webDriver.get(globalConfig.url);

    }

    public WebDriver getWebDriver(){
        if (webDriver == null){
            start();
        }
        return webDriver;
    }

    public WebElement findElement(By by){
        try{
            WebElement element = webDriver.findElement(by);
            return element;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<WebElement> findElements(By by){
        try{
            List<WebElement> elements = webDriver.findElements(by);
            return elements;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getPageSource(){
        return webDriver.getPageSource();
    }



}
