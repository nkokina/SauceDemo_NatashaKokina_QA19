package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import java.util.concurrent.TimeUnit;

public class FooterTest extends BaseTest {

    private final static String FOOTER_COPY_TEXT =
            "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
    ItemDetailsPage itemDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test(description = "Test", groups = {"Regression"})
    public void TextFooter() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(itemDetailsPage.getFooterCopyText(), FOOTER_COPY_TEXT, "Text does not match");
    }

    @Test(description = "Test", groups = {"Regression"})
    public void CheckingLinksFooter()  {
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickTwitterInFooter();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://twitter.com/saucelabs",
                "Transition twitter link not working");
        itemDetailsPage.timeOuts();
        itemDetailsPage.closeLastPage();
        itemDetailsPage.clickFacebookInFooter();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://www.facebook.com/saucelabs",
                "Transition facebook link not working");
        itemDetailsPage.timeOuts();
        itemDetailsPage.closeLastPage();
        itemDetailsPage.clickLinkedinInFooter();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://www.linkedin.com/",
                "Transition linkedin link not working");
    }
}
