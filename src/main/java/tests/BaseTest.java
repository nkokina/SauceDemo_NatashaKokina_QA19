package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static String USERNAME = "standard_user";
    protected static String PASSWORD = "secret_sauce";
    protected static String FIRSTNAME = "z";
    protected static String LASTNAME = "a";
    protected static String POSTALCODE = "123";
    protected static String PRODUCT_NAME = "Sauce Labs Backpack";
    protected static String PRODUCT_PRICE = "$29.99";
    protected static String PRODUCT_DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }

    @BeforeMethod
    public void openSauceDemo() {
        driver.get("https://www.saucedemo.com");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
