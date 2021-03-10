package ua.kiev.prog.automation.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.ui.zvisno.MainMenuPage;

public class MainMenuSteps {

    private MainMenuPage mainMenuPage = new MainMenuPage();

//    @When("^I go to login page$")
//    public void iGoToLoginPage () throws Exception {
//        Session.getInstance().wd().get("http://zvisno.com/index.php?route=account/login");
//    }

    @And("^I click on the category and subcategory link \"(.+?)\" \"(.+?)\"$")
    public void iClickOnTheCategoryAndSubcategoryLink (String menuItems, String subMenuItem){
        if (subMenuItem != null) {
            mainMenuPage.clickSubMenuItem(menuItems, subMenuItem);
        }else {
            mainMenuPage.clickMenuItem(menuItems);
        };
    }

    @And("^I check the number of products in a category \"(.+?)\"$")
    public void iCheckTheNumberOfProductsInACategory (Integer count) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(mainMenuPage.getProductItemsCount(),count);;
    }

}
