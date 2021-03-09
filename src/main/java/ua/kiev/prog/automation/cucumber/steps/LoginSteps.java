package ua.kiev.prog.automation.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @When("^I go to login page$")
    public void iGoToLoginPage () throws Exception {
        Session.getInstance().wd().get("http://zvisno.com/index.php?route=account/login");
    }

    @And("^I enter username as \"(.+?)\"$")
    public void iEnterUsernameAs (String username){
        loginPage.enterUsername(username);
    }

    @And("^I enter password as \"(.+?)\"$")
    public void iEnterPasswordAs (String password){
        loginPage.enterPassword(password);
    }

    @And("^I click submit button$")
    public void iClickSubmitButton (){
        loginPage.clickSubmitButton();
    }

    @When("^Count of error messages must be (\\d+?)$")
    public void countOfErrorMessagesMustBe (int count){
        Assert.assertEquals(loginPage.getErrorMessages().size(),count);
    }
}
