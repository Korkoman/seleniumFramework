package com.Demoqa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoqaPages.DemoqaTextBoxPage;
import utilityLayer.IListenerClass;
import utilityLayer.PropertiesFile;
import interactionLayer.DriverFactory;
import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilityLayer.Reports;

import java.io.IOException;

import static utilityLayer.IListenerClass.extent;


public class DemoQaTextBoxTest {

    private static final WebDriver driver = IListenerClass.driver;
    private final DemoqaTextBoxPage textBoxPage = new DemoqaTextBoxPage(driver);
    private static String url = PropertiesFile.getProperty("base-url")+"text-box";

    private UserModel userModel= null;


    @BeforeClass
    public void setUp() throws IOException {
        IListenerClass.setExtentReport(this.getClass().getSimpleName());
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @BeforeMethod
    public void setUpUser(){
        userModel = new UserModel("Carlos Pataquiva", "pataquicarlos@carasopa.com","Carrera 59 Este N° 59 - 36" , "Carrera 59 Este N° 59 - 36");
    }

    @Test
    public void textBox(){
        textBoxPage.completeForm(userModel.getNombre(), userModel.getEmail(), userModel.getCurrentAddress(), userModel.getCurrentAddress());
        textBoxPage.clickSubmit();
        UserModel testUserModel = new UserModel(textBoxPage.listOutput.get(0).getText().substring(textBoxPage.listOutput.get(0).getText().indexOf(":")).replace(":",""),
                                                textBoxPage.listOutput.get(1).getText().substring(textBoxPage.listOutput.get(1).getText().indexOf(":")).replace(":",""),
                                                textBoxPage.listOutput.get(2).getText().substring(textBoxPage.listOutput.get(2).getText().indexOf(":")).replace(":",""),
                                                textBoxPage.listOutput.get(3).getText().substring(textBoxPage.listOutput.get(3).getText().indexOf(":")).replace(":","")
        );
        Assert.assertEquals(userModel.toString(), testUserModel.toString());
    }
}
