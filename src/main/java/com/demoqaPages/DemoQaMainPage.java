package com.demoqaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

// page_url = https://demoqa.com/elements

public class DemoQaMainPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/div/ul/li")
    private List <WebElement> liItem;

    public DemoQaMainPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    public void pruebaElementosPaginaInicial(Integer index){
        liItem.get(index).click();
    }
}