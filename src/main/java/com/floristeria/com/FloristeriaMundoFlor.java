package com.floristeria.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static interactionLayer.DriverFactory.driver;

// page_url = https://www.floristeriamundoflor.com/
public class FloristeriaMundoFlor {

    private Actions acciones = new Actions(driver);
    private  int indice = new Random().nextInt(1,9);

    @FindBy(xpath = "//*[@id='menu-item-2794']/a")
     private WebElement agradecimientosLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div")
    public WebElement productGrid;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[3]/div")
    public List<WebElement> productos;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[1]/div/div[1]/descendant::a")
    private List <WebElement> addCartButtons;


    public void agradecimientos() {
        agradecimientosLink.click();
    }

    public void agregarAlCarro(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        agradecimientos();
        for (int i = 0; i <= 1; i++) {
            acciones.moveToElement(productos.get(indice)).perform();
            wait.until(ExpectedConditions.elementToBeClickable(addCartButtons.get(indice)));
            addCartButtons.get(indice).click();
        }

    }
    public FloristeriaMundoFlor(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}