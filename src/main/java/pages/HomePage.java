package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends BasePage {

    protected By shoppingCart = By.cssSelector(".shopping_cart_link");
    protected By menuPage = By.cssSelector(".bm-burger-button");
    protected By allItemsMenu = By.id("inventory_sidebar_link");
    protected By aboutMenu = By.id("about_sidebar_link");
    protected By logoutMenu = By.id("logout_sidebar_link");
    protected By resetMenu = By.id("reset_sidebar_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuPage() {
        driver.findElement(menuPage).click();
    }

    public void clickAllItemsMenu() {
        driver.findElement(allItemsMenu).click();
    }

    public void clickAboutMenu() {
        driver.findElement(aboutMenu).click();
    }

    public void clickLogoutMenu() {
        driver.findElement(logoutMenu).click();
    }

    public void clickResetMenu() {
        driver.findElement(resetMenu).click();
    }

    public boolean isAboutMenuDisplayed() {
        return !driver.getCurrentUrl().isEmpty();
    }

    public void clickingOnTheShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

}
