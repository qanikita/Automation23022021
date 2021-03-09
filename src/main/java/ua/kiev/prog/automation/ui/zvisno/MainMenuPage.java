package ua.kiev.prog.automation.ui.zvisno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.UIJUnitTest;
import ua.kiev.prog.automation.base.page.BasePage;


public class MainMenuPage extends BasePage {

    final private By menuItemLocator (String menuItemName){
        return By.xpath(String.format("//nav[@id='menu']//ul/li/a[text()='%s']", menuItemName));
    }
    final private By subMenuItemLocator (String subMenuItemName){
        return By.xpath(String.format("..//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'%s')]", subMenuItemName));
    }


    public void clickMenuItem (String menuItemName){
        WebElement menuItem = driver().findElement(menuItemLocator(menuItemName));
        menuItem.click();
    }

    public void clickSubMenuItem (String menuItemName, String subMenuItemName) {
        WebElement menuItem = driver().findElement(menuItemLocator(menuItemName));
        menuItem.click();
        WebElement subMenuItem = menuItem.findElement(subMenuItemLocator(subMenuItemName));
        subMenuItem.isDisplayed();
        subMenuItem.click();


    }

    public Integer getProductItemsCount() {
        return driver().findElements(By.xpath("//div[@id='content']//div[contains(@class,'product-grid')]")).size();
    }
}

