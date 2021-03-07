package ua.kiev.prog.automation.base.page;

import org.openqa.selenium.WebDriver;
import ua.kiev.prog.automation.base.Session;

public class BasePage {

    final protected WebDriver driver () {
        return Session.getInstance().wd();
    }
}
