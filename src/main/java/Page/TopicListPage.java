package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopicListPage extends BasePage {


    public TopicDetailPage gotoDetail(int num){
        List<WebElement> topicList = findElements(By.cssSelector(".title"));
        topicList.get(num).click();
        return new TopicDetailPage();
    }

    public TopicDetailPage gotoDetail(String topic){
        List<WebElement> topicList = findElements(By.cssSelector(".title"));
        for(WebElement element:topicList){
            if (element.getText().contains(topic)) element.click();
        }
        return new TopicDetailPage();


    }
}
