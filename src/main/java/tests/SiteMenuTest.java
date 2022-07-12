package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;


public class SiteMenuTest extends BaseTest {


    ItemDetailsPage itemDetailsPage;
    HomePage homePage;
    @BeforeClass
    public void initialise() {
        homePage = new HomePage(driver);
        itemDetailsPage=new ItemDetailsPage(driver);
    }

    @Test
    public void checkingTheSiteMenu() {
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickingOnTheShoppingCart();
        homePage.clickMenuPage();
        homePage.clickAllItemsMenu();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(), "Doesn't go to product page");
        homePage.clickMenuPage();
        homePage.clickLogoutMenu();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                "There was no transition to the registration page");
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickAddToCartButton();
        homePage.clickMenuPage();
        homePage.clickResetMenu();
        Assert.assertTrue(itemDetailsPage.isRemoveButtonDisplayed(),
                "Reset app state, did not occur");
        homePage.clickAboutMenu();
        Assert.assertTrue( homePage.isAboutMenuDisplayed(),
                "There was no transition to the site https://saucelabs.com");
    }
}
