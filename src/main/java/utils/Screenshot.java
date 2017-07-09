package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
/**
 * Created by AnatolyRogov on 18.06.17.
 */
public class Screenshot {
    public static final Logger LOGGER = Logger.getLogger(Screenshot.class.getName());

    public static void takeScreenshotFullPage(String attachmentName){

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            WebDriver webDriver = new Augmenter().augment(getWebDriver());
            BufferedImage bufferedImage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(webDriver).getImage();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            saveScreenshot(attachmentName, baos.toByteArray());
        } catch (Exception ex){
            LOGGER.severe("Unable to take screenshot: " + ex);
        }
    }

    public static void takeScreenshotWebElement(String attachmentName, SelenideElement webElement){

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            WebDriver webDriver = new Augmenter().augment(getWebDriver());
            BufferedImage bufferedImage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(webDriver, webElement.toWebElement()).getImage();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            saveScreenshot(attachmentName, baos.toByteArray());
        } catch (Exception ex){
            LOGGER.severe("Unable to take screenshot: " + ex);
        }
    }



    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveScreenshot(String name, byte[] screenshot){
        return screenshot;
    }

}
