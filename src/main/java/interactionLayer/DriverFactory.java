package interactionLayer;

import org.openqa.selenium.remote.DesiredCapabilities;
import utilityLayer.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Arrays;


public class DriverFactory {

    public static WebDriver driver;
    private static final String browser = PropertiesFile.getProperty("webdriver.driver");
    private static final String url = PropertiesFile.getProperty("base-url");

    public static WebDriver driver() {

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();
                String[] arguments = PropertiesFile.getProperty("webdriver.chrome.arguments").trim().split(",");
                options.addArguments(Arrays.asList(arguments));
                options.addExtensions(new File("./Extensions/AdBlock 6.4.0.0.crx"));
                driver = new ChromeDriver(options);
                break;

            case "firefox":

                driver = new FirefoxDriver();
                driver.get("http://www.uitestingplayground.com/");
                driver.manage().window().maximize();
                break;

            case "edge":
                driver = new EdgeDriver();
                driver.get("http://www.uitestingplayground.com/");
                driver.manage().window().maximize();

            default:
                System.out.print("Valor no valido");
                break;

        }
        return driver;
    }

    public void tearDown() {

        if (!(driver == null)) {
            driver.quit();
        }
    }
}

