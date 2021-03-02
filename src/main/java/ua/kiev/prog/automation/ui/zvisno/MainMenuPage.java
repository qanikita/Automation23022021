package ua.kiev.prog.automation.ui.zvisno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.UITest;


public class MainMenuPage {

    final private UITest _test;

    final private By menuItemLocator (String menuItemName){
        return By.xpath(String.format("//nav[@id='menu']//ul/li/a[text()='%s']", menuItemName));
    }
    final private By subMenuItemLocator (String subMenuItemName){
        return By.xpath(String.format("//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'%s')]", subMenuItemName));
    }

    public MainMenuPage (UITest test){
        this._test = test;
    }

    public void clickMenuItem (String menuItemName){
        WebElement menuItem = _test.driver.findElement(menuItemLocator(menuItemName));
        menuItem.isDisplayed();
        menuItem.click();
    }

    public void clickSubMenuItem (String menuItemName, String subMenuItemName) {
        WebElement menuItem = _test.driver.findElement(menuItemLocator(menuItemName));
        menuItem.isDisplayed();
        menuItem.click();
        WebElement subMenuItem = _test.driver.findElement(subMenuItemLocator(subMenuItemName));
        subMenuItem.isDisplayed();
        subMenuItem.click();

    }
}
