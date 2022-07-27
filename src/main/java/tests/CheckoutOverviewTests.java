package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.ItemDetailsPage;

public class CheckoutOverviewTests extends BaseTest {
    private final String SUMMARY_TEX_LABEL = "Tax: $2.40";
    private final String ITEM_TOTAL = "Item total: $29.99";
    private final String SUMMARY_TOTAL_LABEL = "Total: $32.39";
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod (alwaysRun = true)
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test(groups = {"Regression"})
    public void conformityOfTheGoodsInTheOrderTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        Assert.assertEquals(checkoutOverviewPage.getItemNameInCheckout(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(checkoutOverviewPage.getItemPriceInCheckout(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(checkoutOverviewPage.getItemDescriptionInCheckout(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");
    }

    @Test (groups = {"Regression"})
    public void totalAmountInTheOrderTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        Assert.assertEquals(checkoutOverviewPage.getSummarySubtotalLabel(),
                ITEM_TOTAL, " Item total not corresponds is price item");
        Assert.assertEquals(checkoutOverviewPage.getSummaryTaxLabel(),
                SUMMARY_TEX_LABEL, "Tax not corresponds");
        Assert.assertEquals(checkoutOverviewPage.getSummaryTotalLabel(), SUMMARY_TOTAL_LABEL,
                "Total not corresponds");
    }

    @Test (groups = {"Smoke"})
    public void gToEndPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isCheckoutCompleteDisplayed(),
                "Going to the finish page didn't work");

    }
}
