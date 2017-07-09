package pages.home;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.Dimension;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Screenshot.takeScreenshotWebElement;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class HomePageTestSteps extends HomePage {

    @Step("Открыть браузер на указанной страниц")
    public void openHomePage(String url) {
        Selenide.open(url);
        getWebDriver().manage().window().maximize();
    }

    @Step("Нажать на кнопку поиска")
    public void clickToSearchBtn() {
        try {
            Thread.sleep(3000);
            takeScreenshotWebElement("Снимок элемента \"Поиск\"",
                    $(By.xpath("//div[@class='shadow']")));
            btnSearch().click();
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось нажать на кнопку поиска" + e);
        }
    }

    @Step("Ввести в строку поиска \"{0}\" ")
    public void inputToSearchFrom(String text) {
        try {
            inputSearchForm().setValue(text);
            Thread.sleep(3000);
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось ввеси текст в строку поиска" + e);
        }
    }

    @Step("Нажать enter и убедиться в переходе на новую страницу")
    public void pressEnterAndCheckCurrentURL(String url) {
        try {
            Thread.sleep(3000);
            inputSearchForm().pressEnter();
            Assert.assertNotEquals(url, getWebDriver().getCurrentUrl(),
                    "Переход на новую страницу не осуществился");
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось проверить переход на другую страницу");
        }
    }
    @Step("Проверить заголовок страницы")
    public void checkTitle(String title) {
        try {
            Thread.sleep(3000);
            Assert.assertEquals(title, getWebDriver().getTitle());
        } catch (Throwable e) {
            throw new IllegalStateException("Заголовки не совпали");
        }
    }
}
