package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected static String USERNAME = "standard_user";
    protected static String PASSWORD = "secret_sauce";
    protected static String FIRSTNAME = "z";
    protected static String LASTNAME = "a";
    protected static String POSTAL_CODE = "123";
    protected static String PRODUCT_NAME = "Sauce Labs Backpack";
    protected static String PRODUCT_PRICE = "$29.99";
    protected static String PRODUCT_DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @BeforeClass(alwaysRun = true, description = "driver")
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
           ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            option.addArguments("--ignore-certificate-errors");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        testContext.setAttribute("driver",driver);

    }

    @BeforeMethod(alwaysRun = true, description = "navigate")
    public void openSauceDemo() {
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
    }

    @AfterClass(alwaysRun = true, description = "Close driver")
    public void tearDown() {
        driver.quit();
    }
}
