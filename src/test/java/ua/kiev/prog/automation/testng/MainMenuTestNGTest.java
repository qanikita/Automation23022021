package ua.kiev.prog.automation.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.UITestNGSingleSessionTest;
import ua.kiev.prog.automation.ui.zvisno.MainMenuPage;

public class MainMenuTestNGTest extends UITestNGSingleSessionTest {

    final private MainMenuPage mainMenuPage = new MainMenuPage();

    @DataProvider(name = "mainMenuData")
    public Object[][] mainMenuData(){
        return new Object[][]{
                {"Desktops",                "PC",                       0}, //Open PC page
                {"Desktops",                "Mac",                      1}, //Open Mac page
                {"Laptops & Notebooks",     "Macs",                     0}, //Open Macs page
                {"Laptops & Notebooks",     "Windows",                  0}, //Open Windows page
                {"Components",              "Mice and Trackballs",      0}, //Open Mice and Trackballs page
                {"Components",              "Monitors",                 2}, //Open Monitors page
                {"Components",              "Printers",                 0}, //Open Printers page
                {"Components",              "Scanners",                 0}, //Open Scanners page
                {"Components",              "Web Cameras",              0}, //Open Web Cameras page
                {"MP3 Players",             "test 11",                  0}, //Open test 11 page
                {"MP3 Players",             "test 12",                  0}, //Open test 12 page
                {"MP3 Players",             "test 15",                  0}, //Open test 15 page
                {"MP3 Players",             "test 16",                  0}, //Open test 16 page
                {"MP3 Players",             "test 17",                  0}, //Open test 17 page
                {"MP3 Players",             "test 18",                  0}, //Open test 18 page
                {"MP3 Players",             "test 19",                  0}, //Open test 19 page
                {"MP3 Players",             "test 20",                  0}, //Open test 20 page
                {"MP3 Players",             "test 21",                  0}, //Open test 21 page
                {"MP3 Players",             "test 22",                  0}, //Open test 22 page
                {"MP3 Players",             "test 23",                  0}, //Open test 23 page
                {"MP3 Players",             "test 24",                  0}, //Open test 24 page
                {"MP3 Players",             "test 4",                   0}, //Open test 4 page
                {"MP3 Players",             "test 5",                   0}, //Open test 5" page
                {"MP3 Players",             "test 6",                   0}, //Open test 6 page
                {"MP3 Players",             "test 7",                   0}, //Open test 7 page
                {"MP3 Players",             "test 8",                   0}, //Open test 8 page
                {"MP3 Players",             "test 9",                   0}, //Open test 9 page
                {"Tables",                  null,                       1}
        };
    }

    @Test(dataProvider = "mainMenuData")
    public void clickMenuItems (String menuItems, String subMenuItem, Integer count) throws InterruptedException {
        mainMenuPage.clickSubMenuItem(menuItems,subMenuItem);
        Thread.sleep(1000);
        Assert.assertEquals(mainMenuPage.getProductItemsCount(),count);

    }
}
