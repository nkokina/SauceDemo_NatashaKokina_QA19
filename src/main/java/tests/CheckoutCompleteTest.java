package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.ItemDetailsPage;

public class CheckoutCompleteTest extends BaseTest {

    private final String COMPLETE_HEADER = "THANK YOU FOR YOUR ORDER";
    private final String COMPLETE_TEXT =
            "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ItemDetailsPage itemDetailsPage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void initialise() {
        checkoutPage = new CheckoutPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    public void conformityOfTheGoodsInTheOrderTest() {
        loginPage.login(USERNAME, PASSWORD);
        itemDetailsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTALCODE);
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getCompleteHeader(), COMPLETE_HEADER,
                "The text is incorrect");
        Assert.assertEquals(checkoutCompletePage.getCompleteText(), COMPLETE_TEXT,
                "The text is incorrect");

    }

    @Test
    public void goToProductPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        itemDetailsPage.clickAddToCartButton();
        checkoutPage.clickingOnTheShoppingCart();
        checkoutPage.continuePage(FIRSTNAME, LASTNAME, POSTALCODE);
        checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(),
                "Doesn't go to product page");


    }

}
