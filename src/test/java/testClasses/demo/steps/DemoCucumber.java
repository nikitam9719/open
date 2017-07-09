package testClasses.demo.steps;
import com.codeborne.selenide.Condition;
import base.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testNames.TestNames;

import java.util.List;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static testNames.CaseNames.CN_000;
import static testNames.CaseNames.CN_002;

/**
 * Created by nikit on 09.07.2017.
 */
@Features("Front")
public class DemoCucumber extends Base {
String url;
String title;
@When("^I access the page at url (.*)$")
    public void geturl(String Url)
    {
        url=Url;
    }
@Then("^I should see the title (.*)$")
    public void gettitle(String Title)
    {
        title=Title;
    }
@Then("^check if it`s true")
@Stories("Cucumbertest")
@Test
@TestNames(CN_002)
    public void testall ()
    {
        System.setProperty("env.Url",url);
        SettingsConfiguration();
        beforeSuite();
        TEST_STEPS_HOME_PAGE.openHomePage(URL);
        TEST_STEPS_HOME_PAGE.checkTitle(title);

    }
}
