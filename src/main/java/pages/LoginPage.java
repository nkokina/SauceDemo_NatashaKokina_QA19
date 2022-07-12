package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessege = By.cssSelector(".error-message-container.error");
    private By loginPage = By.cssSelector(".login_wrapper");

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

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessege).isDisplayed();
    }
    public String getErrorMessageDisplayed(){
        return driver.findElement(errorMessege).getText();
    }
    public boolean isLoginPage(){
        return  driver.findElement(loginPage).isDisplayed();
    }
}
