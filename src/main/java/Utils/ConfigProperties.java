package Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigProperties {
    private static final Properties PROPERTIES;
    //    declare of variables for config file values
    public static final String BASE_URL;
    public static final String CHROME_DRIVER_PATH;
    public static final String IMP_WAIT;
    public static final String USER_NAME;
    public static final String USER_PWD;
    public static final String BROWSER;
    public static final String IE_DRIVER_PATH;
    public static final String IS_REMOTE;
    public static final String REMOTE_URL;

    //this class helps to get data from config file
    static {
        PROPERTIES = new Properties();
        URL props = ClassLoader.getSystemResource("config.properties");
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        initialize of variables from config file
        BASE_URL = PROPERTIES.getProperty("url");
        CHROME_DRIVER_PATH = PROPERTIES.getProperty("chromeDriverPath");
        IE_DRIVER_PATH = PROPERTIES.getProperty("ieDriverPath");
        IMP_WAIT = PROPERTIES.getProperty("imp.wait");
        USER_NAME = PROPERTIES.getProperty("user_name");
        USER_PWD = PROPERTIES.getProperty("user_pwd");
        BROWSER = PROPERTIES.getProperty("browser");
        IS_REMOTE = PROPERTIES.getProperty("isRemote");
        REMOTE_URL = PROPERTIES.getProperty("remoteUrl");
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}