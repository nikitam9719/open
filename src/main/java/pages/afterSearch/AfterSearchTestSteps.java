package pages.afterSearch;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static utils.Scroll.scrollToElement;
import static utils.WebDriver.isElementVisible;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class AfterSearchTestSteps extends AfterSearchPage {

    @Step("Проверить отображение логотипа банка Открытие")
    public void checkBankLogo() {
        try {
            if(isElementVisible("//div[@class='header']//a[@class='logo white']")) {
                Assert.assertTrue(logoOpenbank().isDisplayed());
            }
        } catch (Throwable e) {
            throw new IllegalStateException("Элемент не существует и не отображается");
        }
    }

    @Step("Опуститься вниз страницы и взять номер телефона")
    public void goDownPage() {
        try {
            Thread.sleep(3000);
            SelenideElement webElement = scrollToElement(downPartPage());
            Thread.sleep(3000);
            String mobileNumber = webElement.find(By.xpath("//div[@id='footer_federal_number']")).getText();
            Assert.assertNotNull(mobileNumber);
            System.out.println(mobileNumber);
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось выполнить шаг");
        }

    }

}
