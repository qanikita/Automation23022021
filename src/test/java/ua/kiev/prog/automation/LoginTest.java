package ua.kiev.prog.automation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;


public class LoginTest extends UITest {

    final private LoginPage loginPage = new LoginPage(this);

    @Test
    public void testMethod () throws Exception {

        loginPage.login("invalidUser","invalidPassword");
        Assertions.assertEquals("Предупреждение: Не совпадает адрес электронной почты и/или пароль.", loginPage.getErrorMessages().get(0));
        Thread.sleep(1000);

        loginPage.login("yurii.voronenko@gmail.com","12345678");
        Assertions.assertEquals(0, loginPage.getErrorMessages().size());
        Thread.sleep(5000);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=''; arguments[1].value=''; alert('Hello!');", login, password);
//        Thread.sleep(1000);
//        driver.switchTo().alert().accept();
//        String returnedJsValue = (String) js.executeScript("return document.readyState;");
//        System.out.println(returnedJsValue);
    }
}
