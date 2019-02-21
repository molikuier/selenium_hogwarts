package PageTest;

import Page.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.TestCase;

public class SearchTest extends TestCase {
    static HomePage homePage;

    @BeforeAll
    static void  before(){
        homePage = HomePage.getInstance();
    }

    @ParameterizedTest
    @CsvSource({
            "selenium"
    })
    public void searchTest(String key){
        homePage.gotoSearch(key);
    }

}
