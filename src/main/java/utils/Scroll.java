package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class Scroll {

    public static SelenideElement scrollToElement(final SelenideElement webElement) {
        Selenide.executeJavaScript("window.scrollTo(0, arguments[0])",
                webElement.getCoordinates().onPage().getY() - 200);
        return webElement;
    }
}
