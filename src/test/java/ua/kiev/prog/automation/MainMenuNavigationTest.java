package ua.kiev.prog.automation;

import org.junit.jupiter.api.Test;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainMenuPage;

public class MainMenuNavigationTest extends UITest {

    final private MainMenuPage MainMenuPage = new MainMenuPage(this);

    @Test
    public void clickMenuItems () throws InterruptedException {

        MainMenuPage.clickMenuItem("Desktops");
        Thread.sleep(2000);

        MainMenuPage.clickSubMenuItem("Components","Printers (0)");
        Thread.sleep(5000);

    }
}
