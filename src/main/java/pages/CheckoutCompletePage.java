package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends HomePage {
    private final By checkoutCompletePage = By.cssSelector(".checkout_complete_container");
    private final By completeHeader = By.cssSelector(".complete-header");
    private final By completeText = By.cssSelector(".complete-text");
    private final By BackHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void clickBackHomeButton() {
        driver.findElement(BackHomeButton).click();
    }

    public boolean isCheckoutCompleteDisplayed() {
        return driver.findElement(checkoutCompletePage).isDisplayed();
    }

    public String getCompleteHeader() {
        return driver.findElement(completeHeader).getText();
    }

    public String getCompleteText() {
        return driver.findElement(completeText).getText();
    }
}
