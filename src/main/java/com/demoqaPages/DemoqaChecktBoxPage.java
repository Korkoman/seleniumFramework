package com.demoqaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static interactionLayer.DriverFactory.driver;


// page_url = https://demoqa.com/check-box
public class DemoqaChecktBoxPage {

    private static final Logger logger = LogManager.getLogger(DemoqaChecktBoxPage.class);
    private  WebDriverWait wait;
    Actions acciones = new Actions(driver);
    public DemoqaChecktBoxPage(WebDriverWait wait) {
        this.wait = wait;
    }

     private String exceptionMSg = "{} No se un elemento con el que se pueda interactuar.";

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")
     private WebElement homeCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
     private WebElement homeButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]")
     private WebElement desktopCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
     private WebElement desktopButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]")
     private WebElement documentsCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
     private WebElement documentsButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/label/span[1]")
     private WebElement workSpaceCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")
     private WebElement workSpaceButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[1]")
     private WebElement officeCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
     private WebElement officeButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")
     private WebElement downloadsCheckBox;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")
     private WebElement downloadsButton;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/descendant::ol/li/span" )
     private List<WebElement> homeElements = new ArrayList<>();

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/descendant::*[@class='rct-title']")
     List<WebElement> desktopElements;

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li" )
     private List<WebElement> documentsElements = new ArrayList<>();

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/descendant::*[@class='rct-title']")
     private List<WebElement> workSpaceElements = new ArrayList<>();

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/descendant::*[@class='rct-title']")
     private List<WebElement> officeElements = new ArrayList<>();

     @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/descendant::*[@class='rct-title']")
     List<WebElement> downloadsElements = new ArrayList<>();

    public static List <String>elementsText;

     @FindBy(xpath = "//span[@class='text-success']")
     public static List<WebElement> results = new ArrayList<>();
     public static List<String> resultsText;

      void hitHomeButton(){
         try{
             homeButton.click();
         }catch (ElementNotInteractableException e){
             logger.fatal(exceptionMSg, e.getMessage());
         }
     }

    private void hitDesktopButton(){
        try{
            desktopButton.click();
        }catch (ElementNotInteractableException e){
            logger.fatal(exceptionMSg, e.getMessage());
        }
    }

    private void hitDocumentsButton(){
        try{
            documentsButton.click();
        }catch (ElementNotInteractableException e){
            logger.fatal(exceptionMSg, e.getMessage());
        }
    }

    private void hitWorkspaceButton(){
        try{
            workSpaceButton.click();
        }catch (ElementNotInteractableException e){
            logger.fatal(exceptionMSg, e.getMessage());
        }
    }

    private void hitOfficeButton(){
        try{
            officeButton.click();
        }catch (ElementNotInteractableException e){
            logger.fatal(exceptionMSg, e.getMessage());
        }
    }

    private void hitDownloadsButton(){
        try{
            downloadsButton.click();
        }catch (ElementNotInteractableException e){
            logger.fatal(exceptionMSg, e.getMessage());
        }
    }

    public void selectAll() {
        try {
            if (homeCheckBox.isEnabled() && !homeCheckBox.isSelected()) {
                acciones.scrollByAmount(0, 500).perform();
                hitHomeButton();
                hitDesktopButton();
                hitDocumentsButton();
                hitWorkspaceButton();
                hitOfficeButton();
                hitDownloadsButton();
                elementsText = retornaTextos(homeElements);
                homeCheckBox.click();
                resultsText = results.stream().map(a -> a.getText().toLowerCase()).toList();
                logger.info("Todos los elementos de " + homeCheckBox.getText() + " han sido seleccionado");
            } else {
                logger.info("El elemento " + homeCheckBox.getText() + " ya estaba seleccionado");
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            logger.fatal("{} No se pudo interactuar con el elemento", e);
     }

    }

    public void selectDesktopElements(){
         try{
             hitHomeButton();
             hitDesktopButton();
             desktopCheckBox.click();
             setListas(desktopElements,results);
         }catch(NoSuchElementException|ElementNotInteractableException e){
             logger.fatal(exceptionMSg, e.getMessage());
         }
    }


        public void selectDocumentsElements(){
          try{
              hitHomeButton();
              hitDocumentsButton();
              documentsCheckBox.click();

          }catch (ElementNotInteractableException e){
              logger.fatal(exceptionMSg, e.getMessage());
          }
        }

        public void selectWorkSpaceElements(){
            hitHomeButton();
            hitDocumentsButton();
            workSpaceButton.click();
            workSpaceCheckBox.click();
            setListas(workSpaceElements, results);
        }

        public void selectOfficeElements(){
            acciones.scrollByAmount(0,500).perform();
            hitHomeButton();
            hitDocumentsButton();
            officeButton.click();
            officeCheckBox.click();
            setListas(officeElements, results);
            System.out.println(elementsText);
            System.out.println(resultsText);
        }

        public void selectDownloadsElements(){
          hitHomeButton();
          hitDownloadsButton();
          downloadsCheckBox.click();
          setListas(downloadsElements, results);
        }
    public List<String> retornaTextos(List<WebElement> lista){
        if(lista.stream().map(WebElement::getText).anyMatch(a -> a.contains(".doc"))){
            return lista.stream().map(e -> e.getText().toLowerCase().replace(".doc"," ").replace(" ","")).toList();
        }else{
            return lista.stream().map(e -> e.getText().toLowerCase()).toList();
        }
    }

    public void setListas(List<WebElement> listaElements, List<WebElement> listaResults){
        elementsText = retornaTextos(listaElements);
        resultsText = retornaTextos(listaResults);
    }
    public DemoqaChecktBoxPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }
}

