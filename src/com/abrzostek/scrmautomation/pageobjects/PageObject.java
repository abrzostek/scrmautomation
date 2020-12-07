package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Parent class of all PageObjects.
 * Includes the member to store the driver and a basic constructor to navigate to a URL.
 */
public abstract class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageObject(WebDriver driver, String pageUrl) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }
}
