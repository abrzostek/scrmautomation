package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that models the cart page.
 */
public class Cart extends GenericPage {
    @FindBy(how = How.CSS, using = "div[data-name='Active Items']")
    private WebElement itemsElement;

    public Cart(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns all items matching the specified name.
     * @param name The name of the product
     * @return List of WebElement of items with the specified name.
     */
    public List<WebElement> getItemsWithName(String name) {
        List<WebElement> itemsWithName = new ArrayList<>();

        List<WebElement> items = this.itemsElement.findElements(
                By.cssSelector(".sc-list-item-content")
        );

        for (WebElement element : items) {
            WebElement nameElement = element.findElement(By.cssSelector("span.a-list-item span.sc-product-title"));
            if (name.equals(nameElement.getText().trim())) {
                itemsWithName.add(element);
            }
        }

        return itemsWithName;
    }

    /**
     * Returns all prices of items matching the specified name.
     * @param name The name of the product
     * @return List of String of prices of products with the specified name.
     */
    public List<String> getPriceOfItemsWithName(String name) {
        List<String> prices = new ArrayList<>();
        List<WebElement> itemsWithName = this.getItemsWithName(name);

        for (WebElement element : itemsWithName) {
            WebElement priceElement = element.findElement(By.cssSelector(".sc-product-price"));
            prices.add(priceElement.getText());
        }
        return prices;
    }
}
