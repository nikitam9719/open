package testClasses.demo;

import base.Base;
import org.testng.annotations.Test;
import responsesFromServer.jsonModels.Card;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testNames.TestNames;

import static testNames.CaseNames.CN_001;

/**
 * Created by AnatolyRogov on 20.06.17.
 */
@Features("Back")
public class DemoApi extends Base {
    @Stories("Api Test")
    @Test()
    @TestNames(CN_001)
    public void DemoTest2() {
        Card cardModel = TEST_STEPS_DEMO_API.getCardInfo();
        TEST_STEPS_DEMO_API.checkBalance(cardModel);
    }
}
