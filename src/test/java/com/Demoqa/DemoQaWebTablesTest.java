package com.Demoqa;

import com.demoqaPages.DemoQaWebTablesPage;
import dataProvider.DemoQaDataProvider;
import modelos.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilityLayer.IListenerClass;
import utilityLayer.PropertiesFile;
import utilityLayer.WaitsConfig;

import java.io.FileNotFoundException;
import java.io.IOException;


@Listeners(IListenerClass.class)
public class DemoQaWebTablesTest {
    public static WebDriver driver= IListenerClass.driver;
    private final DemoQaWebTablesPage webTables = new DemoQaWebTablesPage(driver);
    private static final String url = PropertiesFile.getProperty("base-url")+"webtables";
    public static WaitsConfig waitsConfig = null;
    public static final Logger logger = LogManager.getLogger(DemoQaWebTablesTest.class);


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


    @Test(dataProvider = "excelData", dataProviderClass = DemoQaDataProvider.class)
    public void test(@Optional String firstName, String lastName, String email, String age, String salary, String department ) throws IOException {
        Usuario user = new Usuario(firstName,lastName,email,Integer.parseInt(age),Double.parseDouble(salary),department);
        webTables.registrarUsuario(firstName, lastName, email, age, salary, department);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(webTables.comparingUsers(user));
    }

    @Test
    public void paginacion() throws FileNotFoundException {
        webTables.findUserByEmail();
        Assert.assertFalse(webTables.nonEmptyResultRows.isEmpty());
    }

    @AfterClass
    public void afterClass(){
      try{
        driver.close();
    }catch(Exception e){}
      finally {
          driver.quit();
      }
    }
}
