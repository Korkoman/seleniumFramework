package utilityLayer;

import com.Demoqa.DemoQaWebTablesTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import interactionLayer.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class IListenerClass implements ITestListener {

    public  static Logger log = LogManager.getLogger(IListenerClass.class);
    public static WebDriver driver = DriverFactory.driver();
    public  static ExtentReports extent = new ExtentReports();
    private ExtentTest test;
    private final ScreenShot screenShot = new ScreenShot(driver);

    public static void setExtentReport(String clase) {
        extent = Reports.setReports(clase);
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test iniciado {}", result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        log.info("Test inicializado {}", result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test {} satisfactorio", result.getMethod().getMethodName());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.fail("La url validada no es correcta.").addScreenCaptureFromPath(screenShot.takeScreenShot(result.getMethod().getMethodName()));
            log.error("La url validada no es correcta.{}", DemoQaWebTablesTest.driver.getCurrentUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
