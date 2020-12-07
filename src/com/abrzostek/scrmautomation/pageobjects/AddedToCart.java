package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class that models the cross-selling page that appears when a product has been added to the cart.
 */
public class AddedToCart extends GenericPage {
    @FindBy(how = How.CSS, using = "#huc-v2-order-row-confirm-text h1")
    private WebElement addedToCartMessage;

    public AddedToCart(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddedToCartMessage() {
        return addedToCartMessage;
    }
}
