package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HomePage {
    private final By productSort = By.cssSelector(".product_sort_container");
    private final By productNameSelector = By.cssSelector(".inventory_item_name");
    private final By productPriceSelector = By.cssSelector(".inventory_item_price");
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
    private final By addToCartButton
            = By.cssSelector("button[id^=add-to-cart]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddToCartButton(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(addToCartButton).click();
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productsName)));
    }

    public void openItemByName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();
    }

    public List<String> getListOfProductsName() {
        List<WebElement> elementList = driver.findElements(productNameSelector);
        List<String> result = new ArrayList<>();
        for (WebElement element: elementList) {
            result.add(element.getText());
        }
        return result;
    }

    public List<Double> getListOfProductsPrice() {
        List<WebElement> elementList = driver.findElements(productPriceSelector);
        List<Double> result = new ArrayList<>();
        for (WebElement element: elementList) {
            result.add(Double.valueOf(element.getText().replace("$", "")));
        }
        return result;
    }

    public void selectSort(String sortName){
        Select select = new Select(driver.findElement(productSort));
        select.selectByVisibleText(sortName);
    }

    public boolean getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(productNameSelector).isDisplayed();
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
