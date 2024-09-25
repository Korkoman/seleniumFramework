package utilityLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    Properties prop = new Properties();
    public PropertiesFile instance = null;
    public String browser;
    public String url;
    private static String route = "src/main/java/configuration/Configuration.properties";

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream props = new FileInputStream(route);
            properties.load(props);
            props.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
