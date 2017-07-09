package testClasses.demo;

import base.Base;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import responsesFromServer.jsonModels.Card;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testNames.TestNames;

import java.lang.reflect.Type;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.source;
import static requestToServer.generalPathes.GeneralPathes.getDemoPath;
import static requestToServer.restAssured.Request.getRequest;
import static testNames.CaseNames.CN_000;
import static testNames.CaseNames.CN_001;

/**
 * Created by AnatolyRogov on 16.06.17.
 */

@Features("Front")
public class Demo extends Base{

    @Stories("UI Test")
    @Test
    @TestNames(CN_000)
    public void DemoTest1(){
        TEST_STEPS_HOME_PAGE.openHomePage(URL);
        TEST_STEPS_HOME_PAGE.clickToSearchBtn();
        TEST_STEPS_HOME_PAGE.inputToSearchFrom("курс валюты");
        TEST_STEPS_HOME_PAGE.pressEnterAndCheckCurrentURL(URL);
        TEST_STEPS_AFTER_SEARCH.checkBankLogo();
        TEST_STEPS_AFTER_SEARCH.goDownPage();
    }
}
