package ua.kiev.prog.automation.ui.zvisno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    final private By errorMessageLocator    = By.xpath("//div[contains(@class, 'alert-danger')]");
    final private By loginLocator           = By.xpath("//input[@id='input-email']");
    final private By passwordLocator        = By.xpath("//input[@id='input-password']");
    final private By submitBtnLocator       = By.xpath("//input[@type='submit']");



    public void login (String username, String password){
        WebElement login = driver().findElement(loginLocator);
        WebElement passwd = driver().findElement(passwordLocator);
        WebElement submitButton = driver().findElement(submitBtnLocator);
        login.clear();
        login.sendKeys(username);
        passwd.clear();
        passwd.sendKeys(password);
        submitButton.click();
    }

    public void enterUsername (String username){
        WebElement login = driver().findElement(loginLocator);
        login.clear();
        login.sendKeys(username);
    }

    public void enterPassword (String password) {
        WebElement passwd = driver().findElement(passwordLocator);
        passwd.clear();
        passwd.sendKeys(password);
    }

    public void clickSubmitButton () {
        WebElement submitButton = driver().findElement(submitBtnLocator);
        submitButton.click();
    }


    public List<String> getErrorMessages() {
        List<String> result = new ArrayList<>();
        List<WebElement> errors = driver().findElements(errorMessageLocator);
        for (WebElement err : errors){
            try {
                result.add(err.getText());
            } catch (Throwable e) {/* ignore */}
        }
        return result;
    }

}
