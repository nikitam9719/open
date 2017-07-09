package pages.afterSearch;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class AfterSearchPage {

    public SelenideElement logoOpenbank() {
        return $(By.xpath("//div[@class='header']//a[@class='logo white']"));
    }

    public SelenideElement downPartPage() {
        return $(By.xpath("//div[@class='page-content']//div[@class='columns-row footer-menus']" +
                "//div[@class='columns-4']"));
    }


}
