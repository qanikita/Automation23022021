package ua.kiev.prog.automation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.testng.Assert;
import ua.kiev.prog.automation.base.UIJUnitTest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;
import ua.kiev.prog.automation.ui.zvisno.MainMenuPage;

public class MainMenuNavigationJUnitTest extends UIJUnitTest {

    final private MainMenuPage mainMenuPage = new MainMenuPage();

    private enum MenuData {
        OPEN_PC_PAGE                    ("Desktops",            "PC",                   0),
        OPEN_MAC_PAGE                   ("Desktops",            "Mac",                  1),
        OPEN_MACS_PAGE                  ("Laptops & Notebooks", "Macs",                 0),
        OPEN_WINDOWS_PAGE               ("Laptops & Notebooks", "Windows",              0),
        OPEN_MICE_AND_TRACKBALL_PAGE    ("Components",          "Mice and Trackballs",  0),
        OPEN_MONITORS_PAGE              ("Components",          "Monitors",             2),
        OPEN_PRINTERS_PAGE              ("Components",          "Printers",             0),
        OPEN_SCANNERS_PAGE              ("Components",          "Scanners",             0),
        OPEN_WEB_CAMERAS_PAGE           ("Components",          "Web Cameras",          0),
        OPEN_TABLES_PAGE                ("Tablets",             null,                   1),
        OPEN_SOFTWARE_PAGE              ("Software",            null,                   0),
        OPEN_PHONES_AND_PDAS_PAGE       ("Phones & PDAs",       null,                   3),
        OPEN_CAMERAS_PAGE               ("Cameras",             null,                   2),
        OPEN_TEST_11_PAGE               ("MP3 Players",         "test 11",              0),
        OPEN_TEST_12_PAGE               ("MP3 Players",         "test 12",              0),
        OPEN_TEST_15_PAGE               ("MP3 Players",         "test 15",              0),
        OPEN_TEST_16_PAGE               ("MP3 Players",         "test 16",              0),
        OPEN_TEST_17_PAGE               ("MP3 Players",         "test 17",              0),
        OPEN_TEST_18_PAGE               ("MP3 Players",         "test 18",              0),
        OPEN_TEST_19_PAGE               ("MP3 Players",         "test 19",              0),
        OPEN_TEST_20_PAGE               ("MP3 Players",         "test 20",              0),
        OPEN_TEST_21_PAGE               ("MP3 Players",         "test 21",              0),
        OPEN_TEST_22_PAGE               ("MP3 Players",         "test 22",              0),
        OPEN_TEST_23_PAGE               ("MP3 Players",         "test 23",              0),
        OPEN_TEST_24_PAGE               ("MP3 Players",         "test 24",              0),
        OPEN_TEST_4_PAGE                ("MP3 Players",         "test 4",               0),
        OPEN_TEST_5_PAGE                ("MP3 Players",         "test 5",               0),
        OPEN_TEST_6_PAGE                ("MP3 Players",         "test 6",               0),
        OPEN_TEST_7_PAGE                ("MP3 Players",         "test 7",               0),
        OPEN_TEST_8_PAGE                ("MP3 Players",         "test 8",               0),
        OPEN_TEST_9_PAGE                ("MP3 Players",         "test 9",               0);




        final public String menuItems;
        final public String subMenuItem;
        final public Integer quantity;


        MenuData(String menuItems, String subMenuItem, Integer quantity) {
            this.menuItems = menuItems;
            this.subMenuItem = subMenuItem;
            this.quantity = quantity;


        }
    }

    @ParameterizedTest
    @EnumSource(MainMenuNavigationJUnitTest.MenuData.class)
    public void clickMenuItems (MenuData data) throws InterruptedException {
        if (data.subMenuItem != null) {
            mainMenuPage.clickSubMenuItem(data.menuItems, data.subMenuItem);
        }else {
            mainMenuPage.clickMenuItem(data.menuItems);
        }
        Thread.sleep(1000);
        Assertions.assertEquals(mainMenuPage.getProductItemsCount(),data.quantity);
    }
}
