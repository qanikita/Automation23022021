package ua.kiev.prog.automation.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.UITestNGTest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;

@Test
public class LoginTestNGTest extends UITestNGTest {

    final private LoginPage loginPage = new LoginPage();


    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"invalidUser", "12345678", "Предупреждение: Не совпадает адрес электронной почты и/или пароль."}, //Invalid login
                {"yurii.voronenko@gmail.com", "invalidPassword", "Предупреждение: Не совпадает адрес электронной почты и/или пароль."}, //Invalid password
                {"yurii.voronenko@gmail.com", "12345678", null}, //Valid
                {"YURII.VORONENKO@GMAIL.COM", "12345678", null}, //Valid UPPERCASE
        };
    }


    @Test(dataProvider = "loginData")
    public void loginTest( String username, String password, String errorMessage){
        loginPage.login(username, password);
        if (errorMessage != null) {
            Assert.assertEquals(errorMessage, loginPage.getErrorMessages().get(0),"Error message is not equal to expected");
        } else {
            Assert.assertEquals(0, loginPage.getErrorMessages().size(),"Error message is present");
        }

    }

}

