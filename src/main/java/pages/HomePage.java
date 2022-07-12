package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private final By shoppingCart = By.cssSelector(".shopping_cart_link");

    private final By menuPage = By.cssSelector(".bm-burger-button");
    private final By allItemsMenu = By.id("inventory_sidebar_link");

    private final By aboutMenu = By.id("about_sidebar_link");
    private final By logoutMenu = By.id("logout_sidebar_link");
    private final By resetMenu = By.id("reset_sidebar_link");
    private final By saucelabs = By.id("template__page");

    public HomePage(WebDriver driver){
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
    public boolean isAboutMenuDisplayed (){
        return driver.findElement(saucelabs).isDisplayed();
    }
    public void clickingOnTheShoppingCart() {
        driver.findElement(shoppingCart).click();
    }
}
