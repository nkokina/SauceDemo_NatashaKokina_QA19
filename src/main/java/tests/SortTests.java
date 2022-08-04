package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class SortTests extends BaseTest {

    String[] sortedNames = {"Sauce Labs Backpack","Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket", "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
    Double[] sortedPrice= {29.99,9.99, 15.99, 49.99, 7.99, 15.99};

    @Test(groups = {"Regression"})
    public void sortZToATest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Name (Z to A)");
        List<String> actualListOfProductsName = productsPage.getListOfProductsName();
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        List<String> expectedListOfProductsName= new ArrayList<>(List.of(sortedNames));
                expectedListOfProductsName.sort(reverseComparator);
        Assert.assertEquals(actualListOfProductsName, expectedListOfProductsName,
                "Name (Z to A) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortAToZTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Name (A to Z)");
        List<String> actualListOfProductsName = productsPage.getListOfProductsName();
        List<String> expectedListOfProductsName= new ArrayList<>(List.of(sortedNames));
        Collections.sort(expectedListOfProductsName);
        Assert.assertEquals(actualListOfProductsName, expectedListOfProductsName,
                "Name (A to Z) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortLowToHighTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Price (low to high)");
        List<Double> actualListOfProductsPrice = productsPage.getListOfProductsPrice();
        List<Double> expectedListOfProductsPrice = new ArrayList<>(List.of(sortedPrice));
        Collections.sort(expectedListOfProductsPrice);
        Assert.assertEquals(actualListOfProductsPrice, expectedListOfProductsPrice,
                "Price (low to high) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortHighToLowTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Price (high to low)");
        List<Double> actualListOfProductsPrice = productsPage.getListOfProductsPrice();
        List<Double> expectedListOfProductsPrice = new ArrayList<>(List.of(sortedPrice));
        Comparator<Double> reverseComparator = Comparator.reverseOrder();
        expectedListOfProductsPrice.sort(reverseComparator);
        Assert.assertEquals(actualListOfProductsPrice, expectedListOfProductsPrice,
                "Price (high to low) sorting not working");
    }
}