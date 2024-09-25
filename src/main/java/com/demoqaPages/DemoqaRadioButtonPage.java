package com.demoqaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;

import static interactionLayer.DriverFactory.driver;


// page_url = https://demoqa.com/radio-button
public class DemoqaRadioButtonPage {
    private static final Logger logger = LogManager.getLogger(DemoqaRadioButtonPage.class);

    private String msgg = "No se puede interactuar con el elemento{}";

    @FindBy(xpath = "//input[@type= 'radio' and @id='yesRadio']")
    private WebElement yesRadio;

    @FindBy(xpath = "//*[@type= 'radio' and @id='yesRadio']/following::label[@for='yesRadio']")
    public WebElement getYesRadio;

    @FindBy(xpath = "//input[@type= 'radio' and @id='impressiveRadio']")
    private WebElement impressiveRadio;

    @FindBy(xpath = "//*[@type= 'radio' and @id='yesRadio']/following::label[@for='impressiveRadio']")
    public WebElement getImpressiveRadio;

    @FindBy(xpath = "//input[@type= 'radio' and @id='noRadio']")
    private WebElement noRadio;

    @FindBy(xpath = "//*[@type= 'radio' and @id='yesRadio']/following::label[@for='noRadio']")
    public WebElement getNoRadio;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p/span")
    public WebElement result;

    public void selectYes(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement radioButton = (WebElement) js.executeScript("return document.evaluate(\"//input[@type='radio' and @id='yesRadio']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");

        try{
            if(radioButton.isSelected()){
                js.executeScript("arguments[0].clear();", radioButton);
                js.executeScript("arguments[0].click();", radioButton);
            }else {
                js.executeScript("arguments[0].click();", radioButton);
            }
        }catch (NoSuchElementException | ElementNotInteractableException e){
            logger.error(msgg, e.getMessage());
        }

    }

    public void selectImpressive(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement radioButton = (WebElement) js.executeScript("return document.evaluate(\"//input[@type= 'radio' and @id='impressiveRadio']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");

        try{
            if(radioButton.isSelected()){
                js.executeScript("arguments[0].clear();", radioButton);
                js.executeScript("arguments[0].click();", radioButton);
            }else {
                js.executeScript("arguments[0].click();", radioButton);
            }
        }catch (NoSuchElementException | ElementNotInteractableException e){
            logger.error(msgg, e.getMessage());
        }

    }

    public boolean selectNo(){
        try{
            noRadio.click();
            return false;
        }catch (ElementNotInteractableException e){
            logger.error(msgg, e.getMessage());
            return true;
        }
    }

    public DemoqaRadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}