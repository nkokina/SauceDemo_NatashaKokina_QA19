package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemDetailsPage extends HomePage {
    protected final By itemName = By.cssSelector(".inventory_details_name");

    private final By itemDescription = By.cssSelector(".inventory_details_desc");
    private final By itemPrice = By.cssSelector(".inventory_details_price");
    private final By removeButton = By.cssSelector("button[id^=remove-sauce-labs-backpack]");
    private final By addToCartItemButton
            = By.cssSelector("button[id^=add-to-cart]");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(removeButton).isDisplayed();
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


    public void clickAddToCartItemButton() {
       driver.findElement(addToCartItemButton).click();
    }


}
