package com.Demoqa;


import com.demoqaPages.DemoQaMainPage;
import jdk.jfr.Name;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilityLayer.IListenerClass;
import utilityLayer.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;



import java.io.IOException;

@Listeners(IListenerClass.class)
public class DemoQaMainTest {

    public static WebDriver driver= IListenerClass.driver;
    private final DemoQaMainPage mainPage = new DemoQaMainPage(driver);
    private static final String url = PropertiesFile.getProperty("base-url")+"elements";
    public static final Logger logger = LogManager.getLogger(DemoQaMainTest.class);



    @BeforeClass
    public void setUp() throws IOException {
        logger.trace("Se setea la reportería");
        logger.trace("Se abre el driver");
        IListenerClass.setExtentReport(this.getClass().getSimpleName());
        driver.get(url);
        logger.trace("La página ya está cargada");
    }

    @AfterClass
    public void tearDown() {
       driver.quit();
       IListenerClass.extent.flush();
    }

    @Test( priority = 1)
    @Name("Prueba text box")
    public void demoQaMainPageTextBox() throws IOException {
           logger.trace("Inicia la prueba");
           logger.trace("Se da click sobre el menú en la opción de text-box");
           mainPage.pruebaElementosPaginaInicial(0);
           logger.trace("Se valida la url");
           Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-bo");

    }@Test
    public void demoQaMainPageCheckBox() {

        mainPage.pruebaElementosPaginaInicial(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");

    }@Test
    public void demoQaMainPageRadioButton() {

        mainPage.pruebaElementosPaginaInicial(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");


    }@Test
    public void demoQaMainPageWebTables() {

        mainPage.pruebaElementosPaginaInicial(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables");

    }@Test
    public void demoQaMainPageButtons() {

        mainPage.pruebaElementosPaginaInicial(4);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons");

    }@Test
    public void demoQaMainPageLinks() {

        mainPage.pruebaElementosPaginaInicial(5);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/links");

    }@Test
    public void demoQaMainPageBrokenLinks() {
        mainPage.pruebaElementosPaginaInicial(6);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/broken");

    }
    @Test
    public void demoQaMainPageUploadAndDownLoad() {
        mainPage.pruebaElementosPaginaInicial(7);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/upload-download");

    }@Test
    public void demoQaMainPageDynamicProperties() {
        mainPage.pruebaElementosPaginaInicial(8);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/dynamic-properties");

    }
}
