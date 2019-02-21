package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private By search = By.cssSelector(".form-control");
    private By club = By.linkText("社团");

    static SearchPage searchPage;
    static HomePage homePage;


    public static HomePage getInstance(){
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public SearchPage gotoSearch(String key){
        WebElement searchElement = findElement(search);
        searchElement.clear();
        searchElement.sendKeys(key);
        action("enter");

        return searchPage = new SearchPage();
    }

    public ClubPage gotoClub(){
        WebElement clubLink = findElement(club);
        clubLink.click();
        return new ClubPage();

    }






}
