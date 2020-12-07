package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that models the page with search results.
 */
public class ProductList extends GenericPage {
    @FindBy(how = How.CSS, using = "div[data-component-type='s-search-result']")
    private List<WebElement> products;

    public ProductList(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<String>();
        for (WebElement product : products) {
            productNames.add(product.findElement(By.cssSelector("h2 span")).getText());
        }
        return productNames;
    }

    /**
     * Clicks on the product with the specified exact name.
     * @param name The name of the product.
     * @return A Product PageObject class
     * @throws NotFoundException if a product with the specified name could not be found.
     */
    public Product clickOnProductWithName(String name) throws NotFoundException {
        for (WebElement product : products) {
            WebElement linkElement = product.findElement(By.cssSelector("h2 a"));

            if (name.equals(linkElement.findElement(By.cssSelector("span")).getText())) {
                linkElement.click();
                return new Product(driver);
            }
        }

        throw new NotFoundException("No product was found with the specified name");
    }
}
