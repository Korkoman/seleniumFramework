package com.bancamía.Bancamia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class CDT {

    public CDT(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}