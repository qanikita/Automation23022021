package ua.kiev.prog.automation.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class UIJUnitTest {

    public WebDriver driver = Session.getInstance().wd();

    @BeforeEach
    public void beforeEach () {
        driver.get ("http://zvisno.com/index.php?route=account/login");
    }

    @AfterEach
    public void afterEach () {
        Session.getInstance().close();
    }
}
