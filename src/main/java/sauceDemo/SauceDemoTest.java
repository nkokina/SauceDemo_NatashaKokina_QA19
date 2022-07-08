package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemoTest {

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        WebElement expectedNameProduct = driver.findElement(By.xpath("//div[text()='29.99']"));
        String expectedNameProductStr = expectedNameProduct.getText();
        WebElement expectedPriceProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String expectedPriceProductStr = expectedPriceProduct.getText();
        driver.findElement(By.cssSelector(" *[name=add-to-cart-sauce-labs-backpack]")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        WebElement actualNameProduct = driver.findElement(By.xpath("//div[text()='29.99']"));
        String actualNameProductStr = actualNameProduct.getText();
        WebElement actualPriceProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String actualPriceProductStr = actualPriceProduct.getText();
        Assert.assertEquals(actualNameProductStr, expectedNameProductStr, "Items ");
        Assert.assertEquals(actualPriceProductStr, expectedPriceProductStr, "Items are not removed");
        driver.quit();
    }
}
