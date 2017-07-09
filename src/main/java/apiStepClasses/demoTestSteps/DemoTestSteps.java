package apiStepClasses.demoTestSteps;

import org.testng.Assert;
import responsesFromServer.jsonModels.Card;
import ru.yandex.qatools.allure.annotations.Step;

import static requestToServer.generalPathes.GeneralPathes.getDemoPath;
import static requestToServer.restAssured.Request.getRequest;

/**
 * Created by AnatolyRogov on 20.06.17.
 */
public class DemoTestSteps {
    @Step("Получить информацию по карте")
    public Card getCardInfo() {
        try {
            Card cardModel;
            cardModel = getRequest(getDemoPath()).as(Card.class);
            return cardModel;
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось замапить ответ" + e);
        }
    }

    public void checkBalance(Card cardModel) {
        try {
            Assert.assertTrue(cardModel.getBalance() > 0);
        } catch (Throwable e) {
            throw new IllegalStateException("Баланс карты меньше 0" + e);
        }
    }
}
