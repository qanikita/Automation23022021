package ua.kiev.prog.automation.junit;

import org.junit.jupiter.api.Test;
import ua.kiev.prog.automation.base.UIJUnitTest;
import ua.kiev.prog.automation.ui.zvisno.MainMenuPage;

public class MainMenuNavigationJUnitTest extends UIJUnitTest {

    final private MainMenuPage MainMenuPage = new MainMenuPage(this);

    @Test
    public void clickMenuItems () throws InterruptedException {

        MainMenuPage.clickMenuItem("Desktops");
        Thread.sleep(2000);

        MainMenuPage.clickSubMenuItem("Components","Printers");
        Thread.sleep(5000);

    }
}
