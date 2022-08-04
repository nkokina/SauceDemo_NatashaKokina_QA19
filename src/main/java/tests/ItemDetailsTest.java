package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ItemDetailsPage;

public class ItemDetailsTest extends BaseTest {

    ItemDetailsPage itemDetailsPage;
    BasketPage basketPage;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(groups = {"Smoke"})
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

    @Test(groups = {"Smoke"})
    public void checkTheAddedItemInTheCart() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartItemButton();
        basketPage.clickingOnTheShoppingCart();
        Assert.assertEquals(basketPage.getItemNameInBasket(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(basketPage.getItemPriceInBasket(), PRODUCT_PRICE,
                "The price of the book does not correspond");
        Assert.assertEquals(basketPage.getItemDescriptionInBasket(), PRODUCT_DESCRIPTION,
                "The description of the book does not correspond");
    }

    @Test(groups = {"Smoke"}, dataProvider = "inventoryItemsTestData")
    public void inventoryItemsTest(String nameItem, String descriptionItem, String priceItem) {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.getProductName(nameItem), "Product name is wrong");
        Assert.assertTrue(productsPage.getProductDescription(descriptionItem), "Product description is wrong");
        Assert.assertTrue(productsPage.getProductPrice(priceItem), "Product price is wrong");

    }

    @DataProvider
    public Object[][] inventoryItemsTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "29.99"},
                {"Sauce Labs Bike Light", "the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "9.99"},
                {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "15.99"},
                {"Sauce Labs Fleece Jacket", " not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "49.99"},
                {"Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom", "7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.", "15.99"},
        };
    }
}
