package tests;

import org.testng.annotations.Test;

public class SortTests extends BaseTest {

    @Test(groups = "Regression")
    public void sortProductsTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickProductSortButton();
        productsPage.sortZA();
        productsPage.clickProductSortButton();
        productsPage.sortAZ();
        productsPage.clickProductSortButton();
        productsPage.sortLowToHigh();
        productsPage.clickProductSortButton();
        productsPage.sortHighToLow();

    }
}