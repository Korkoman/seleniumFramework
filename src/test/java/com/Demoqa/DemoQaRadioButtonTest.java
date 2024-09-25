package com.Demoqa;


import com.demoqaPages.DemoqaRadioButtonPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilityLayer.IListenerClass;
import utilityLayer.PropertiesFile;
import utilityLayer.WaitsConfig;

@Listeners(IListenerClass.class)
public class DemoQaRadioButtonTest {

        public static WebDriver driver= IListenerClass.driver;
        private final DemoqaRadioButtonPage radioButton = new DemoqaRadioButtonPage(driver);
        private static final String url = PropertiesFile.getProperty("base-url")+"radio-button";
        public static WaitsConfig waitsConfig = null;
        public static final Logger logger = LogManager.getLogger(DemoQaRadioButtonTest.class);

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
    public void demoQaRadioButtonYes(){
            radioButton.selectYes();
        Assert.assertEquals(radioButton.getYesRadio.getText(), radioButton.result.getText());
    }

    @Test
    public void demoQaRadioButtonImpressive(){
            radioButton.selectImpressive();
            Assert.assertEquals(radioButton.getImpressiveRadio.getText(), radioButton.result.getText());
    }

    @Test
    public void demoQaRadioButtonNo(){
            Assert.assertTrue(radioButton.selectNo());
    }
}
