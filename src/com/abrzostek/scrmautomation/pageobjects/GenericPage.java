package com.abrzostek.scrmautomation.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Class modelling all web pages.
 * All pages include a `Header` component (that is, the search bar and link to cart are common to all of them)
 * and have common functionality such as retrieving the page title.
 */
public class GenericPage extends PageObject {
    final private Header header;

    public GenericPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public GenericPage(WebDriver driver, String pageUrl) {
        super(driver, pageUrl);
        this.header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
