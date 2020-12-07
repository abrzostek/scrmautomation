package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class that models amazon.es' homepage.
 */
public class Home extends GenericPage {
    private static String URL = "https://www.amazon.es";

    @FindBy(how = How.ID, using = "sp-cc-accept")
    private WebElement acceptCookiesButton;

    public Home(WebDriver driver) {
        super(driver, URL);
    }

    public void acceptCookies() {
        this.acceptCookiesButton.click();
    }
}
