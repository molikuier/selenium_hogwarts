package TestData;

import org.testng.annotations.DataProvider;

public class SearchParam {

    @DataProvider(name = "getsearch")
    public Object[][] getSearch(){
        return new Object[][]{
                {"selenium"},
                {"appium"}
        };

    }
}
