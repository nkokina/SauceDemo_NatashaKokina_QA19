package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTests extends BaseTest {

    @Test(groups = "Regression")
    public void sortProductsTest() {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.sortProducts("Name (Z to A)"),
                "Name (Z to A) sorting not working");
        Assert.assertTrue(productsPage.sortProducts("Name (A to Z)"),
                "Name (A to Z) sorting not working");
        Assert.assertTrue(productsPage.sortProducts("Price (low to high)"),
                "Price (low to high) sorting not working");
        Assert.assertTrue(productsPage.sortProducts("Price (high to low)"),
                "Price (high to low) sorting not working");

    }
}