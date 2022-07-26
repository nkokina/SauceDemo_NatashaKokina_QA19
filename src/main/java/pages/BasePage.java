package pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void timeOuts() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
