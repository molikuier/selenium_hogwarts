package Page;

import org.openqa.selenium.By;

public class ClubPage  extends  BasePage{

    private String teamName = ".team-name[data-name=%s]";


    public TopicListPage gotoTopicList(String name){
        String clubName = String.format(teamName,name);
        findElement(By.cssSelector(clubName)).click();
        return new TopicListPage();
    }

}
