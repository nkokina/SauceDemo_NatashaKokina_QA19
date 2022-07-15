package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ItemDetailsPage;

public class CheckoutTest extends BaseTest {
    private final static String FIRSTNAME = "z";
    private final static String LASTNAME = "a";
    private final static String POSTALCODE = "123";
    CheckoutPage checkoutPage;
    ItemDetailsPage itemDetailsPage;

    @BeforeMethod
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test
    public void positiveCheckoutTest() {
        loginPage.login(USERNAME, PASSWORD);
        itemDetailsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        Assert.assertTrue(checkoutPage.isCheckoutYourInformationDisplayed(),
                "Doesn't navigate to the page (CHECKOUT: YOUR INFORMATION)");
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTALCODE);
        Assert.assertTrue(checkoutPage.isCheckoutOverviewDisplayed(),
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

