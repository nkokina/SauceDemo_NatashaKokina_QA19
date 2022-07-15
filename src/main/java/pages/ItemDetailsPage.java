package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends HomePage {
    private final By addToCartButton
            = By.cssSelector("button[id^=add-to-cart]");
    private final By itemName = By.cssSelector(".inventory_details_name");
    private final By itemDescription = By.cssSelector(".inventory_details_desc");
    private final By itemPrice = By.cssSelector(".inventory_details_price");
    private final By removeButton = By.cssSelector("button[id^=remove-sauce-labs-backpack]");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }


    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(removeButton).isDisplayed();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }


}
