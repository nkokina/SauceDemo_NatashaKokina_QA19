package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ItemDetailsPage;


public class ItemDetailsTest extends BaseTest {
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    final static String PRODUCT_PRICE = "$49.99";
    final static String PRODUCT_DESCRIPTION = "It's not every day that you come across a midweight quarter-zip fleece" +
            " jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";

    ItemDetailsPage itemDetailsPage;
    BasketPage basketPage;

    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemPrice(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");
    }

    @Test
    public void checkTheAddedItemInTheCart() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        basketPage.clickingOnTheShoppingCart();
        Assert.assertEquals(basketPage.getItemNameInBasket(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(basketPage.getItemPriceInBasket(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(basketPage.getItemDescriptionInBasket(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");

    }
}