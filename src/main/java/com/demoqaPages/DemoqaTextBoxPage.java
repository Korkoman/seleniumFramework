package com.demoqaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilityLayer.exceptionMessages;

import java.time.Duration;
import java.util.List;


// page_url = https://demoqa.com/text-box
public class DemoqaTextBoxPage {

    private WebDriver driver;
    public static final Logger logger = LogManager.getLogger(DemoqaTextBoxPage.class);

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

        try{inputUserName.sendKeys(userName);
        }catch (NoSuchElementException e){
            logger.error("{} {}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }catch (ElementNotInteractableException e){
            logger.error("{} {}", exceptionMessages.ELEMENTNOTSELECTABLEEXCEPTION, e.getMessage());
        }

    }

    private void insertUserEmail( String userEmail){
        try{inputUserEmail.sendKeys(userEmail);
        }catch (NoSuchElementException e){
            logger.error("{} {}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }catch (ElementNotInteractableException e){
            logger.error("{} {}", exceptionMessages.ELEMENTNOTSELECTABLEEXCEPTION, e.getMessage());
        }

    }

    public void insertCurrentAddress(String currentAddress){
        try{
            textareaCurrentAddress.sendKeys(currentAddress);
        }catch (NoSuchElementException e){
            logger.error("{} {}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }catch (ElementNotInteractableException e){
            logger.error("{} {}", exceptionMessages.ELEMENTNOTSELECTABLEEXCEPTION, e.getMessage());
        }

    }

    public void insertPermanentAddress(String permanentAddress){
        try {
            textareaPermanentAddress.sendKeys(permanentAddress);
        }catch (NoSuchElementException e){
            logger.error("{} {}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }catch (ElementNotInteractableException e){
            logger.error("{} {}", exceptionMessages.ELEMENTNOTSELECTABLEEXCEPTION, e.getMessage());
        }

    }

    public void clickSubmit(){

        try {
            buttonSubmit.click();
        }catch (NoSuchElementException e){
            logger.error("{} {}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }catch (ElementClickInterceptedException e) {
            logger.error("{} {}", exceptionMessages.ELEMENTCLICKINTERCEPTEDEXCEPTION.geteMessage(), e.getMessage());
        }
    }
    public void completeForm(String userName, String userEmail, String currentAddress, String permanentAddress) throws NoSuchElementException, ElementNotInteractableException {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/*")));
            Actions acciones = new Actions(driver);
            acciones.scrollByAmount(0, 180).perform();
            insertUsername(userName);
            insertUserEmail(userEmail);
            insertCurrentAddress(currentAddress);
            insertPermanentAddress(permanentAddress);
            clickSubmit();
        }catch (TimeoutException e){
            logger.error("{} {}",exceptionMessages.TIMEOUTEXCEPTION.geteMessage(), e.getMessage());
        }catch (NoSuchFrameException a){
            logger.error(exceptionMessages.NOSUCHFRAMEEXCEPTION.geteMessage(), a.getMessage());
        }catch (NoSuchDriverException e){
            logger.error("{} {}", exceptionMessages.NOSUCHDRIVEREXCEPTION.geteMessage(), e.getMessage());
        }
    }
    public DemoqaTextBoxPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        this.driver = driver;
    }
}