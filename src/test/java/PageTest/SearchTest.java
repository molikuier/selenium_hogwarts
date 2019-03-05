package PageTest;

import Page.HomePage;
import TestData.SearchParam;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.TestCase;

public class SearchTest extends TestCase {
    static HomePage homePage;

//    @BeforeAll
    @BeforeClass
    static void  before(){
        homePage = HomePage.getInstance();
    }

//    @ParameterizedTest
//    @CsvSource({
//            "selenium"
//    })

    @Test(dataProvider = "getsearch",dataProviderClass = SearchParam.class)
    public void searchTest(String key){
        homePage.gotoSearch(key);
    }

}
