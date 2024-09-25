package com.Demoqa;

import com.demoqaPages.DemoqaChecktBoxPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilityLayer.IListenerClass;
import utilityLayer.PropertiesFile;
import utilityLayer.WaitsConfig;

@Listeners(IListenerClass.class)
public class DemoQaCheckTBoxTest {
    public static WebDriver driver= IListenerClass.driver;
    private final DemoqaChecktBoxPage checkBox = new DemoqaChecktBoxPage(driver);
    private static final String url = PropertiesFile.getProperty("base-url")+"checkbox";
    public static WaitsConfig waitsConfig = null;
    public static final Logger logger = LogManager.getLogger(DemoQaCheckTBoxTest.class);

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
    public void checkBoxHome(){
        checkBox.selectAll();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }

    @Test
    public void checkBoxDesktop(){
        checkBox.selectDesktopElements();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }

    @Test
    public void checkBoxDocuments(){
        checkBox.selectDocumentsElements();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }

    @Test
    public void checkBoxWorkspace(){
        checkBox.selectWorkSpaceElements();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }

    @Test
    public void checkBoxOffice(){
        checkBox.selectOfficeElements();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }

    @Test
    public void checkBoxDownload(){
        checkBox.selectDownloadsElements();
        Assert.assertEquals(DemoqaChecktBoxPage.elementsText, DemoqaChecktBoxPage.resultsText);
    }
}

