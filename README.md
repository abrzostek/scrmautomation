# SCRM Automation Test

This project is an implementation of the SCRM Automation Test exercise.

The purpose of this implementation is to test searching for a product in [amazon.es](amazon.es), adding it to the cart and checking the validity of the cart. 

This test covers the case of products for which a modal dialog to offer additional coverage is displayed. For other products a slide-in bar is displayed when adding them to the cart, and this case is not covered by the test.

## Requirements

You need `maven` and `npm` installed in your system. `npm` is used to install `chromedirver` as a dependency and `maven` is used to build the project and run the tests.

## Initial setup

Run `npm install` and `mvn install` in order to install the required dependencies.

## Running the tests

Run `mvn test` in order to run the test suite, You can also run the tests in the `ScrmAutomationTests` class from IntelliJ (the IntelliJ project files are provided).

## Code structure

This project uses **JUnit 5** as the test framework and **Selenium** in order to interact with web pages.

There are two main packages:
* `com.abrzostek.scrmautomation.tests`: Contains the main class with the implementation of the tests, which is `ScrmAutomationTests`.
* `com.abrzostek.scrmautomation.pageobjects`: Contains the classes implementing the PageObject model.

As mentioned, this project uses the commonly used PageObject pattern in order to interact with web pages. Each PageObject is able to locate elements in the page as well as perform some interactions with those elements.

In order to keep maintanability and readability, some common parts of the webapage (such as the header) have been modelled as _components_ inside a web page.

These are the PageObject classes in this project:
* `PageObject`: Parent class of all PageObjects. Includes the member to store the driver and a basic constructor to navigate to a URL.
* `GenericComponent`: Parent class of all components (that is, non-pages). Currently only parent of `Header`.
* `Header`: Header component which models the search bar and link to go to the cart.
* `GenericPage`: Class modelling all web pages. All pages include a `Header` component (that is, the search bar and link to cart are common to all of them) and have common functionality such as retrieving the page title.
* `Home`: Class that models amazon.es' homepage.
* `ProductList`: Class that models the page with search results.
* `Product`: Class that models the product page.
* `AddedToCart`: Class that models the cross-selling page that appears when a product has been added to the cart.
* `Cart`: Class that models the cart page.



