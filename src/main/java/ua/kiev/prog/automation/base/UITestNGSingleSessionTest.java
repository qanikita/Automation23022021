package ua.kiev.prog.automation.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class UITestNGSingleSessionTest {

    @BeforeTest
    public void beforeEach () {
        Session.getInstance().wd().get ("http://zvisno.com/index.php?route=account/login");
    }

    @AfterTest
    public void afterEach () {
        Session.getInstance().close();
    }
}
