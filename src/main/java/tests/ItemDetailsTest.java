package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;


public class ItemDetailsTest extends BaseTest {
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    final static String PRODUCT_PRICE = "$49.99";
    final static String PRODUCT_DESCRIPTION = "It's not every day that you come across a midweight quarter-zip fleece" +
            " jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";

    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemPrice(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");
        itemDetailsPage.clickAddToCartButton();
        // navigate to cart page
        // bla bla bla

    }
    @Test
    public void checkTheAddedItemInTheCart() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickingOnTheShoppingCart();
        Assert.assertEquals(itemDetailsPage.getItemNameInBasket(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemPriceInBasket(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemDescriptionInBasket(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");

    }
}
