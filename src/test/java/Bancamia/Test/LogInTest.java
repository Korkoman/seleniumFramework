package Bancamia.Test;

import com.Demoqa.DemoQaRadioButtonTest;
import com.bancamía.Bancamia.LogIn;
import com.demoqaPages.DemoqaRadioButtonPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utilityLayer.AndroidIListenerClass;
import utilityLayer.IListenerClass;
import utilityLayer.WaitsConfig;

@Listeners(AndroidIListenerClass.class)
public class LogInTest {

    public static AndroidDriver driver= AndroidIListenerClass.driver;
    private final LogIn logIn = new LogIn(driver);
    public static WaitsConfig waitsConfig = null;
    public static final Logger logger = LogManager.getLogger(LogInTest.class);

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        AndroidIListenerClass.setExtentReport(this.getClass().getSimpleName());
        waitsConfig = new WaitsConfig(driver);
        logger.debug("setUp de la clase listo.");
    }
    @AfterClass
    public void tearDownAfterClass() throws Exception {
        driver.quit();
        AndroidIListenerClass.extent.flush();
    }

    @AfterMethod
    public void tearDown() {
        logger.debug("Test terminado");
    }

    @Test
    public void logInTest() {
        Assert.assertTrue(logIn.logIn());
    }


}
