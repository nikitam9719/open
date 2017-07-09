package pages.home;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class HomePage {

    public SelenideElement hrefToSmartCard() {
        return $(By.xpath("//div[@id='nav']//a[contains(text(),'Смарт Карта')]"));
    }

    public SelenideElement btnSearch() {
        return $(By.xpath("//div[@class='header active']//a[@class='b_search']"));
    }

    public SelenideElement inputSearchForm() {
        return $(By.xpath("//div[@class='header active']//form[@id='main_search_form']//input[@class='input']"));
    }
    /*public SelenideElement title() {
        System.out.print($(By.xpath("/html/head/title")).text());
        getWebDriver.get
        return $(By.xpath("/html/head/title"));
    }*/

}
