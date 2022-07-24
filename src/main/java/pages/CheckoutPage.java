package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends HomePage {
    private final By firsNamePage = By.id("first-name");
    private final By lastNamePage = By.id("last-name");
    private final By postalCodePage = By.id("postal-code");
    private final By continuePage = By.id("continue");
    private final By checkoutYourInformation = By.cssSelector(".page_wrapper");

    private final By checkoutButton = By.id("checkout");
    private final By errorMessege = By.cssSelector(".error-message-container.error");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutYourInformationDisplayed() {
        return driver.findElement(checkoutYourInformation).isDisplayed();
    }

    public void setFirstName(String firstName) {
        driver.findElement(firsNamePage).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNamePage).sendKeys(lastName);
    }

    public void setPostalCodePage(String postalCode) {
        driver.findElement(postalCodePage).sendKeys(postalCode);
    }

    public void clickContinueButton() {
        driver.findElement(continuePage).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void continuePage(String firstName, String lastName, String postalCode) {
        clickCheckoutButton();
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCodePage(postalCode);
        clickContinueButton();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessege).isDisplayed();
    }

    public String getErrorMessageDisplayed() {
        return driver.findElement(errorMessege).getText();
    }

}
