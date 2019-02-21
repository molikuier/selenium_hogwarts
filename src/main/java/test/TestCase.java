package test;

import driver.Driver;
import org.junit.jupiter.api.BeforeAll;

public class TestCase {
    @BeforeAll
    static void setup(){
        Driver.getInstance().start();
    }

//    @AfterAll
//    static void after(){
//        Driver.getInstance().getWebDriver().quit();
//    }

}
