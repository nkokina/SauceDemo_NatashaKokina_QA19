package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.ItemDetailsPage;

public class CheckoutTest extends BaseTest {

    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ItemDetailsPage itemDetailsPage;

    @BeforeMethod
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Test
    public void positiveCheckoutTest() {
        loginPage.login(USERNAME, PASSWORD);
        itemDetailsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        Assert.assertTrue(checkoutPage.isCheckoutYourInformationDisplayed(),
                "Doesn't navigate to the page (CHECKOUT: YOUR INFORMATION)");
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTALCODE);
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewDisplayed(),
                "Doesn't navigate to the page (CHECKOUT: OVERVIEW)");

    }

    @Test
    public void negativeCheckoutEmptyLinesTest() {
        loginPage.login(USERNAME, PASSWORD);
        itemDetailsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage("", "", "");
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(), "Error message is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageDisplayed(),
                "Need to fill in blank lines");

    }
}
