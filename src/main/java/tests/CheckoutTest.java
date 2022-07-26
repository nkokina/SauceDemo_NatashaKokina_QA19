package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod (alwaysRun = true)
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Test(groups = {"Smoke"})
    public void positiveCheckoutTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        Assert.assertTrue(checkoutPage.isCheckoutYourInformationDisplayed(),
                "Doesn't navigate to the page (CHECKOUT: YOUR INFORMATION)");
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewDisplayed(),
                "Doesn't navigate to the page (CHECKOUT: OVERVIEW)");

    }

    @Test(groups = {"Regression", "Negative"})
    public void negativeCheckoutEmptyLinesTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage("", "", "");
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(), "Error message is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageDisplayed(),
                "Need to fill in blank lines");

    }
}
