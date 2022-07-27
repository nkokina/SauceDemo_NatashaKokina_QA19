package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ItemDetailsPage;


public class SiteMenuTest extends BaseTest {

    ItemDetailsPage itemDetailsPage;
    BasketPage basketPage;

    @BeforeClass (alwaysRun = true)
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(groups = {"Regression"})
    public void checkingTheSiteMenu() {
        loginPage.login("standard_user", "secret_sauce");
        basketPage.clickingOnTheShoppingCart();
        basketPage.clickMenuPage();
        basketPage.clickAllItemsMenu();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(), "Doesn't go to product page");
        basketPage.clickMenuPage();
        basketPage.clickLogoutMenu();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "There was no transition to the registration page");
        loginPage.login("standard_user", "secret_sauce");
       productsPage.clickAddToCartButton(PRODUCT_NAME);
        basketPage.clickMenuPage();
        basketPage.clickResetMenu();
        Assert.assertTrue(itemDetailsPage.isRemoveButtonDisplayed(),
                "Reset app state, did not occur");
        basketPage.clickAboutMenu();
        Assert.assertEquals(basketPage.isAboutMenuDisplayed(), "https://saucelabs.com",
                "There was no transition to the site https://saucelabs.com");
    }
}

