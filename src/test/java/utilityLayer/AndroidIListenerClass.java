package utilityLayer;

import com.Demoqa.DemoQaWebTablesTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import interactionLayer.AppiumDriverFactory;
import interactionLayer.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.MalformedURLException;


public class AndroidIListenerClass implements ITestListener {

    public  static Logger log = LogManager.getLogger(AndroidIListenerClass.class);
    public static AndroidDriver driver;

    static {
        try {
            driver = AppiumDriverFactory.androidDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public  static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;
    private static final ScreenShot screenShot = new ScreenShot(driver);


    public static void setExtentReport(String clase) throws IOException {
        extent = Reports.setReports(clase);

    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test iniciado {}", result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        log.info("Test inicializado {}", result.getMethod().getMethodName());

    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
       test.pass("Prueba exitosa!.").addScreenCaptureFromPath(screenShot.takeScreenShot(result.getMethod().getMethodName()));
        log.info("Test {} satisfactorio", result.getMethod().getMethodName());
    }


    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("La url validada no es correcta.").addScreenCaptureFromPath(screenShot.takeScreenShot(result.getMethod().getMethodName()));
    }
}
