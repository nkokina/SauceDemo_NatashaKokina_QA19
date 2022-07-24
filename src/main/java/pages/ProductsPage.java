package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends HomePage {
    private final By productSort = By.cssSelector(".product_sort_container");
    private final By nameProduct = By.cssSelector(".inventory_item_name");
    private final By descriptionProduct = By.cssSelector(".inventory_item_description");
    private final By priceProduct = By.cssSelector(".inventory_item_price");
    private final By productLink = By.cssSelector("a[id$=_link]");
    private final String productContainerLocator
            = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final String productContainerLocatorDescription
            = "//div[@class = 'inventory_item_desc' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final String productContainerLocatorPrice
            = "//div[@class = 'inventory_item_price' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final By productsPageHeader = By.id("header_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public void clickProductSortButton() {
        driver.findElement(productSort).click();
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productsName)));
    }

    public void openItemByName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();
    }

    public void sortAZ() {
        List<WebElement> elementList = driver.findElements(nameProduct);
        Select select = new Select(driver.findElement(productSort));
        select.selectByVisibleText("Name (A to Z)");
        List<String> obtainedList = new ArrayList<>();
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        List<String> sortedList = obtainedList.stream().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(obtainedList), "AZ");
    }


    public void sortZA() {
        List<WebElement> elementList = driver.findElements(nameProduct);
        Select select = new Select(driver.findElement(productSort));
        select.selectByVisibleText("Name (Z to A)");
        List<String> obtainedList = new ArrayList<>();
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        List<String> sortedList = obtainedList.stream().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(obtainedList), "ZA");
    }

    public void sortLowToHigh() {
        List<WebElement> elementList = driver.findElements(nameProduct);
        Select select = new Select(driver.findElement(productSort));
        select.selectByVisibleText("Price (low to high)");
        List<String> obtainedList = new ArrayList<>();
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        List<String> sortedList = obtainedList.stream().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(obtainedList), "low to high");


//        List<WebElement> elementList = driver.findElements(priceProduct);
//        List<Double> doublesPrice = new ArrayList<>();
//        for (WebElement p : elementList) {
//            doublesPrice.add(Double.valueOf(p.getText().replace("$", "")));
//        }
//        Select dropDown = new Select(driver.findElement(productSort));
//        dropDown.selectByVisibleText("Price (low to high)");
//        List<WebElement> afterPrice = driver.findElements(priceProduct);
//        List<Double> afterDoublePrice = new ArrayList<>();
//        for (WebElement p : afterPrice) {
//            afterDoublePrice.add(Double.valueOf(p.getText().replace("$", "")));
//        }
//        Collections.sort(doublesPrice);
//        Assert.assertEquals(doublesPrice, afterDoublePrice);
    }

    public void sortHighToLow() {
        List<WebElement> elementList = driver.findElements(nameProduct);
        Select select = new Select(driver.findElement(productSort));
        select.selectByVisibleText("Price (high to low)");
        List<String> obtainedList = new ArrayList<>();
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        List<String> sortedList = obtainedList.stream().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(obtainedList), "high to low");
    }

    public boolean getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(nameProduct).isDisplayed();
    }

    private WebElement getProductContainerByDescription(String productsDescription) {
        return driver.findElement(By.xpath(String.format(productContainerLocatorDescription, productsDescription)));
    }

    public boolean getProductDescription(String productsDescription) {
        WebElement productContainer = getProductContainerByDescription(productsDescription);
        return productContainer.findElement(descriptionProduct).isDisplayed();
    }

    private WebElement getProductContainerByPrice(String productsPrice) {
        return driver.findElement(By.xpath(String.format(productContainerLocatorPrice, productsPrice)));
    }

    public boolean getProductPrice(String productsPrice) {
        WebElement productContainer = getProductContainerByPrice(productsPrice);
        return productContainer.findElement(priceProduct).isDisplayed();
    }
}
