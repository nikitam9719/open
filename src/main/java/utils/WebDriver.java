package utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class WebDriver {

    //проверка существования элемента
    public static boolean isElementVisible(String xPath){
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 1, 200);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
