package ua.kiev.prog.automation.base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class UITestNGTest {

    @BeforeMethod
    public void beforeEach () {
        Session.getInstance().wd().get ("http://zvisno.com/index.php?route=account/login");
    }

    @AfterMethod
    public void afterEach () {
        Session.getInstance().close();
    }
}
