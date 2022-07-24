package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends BasePage {
    protected final By footerCopy = By.cssSelector(".footer_copy");
    protected final By socialTwitter = By.xpath("//*[@class='social_twitter']//ancestor::a[@href='https://twitter.com/saucelabs']");
    protected final By socialLinkedin = By.xpath("//*[@class='social_linkedin']//ancestor::a[@href='https://www.facebook.com/saucelabs']");
    protected final By socialFacebook = By.xpath("//*[@class='social_facebook']//ancestor::a[@href='https://www.linkedin.com/company/sauce-labs/']");


    protected By shoppingCart = By.cssSelector(".shopping_cart_link");
    protected By menuPage = By.cssSelector(".bm-burger-button");
    protected By allItemsMenu = By.id("inventory_sidebar_link");
    protected By aboutMenu = By.id("about_sidebar_link");
    protected By logoutMenu = By.id("logout_sidebar_link");
    protected By resetMenu = By.id("reset_sidebar_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getFooterCopyText() {
        return driver.findElement(footerCopy).getText();
    }

    public void clickTwitterInFooter() {
        driver.findElement(socialTwitter).click();
    }

    public void clickFacebookInFooter() {
        driver.findElement(socialFacebook).click();
    }

    public void clickLinkedinInFooter() {
        driver.findElement(socialLinkedin).click();
    }

    public String getPageTransition() {
        driver.switchTo().window("0");
        return driver.getCurrentUrl();
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
