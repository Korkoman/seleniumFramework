package interactionLayer;

import com.demoqaPages.DemoqaTextBoxPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    public static final Logger logger = LogManager.getLogger(AppiumDriverFactory.class);

    public static AndroidDriver androidDriver() throws MalformedURLException {

        //Capabilities para UIAutomato2
        UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformVersion("13.0");
            options.setDeviceName("Korkoman");
            options.setCapability("autoGrantPermissions", true);
            options.setApp("C:\\Users\\admin\\Desktop\\appETHICALHACKING12052025.apk");
            options.setCapability("noReset", false);
            options.setCapability("fullReset", false);
            options.setCapability("chromedriver_autodownload", true);
            logger.info("Driver creado con exito");
        return  new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }


}
