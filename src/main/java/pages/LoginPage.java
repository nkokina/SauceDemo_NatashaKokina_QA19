package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessege = By.cssSelector(".error-message-container.error");
    private final By loginPage = By.cssSelector(".login_wrapper");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessege).isDisplayed();
    }

    public String getErrorMessageDisplayed() {
        return driver.findElement(errorMessege).getText();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginPage).isDisplayed();
    }
}
