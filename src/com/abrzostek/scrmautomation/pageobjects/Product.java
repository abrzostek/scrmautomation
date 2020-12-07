package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class that models the product page.
 */
public class Product extends GenericPage {
    // Price of the product in the summary box on the right of the page
    @FindBy(how = How.ID, using = "price_inside_buybox")
    private WebElement priceInSummaryBox;

    // Button to add product to cart
    @FindBy(how = How.ID, using = "add-to-cart-button")
    private WebElement addToCartButton;

    // Dialog offering additional coverage of electrical items
    @FindBy(how = How.CSS, using = ".a-popover-modal")
    private WebElement coverDialog;

    // "No, thank you" button of coverage dialog
    @FindBy(how = How.ID, using = "siNoCoverage-announce")
    private WebElement coverDialogNoThankYouButton;

    // Close (X) button of coverage dialog
    @FindBy(how = How.CSS, using = ".a-popover-modal .a-button-close")
    private WebElement coverDialogCloseButton;

    public Product(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return this.priceInSummaryBox.getText();
    }

    public void clickOnAddToCart() {
        this.addToCartButton.click();
    }

    public WebElement getCoverDialog() {
        return coverDialog;
    }

    public WebElement getCoverDialogNoThankYouButton() {
        return coverDialogNoThankYouButton;
    }

    public void closeCoverDialog() {
        this.coverDialogCloseButton.click();
    }
}
