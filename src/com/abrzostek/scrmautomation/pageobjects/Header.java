package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Header component which models the search bar and link to go to the cart.
 */
public class Header extends GenericComponent {

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "nav-cart")
    private WebElement cartLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    /**
     * Searches for the specified text in the search bar.
     * @param text The text to search
     * @return A ProductList PageObject class.
     */
    public ProductList searchText(String text) {
        this.searchField.sendKeys(text);
        this.searchField.sendKeys(Keys.RETURN);

        return new ProductList(driver);
    }

    /**
     * Navigates to the cart.
     * @return A Cart PageObject class.
     */
    public Cart clickOnCartLink() {
        this.cartLink.click();
        return new Cart(driver);
    }
}
