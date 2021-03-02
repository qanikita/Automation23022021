package ua.kiev.prog.automation.ui.zvisno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.UITest;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    final private UITest _test;

    final private By errorMessageLocator    = By.xpath("//div[contains(@class, 'alert-danger')]");
    final private By loginLocator           = By.xpath("//input[@id='input-email']");
    final private By passwordLocator        = By.xpath("//input[@id='input-password']");
    final private By submitBtnLocator       = By.xpath("//input[@type='submit']");


    public LoginPage (UITest test){
        this._test = test;
    }

    public void login (String username, String password){
        WebElement login = _test.driver.findElement(loginLocator);
        WebElement passwd = _test.driver.findElement(passwordLocator);
        WebElement submitButton = _test.driver.findElement(submitBtnLocator);
        login.clear();
        login.sendKeys(username);
        passwd.clear();
        passwd.sendKeys(password);
        submitButton.click();
    }

    public List<String> getErrorMessages() {
        List<String> result = new ArrayList<>();
        List<WebElement> errors = _test.driver.findElements(errorMessageLocator);
        for (WebElement err : errors){
            try {
                result.add(err.getText());
            } catch (Throwable e) {/* ignore */}
        }
        return result;
    }

}
