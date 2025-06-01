package com.bancamía.Bancamia;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilityLayer.exceptionMessages;

import java.time.Duration;


// page_url = about:blank
public class LogIn {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"okButton\"]")
    private WebElement aceptar_terminos;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"INGRESAR\"]")
    private WebElement ingresar_boton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CANCELAR\"]")
    private WebElement cancelar_boton;
    @FindBy(xpath = "//input[@name=\"user\"]")
    private WebElement num_cedula_input;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"send\"]")
    private WebElement send_boton;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"inputPass\"]/android.widget.EditText")
    private WebElement password_input;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"ACEPTAR\"]")
    private WebElement aceptar_boton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Hola Mejoras Dos, tenemos estas opciones para ti:\"]")
    private WebElement banner_bienvenida;
    public static final Logger logger = LogManager.getLogger(LogIn.class);
    private final AndroidDriver driver;
    WebDriverWait wait;


    public boolean logIn(){

        boolean resultado = false;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"okButton\"]")));
            aceptar_terminos.click();
                logger.info("Se aceptan los términos y condiciones. Se muestra pantalla con botón de ingreso");
            ingresar_boton.click();
                logger.info("Se ingresa a la pantalla de LogIn. Se muestra pantalla solicitando actualizar la app.");
            cancelar_boton.click();
                logger.info("Se rechaza la actualización");
             //Se cambia el contexto de la app por webkit para interactuar con el input Número de Documento
            driver.context("WEBVIEW_com.bancamia.movcli");
            System.out.println(driver.getContext());
            System.out.println(driver.getPageSource());
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"user\"]")));
            num_cedula_input.sendKeys("11052228");
             logger.info("Se ingresa con el usuario 11052228");
            driver.context("NATIVE_APP");
            send_boton.click();
            password_input.sendKeys("pruebas1");
             logger.info("Se ingresa password.");
            send_boton.click();
                logger.info("Se muestra pantalla para registrar la huella.");
            cancelar_boton.click();
                logger.info("Se rechaza el registro de huella. Se muestra pantalla indicando que se puede registrar la huella en cualquier momento");
            aceptar_boton.click();
                 logger.info("Se acepta el mensaje de registro de huella.");
            if (banner_bienvenida.isDisplayed()) {
                resultado = true;
                logger.info("Se muestra pantalla principal del usuario");
                logger.info("LogIn Exitoso");
            }else{
                logger.info("LogIn No exitoso");
            }
        }catch (NoSuchElementException e){
            logger.error("{}{}", exceptionMessages.NOSUCHELEMENTEXCEPTION.geteMessage(), e.getMessage());
        }
        return resultado;
    }

    public LogIn(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
        this.driver = driver;
    }
}