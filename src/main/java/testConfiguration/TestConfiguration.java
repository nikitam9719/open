package testConfiguration;

/**
 * Created by AnatolyRogov on 18.06.17.
 */
public class TestConfiguration {

    private String HUB_URL;
    private String BROWSER;
    private String URL;
    private String URL_API_TEST;

    public TestConfiguration() {
        if(System.getProperty("env.Hub_URL") == null) {
            HUB_URL = "http://127.0.0.1:4444/wd/hub";
        } else {
            HUB_URL = System.getProperty("env.Hub_URL");
        }

        if(System.getProperty("env.Browser") == null) {
            BROWSER = "chrome";
        } else {
            BROWSER = System.getProperty("env.Browser");
        }

        if(System.getProperty("env.Url") == null) {
            URL = "http://open.ru";
        }else {
            URL = System.getProperty("env.Url");
        }
        if(System.getProperty("env.Url_Api_Test") == null) {
            URL_API_TEST = "http://kn-ktapp.herokuapp.com";
        }else {
            URL_API_TEST = System.getProperty("env.Url_Api_Test");
        }
    }

    public String getHUB_URL() {
        return HUB_URL;
    }

    public String getBROWSER() {
        return BROWSER;
    }

    public String getURL() {
        return URL;
    }

    public String getURL_API_TEST() {
        return URL_API_TEST;
    }
}