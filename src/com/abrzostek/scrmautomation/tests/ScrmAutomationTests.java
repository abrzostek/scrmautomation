package com.abrzostek.scrmautomation.tests;

import com.abrzostek.scrmautomation.pageobjects.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScrmAutomationTests {
    private WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver","node_modules/chromedriver/bin/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void searchProductTest() {
        String searchString = "garmin forerunner";
        String productName = "Garmin Forerunner 45/G Reloj Multisport, Adulto, Unisex, Negro, L";

        // Navigate to amazon homepage and accept cookies
        Home home = new Home(this.driver);
        assertEquals(
                "Amazon.es: compra online de electrónica, libros, deporte, hogar, moda y mucho más.",
                home.getPageTitle()
        );
        home.acceptCookies();

        // Search for a product and verify the product is listed.
        // We also verify there is no product with a completely unrelated keyword.
        ProductList productList = home.getHeader().searchText(searchString);
        List<String> productNames = productList.getProductNames();
        assertTrue(productNames.contains(productName));
        assertThrows(NotFoundException.class, () -> productList.clickOnProductWithName("mandarina"));

        // Go to the product page and note the price - we will use it later to check in the cart
        Product product = productList.clickOnProductWithName(productName);
        String price = product.getPrice();

        // Add the product to the cart. In the case of this product, an additional cover warranty is offered
        // in a modal dialog, which we verify exists and later close.
        product.clickOnAddToCart();

        // The modal dialog takes some time to load and there is an animation when it is being displayed and hidden,
        // so we need to wait for the corresponding elements.
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(product.getCoverDialogNoThankYouButton()),
                ExpectedConditions.visibilityOf(product.getCoverDialog()),
                ExpectedConditions.elementToBeClickable(product.getCoverDialogNoThankYouButton())
        ));
        product.closeCoverDialog();

        // Verify the page confirming the product was added to the cart displays the appropriate text
        AddedToCart addedToCart = new AddedToCart(driver);
        wait.until(ExpectedConditions.visibilityOf(addedToCart.getAddedToCartMessage()));
        assertEquals("Añadido a la cesta", addedToCart.getAddedToCartMessage().getText());

        // Go to the cart page
        Cart cart = addedToCart.getHeader().clickOnCartLink();

        // Verify there is an item with the same name as the product we added
        assertEquals(1, cart.getItemsWithName(productName).size());
        String cartPrice = cart.getPriceOfItemsWithName(productName).get(0);
        assertEquals(price, cartPrice);
    }

    @AfterEach
    public void tearDown() {
        this.driver.close();
    }
}