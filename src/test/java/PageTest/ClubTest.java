package PageTest;

import Page.ClubPage;
import Page.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import test.TestCase;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClubTest extends TestCase {
    static private HomePage homePage;
    static private ClubPage clubPage;

    @BeforeAll
    static void setup(){
        homePage = new HomePage();
        clubPage = homePage.gotoClub();
    }

    @ParameterizedTest
    @CsvSource({
            "霍格沃兹测试学院,0,访问被拒绝"
    })
    public void gotoTopic(String topic,int num,String expect){
        clubPage.gotoTopicList(topic).gotoDetail(num).waitUntil(By.cssSelector("#user_login"));
        String source = clubPage.getPageSource();
        assertThat(source,containsStringIgnoringCase(expect));

    }


}
