package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import pages.MenuPage;


public class SiteMenuTest extends BaseTest {

    MenuPage menuPage;
    ItemDetailsPage itemDetailsPage;
    @BeforeClass
    public void initialise() {
        menuPage = new MenuPage(driver);
        itemDetailsPage=new ItemDetailsPage(driver);
    }

    @Test
    public void checkingTheSiteMenu() {
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickingOnTheShoppingCart();
        menuPage.clickMenuPage();
        menuPage.clickAllItemsMenu();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(), "Doesn't go to product page");
        menuPage.clickMenuPage();
        menuPage.clickLogoutMenu();
        Assert.assertTrue(loginPage.isLoginPage(),
                "There was no transition to the registration page");
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickAddToCartButton();
        menuPage.clickMenuPage();
        menuPage.clickResetMenu();
        Assert.assertTrue(itemDetailsPage.isRemoveButton(),
                "Reset app state, did not occur");
        menuPage.clickAboutMenu();
        Assert.assertTrue(menuPage.isAboutMenu(),
                "There was no transition to the site https://saucelabs.com");
    }
}
