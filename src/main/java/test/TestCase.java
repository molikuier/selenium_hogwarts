package test;

import driver.Driver;

public class TestCase {
//    @BeforeAll
//    @BeforeClass
    static void setup(){
        Driver.getInstance().start();
    }

//    @AfterAll
//    static void after(){
//        Driver.getInstance().getWebDriver().quit();
//    }

}
