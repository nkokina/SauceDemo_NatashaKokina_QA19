package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutCompleteTest extends BaseTest {

    private final String COMPLETE_HEADER = "THANK YOU FOR YOUR ORDER";
    private final String COMPLETE_TEXT =
            "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod (alwaysRun = true)
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test (groups = {"Regression"})
    public void conformityOfTheGoodsInTheOrderTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getCompleteHeader(), COMPLETE_HEADER,
                "The text is incorrect");
        Assert.assertEquals(checkoutCompletePage.getCompleteText(), COMPLETE_TEXT,
                "The text is incorrect");
    }

    @Test (groups = {"Regression"})
    public void goToProductPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTAL_CODE);
        checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(),
                "Doesn't go to product page");
    }

}
