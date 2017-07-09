package base;

import apiStepClasses.demoTestSteps.DemoTestSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.afterSearch.AfterSearchTestSteps;
import pages.home.HomePageTestSteps;
import testConfiguration.TestConfiguration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by AnatolyRogov on 16.06.17.
 */
@Listeners(TestListeners.class)
public class Base {

    public String URL;
    public String URL_API_TEST;

    protected final HomePageTestSteps TEST_STEPS_HOME_PAGE = new HomePageTestSteps();
    protected final AfterSearchTestSteps TEST_STEPS_AFTER_SEARCH = new AfterSearchTestSteps();
    protected final DemoTestSteps TEST_STEPS_DEMO_API = new DemoTestSteps();


    @BeforeMethod(alwaysRun = true)
    public void SettingsConfiguration(){
        TestConfiguration testConfiguration = new TestConfiguration();
        Configuration.remote = testConfiguration.getHUB_URL();
        Configuration.browser = testConfiguration.getBROWSER();
        this.URL = testConfiguration.getURL();
        this.URL_API_TEST = testConfiguration.getURL_API_TEST();
    }

    @BeforeSuite
    public void beforeSuite(){
        Configuration.timeout = 46000;
        Configuration.collectionsTimeout = 67000;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }


}
