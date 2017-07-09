package requestToServer.restAssured;

import com.jayway.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import static com.jayway.restassured.RestAssured.given;
import static utils.RestAssured.generateURI;

/**
 * Created by AnatolyRogov on 18.06.17.
 */
public class Request {

    @Step("Посылаем запрос по адресу {0}")
    public static Response getRequest(String path) {
        try {
            Response response = given().get(generateURI(path));
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
