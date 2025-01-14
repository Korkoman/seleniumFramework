package com.floristeriaTest;

import com.demoqaPages.DemoqaChecktBoxPage;
import com.floristeria.com.FloristeriaMundoFlor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilityLayer.IListenerClass;
import utilityLayer.WaitsConfig;

public class FloristeriaTest {
    public static WebDriver driver= IListenerClass.driver;
    private final FloristeriaMundoFlor checkBox = new FloristeriaMundoFlor(driver);
    private static final String url = "https://www.floristeriamundoflor.com/";
    public static WaitsConfig waitsConfig = null;
    public static final Logger logger = LogManager.getLogger(FloristeriaTest.class);

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        IListenerClass.setExtentReport(this.getClass().getSimpleName());
        waitsConfig = new WaitsConfig(driver);
        logger.debug("setUp de la clase listo.");
    }

    @AfterClass
    public void tearDownAfterClass() throws Exception {
        driver.quit();
        IListenerClass.extent.flush();
    }
    @BeforeMethod
    public void setUp() {
        driver.get(url);
        logger.debug("setUp del método listo.");
    }

    @AfterMethod
    public void tearDown() {
        logger.debug("Test terminado");
    }

    @Test
    public void floristeriatest() {
        checkBox.agradecimientos();
        Assert.assertTrue(checkBox.productGrid.isEnabled());
    }

    @Test
    public void floristeriatestCarrito() {
        checkBox.agregarAlCarro();
        Assert.assertTrue(checkBox.productGrid.isEnabled());
    }



}
