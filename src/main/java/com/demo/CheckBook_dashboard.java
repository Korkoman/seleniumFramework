package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// page_url = https://app.checkbook.io/login?redirect=%2Faccount%2Fdashboard
public class CheckBook_dashboard {

    public CheckBook_dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}