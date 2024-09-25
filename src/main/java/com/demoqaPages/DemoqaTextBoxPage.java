package com.demoqaPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


// page_url = https://demoqa.com/text-box
public class DemoqaTextBoxPage {

    private WebDriver driver;

    //TextBoxElements
    @FindBy(xpath = "//*[@id='userName']")
    public WebElement inputUserName;

    @FindBy(xpath = "//*[@id='userEmail']")
    public WebElement inputUserEmail;

    @FindBy(xpath = "//*[@id='currentAddress']")
    public WebElement textareaCurrentAddress;

    @FindBy(xpath = "//*[@id='permanentAddress']")
    public WebElement textareaPermanentAddress;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//div[contains(@class, 'border')]//p")
    public List<WebElement> listOutput;

    private void insertUsername(String userName){
        inputUserName.sendKeys(userName);
    }

    private void insertUserEmail( String userEmail){
        inputUserEmail.sendKeys(userEmail);
    }

    public void insertCurrentAddress(String currentAddress){
        textareaCurrentAddress.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress){
        textareaPermanentAddress.sendKeys(permanentAddress);
    }

    public void clickSubmit(){
         buttonSubmit.click();
    }
    public void completeForm(String userName, String userEmail, String currentAddress, String permanentAddress) throws NoSuchElementException, ElementNotInteractableException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/*")));
        Actions acciones = new Actions(driver);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        //acciones.scrollToElement(buttonSubmit).perform();
        acciones.scrollByAmount(0, 180).perform();
        insertUsername(userName);
        insertUserEmail(userEmail);
        insertCurrentAddress(currentAddress);
        insertPermanentAddress(permanentAddress);
        clickSubmit();
    }
    public DemoqaTextBoxPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        this.driver = driver;
    }
}