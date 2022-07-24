package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(description = "Test", invocationCount = 3, threadPoolSize = 3, groups = {"Smoke"})
    //описание теста,  enabled = false тест не будет запускаться,priority=0 0-НЕНУЖНОзапускается первым, количесов тестов запуск, сколько потоков запускается одновременно
    public void positiveLogin() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }

    @Test(groups = {"Regression", "Negative"}, dataProvider = " negativeLoginTestData")
    public void negativeLoginTest(String userName, String Password, String expectedErrorMessage) {
        loginPage.setUserName(userName);
        loginPage.setPassword(Password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageDisplayed(),
                expectedErrorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", PASSWORD, "Epicsadf"},
                {USERNAME, "", "Epic sadface"},
                {"", "", ""},
        };
    }

}
