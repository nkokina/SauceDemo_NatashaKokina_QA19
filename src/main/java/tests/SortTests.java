package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTests extends BaseTest {

    @Test(groups = {"Regression"})
    public void sortZToATest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Name (Z to A)");
        List<String> actualListOfProductsName = productsPage.getListOfProductsName();
        List<String> expectedListOfProductsName = productsPage.getListOfProductsName();
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        expectedListOfProductsName.sort(reverseComparator);
        Assert.assertEquals(actualListOfProductsName, expectedListOfProductsName,
                "Name (Z to A) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortAToZTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Name (A to Z)");
        List<String> actualListOfProductsName = productsPage.getListOfProductsName();
        List<String> expectedListOfProductsName = productsPage.getListOfProductsName();
        Collections.sort(expectedListOfProductsName);
        Assert.assertEquals(actualListOfProductsName, expectedListOfProductsName,
                "Name (A to Z) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortLowToHighTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Price (low to high)");
        List<Double> actualListOfProductsPrice = productsPage.getListOfProductsPrice();
        List<Double> expectedListOfProductsPrice = productsPage.getListOfProductsPrice();
        Collections.sort(expectedListOfProductsPrice);
        Assert.assertEquals(actualListOfProductsPrice, expectedListOfProductsPrice,
                "Name (A to Z) sorting not working");
    }

    @Test(groups = {"Regression"})
    public void sortHighToLowTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.selectSort("Price (high to low)");
        List<Double> actualListOfProductsPrice = productsPage.getListOfProductsPrice();
        List<Double> expectedListOfProductsPrice = productsPage.getListOfProductsPrice();
        Comparator<Double> reverseComparator = Comparator.reverseOrder();
        expectedListOfProductsPrice.sort(reverseComparator);
        Assert.assertEquals(actualListOfProductsPrice, expectedListOfProductsPrice,
                "Name (A to Z) sorting not working");
    }
}