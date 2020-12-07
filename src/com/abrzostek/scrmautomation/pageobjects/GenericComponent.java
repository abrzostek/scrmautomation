package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Parent class of all components (that is, non-pages). Currently only parent of Header.
 */
public class GenericComponent extends PageObject {
    public GenericComponent(WebDriver driver) {
        super(driver);
    }

    public GenericComponent(WebDriver driver, String pageUrl) {
        super(driver, pageUrl);
    }
}
