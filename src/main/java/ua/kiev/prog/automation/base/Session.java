package ua.kiev.prog.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Session {
    final private static ThreadLocal<Session> _instance = new ThreadLocal<>();

    public static  Session getInstance() {
        if(_instance.get() == null) {
            _instance.set(new Session());
        }
        return _instance.get();
    }

    private WebDriver _driver;

    private  Session() {}

    public WebDriver wd() {
        if (_driver == null){
            //Init
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");
            _driver = new ChromeDriver(options);
        }
        return  _driver;
    }

    public void close () {
        if (_driver != null)
            _driver.quit();
        _driver = null;
    }

}
