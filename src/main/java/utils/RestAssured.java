package utils;

import base.Base;
import testConfiguration.TestConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by AnatolyRogov on 19.06.17.
 */
public class RestAssured extends Base {

    public static URI generateURI(String path){
        TestConfiguration config = new TestConfiguration();
        try {
            URI uri = new URI(config.getURL_API_TEST() + path);
            return uri;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
