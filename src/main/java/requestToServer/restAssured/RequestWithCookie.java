package requestToServer.restAssured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.jayway.restassured.RestAssured.given;
import static utils.RestAssured.generateURI;

/**
 * Created by AnatolyRogov on 18.06.17.
 */
public class RequestWithCookie {

    Map<String, String> cookieMap = new HashMap<>();
    RestAssuredConfig cfg;

    public void configuration(Set<Cookie> myCookie) {
        cookieMap = ConvertSetToMap(myCookie);
        String curDir = new File("").getAbsolutePath();
        SSLConfig sslConf = SSLConfig.sslConfig().allowAllHostnames()
                .keystore(new File(curDir + "\\path\\to\\Certificate"), "pass")
                .relaxedHTTPSValidation();
        cfg = RestAssured.config().sslConfig(sslConf);
    }

    private Map<String, String> ConvertSetToMap(Set<Cookie> set) {
        Map<String, String> map = new HashMap<>();
        for (Cookie temp: set) {
            map.put(temp.getName(), temp.getValue());
        }
        return map;
    }

    @Step("Посылаем запрос по адресу {0}")
    public Response getRequest(String path) {
        try {
            Response response = given().config(cfg).cookies(cookieMap).get(generateURI(path));
            attachJson("Ответ по URL:", response.asString());
            return response;
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось корректно отправить запрос" + e);
        }
    }

    @Attachment(value = "{0}", type = "application/json")
    private static byte[] attachJson(String descr, String json) {
        return json.getBytes();
    }

}
