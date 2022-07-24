package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;


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
    public void CheckingLinksFooter() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickTwitterInFooter();
        Thread.sleep(8000);
        Assert.assertEquals(itemDetailsPage.getPageTransition(), "https://twitter.com/saucelabs",
                "Transition link not working");
        driver.navigate().back();
        itemDetailsPage.clickFacebookInFooter();
        Thread.sleep(8000);
        Assert.assertEquals(itemDetailsPage.getPageTransition(), "https://www.facebook.com/saucelabs",
                "Transition link not working");
        driver.navigate().back();
        itemDetailsPage.clickLinkedinInFooter();
        Thread.sleep(8000);
        Assert.assertEquals(itemDetailsPage.getPageTransition(), "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQEghd_pcL2S2QAAAYIWMBh4tLgUDz3gd4NocnErPqVydsVBZtMFvNf1eYCUu9k7yRswpNDcwaA8hSrJ7wIPHa8ftZcHv1QhTYE8JHtjPx9ajBdLT2hz0VnRv2iiDF2A93yRc6A=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F",
                "Transition link not working");
    }
}
