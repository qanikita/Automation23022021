package ua.kiev.prog.automation.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import ua.kiev.prog.automation.base.Session;

@CucumberOptions(
        features = {"src/test/resources/cucumberTests"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"ua.kiev.prog.automation.cucumber.steps"}
)
public class CucumberTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    public static RemoteWebDriver connection;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "version", "platform" })
    public void setUpClass(String browser, String version, String platform) throws Exception {
        Session.getInstance().wd().get("http://zvisno.com/index.php?route=account/login");
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        Session.getInstance().close();
    }


    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
