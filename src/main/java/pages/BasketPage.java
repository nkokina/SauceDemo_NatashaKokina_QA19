package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends HomePage {
    private final By itemNameInBasket = By.cssSelector(".inventory_item_name");
    private final By itemDescriptionInBasket = By.cssSelector(".inventory_item_desc");
    private final By itemPriceInBasket = By.cssSelector(".inventory_item_price");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInBasket() {
        return driver.findElement(itemNameInBasket).getText();
    }

    public String getItemDescriptionInBasket() {
        return driver.findElement(itemDescriptionInBasket).getText();
    }

    public String getItemPriceInBasket() {
        return driver.findElement(itemPriceInBasket).getText();
    }


}
