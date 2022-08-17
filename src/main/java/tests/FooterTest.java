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
    public void CheckingLinksFooter()  {
        loginPage.login("standard_user", "secret_sauce");
        itemDetailsPage.clickTwitterInFooter();
        itemDetailsPage.waitForPageLoaded();
        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://twitter.com/saucelabs",
                "Transition twitter link not working");
        itemDetailsPage.closeLastPage();
        itemDetailsPage.clickFacebookInFooter();
        itemDetailsPage.waitForPageLoaded();
        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://www.facebook.com/saucelabs",
                "Transition facebook link not working");
//        itemDetailsPage.closeLastPage();
//        itemDetailsPage.clickLinkedinInFooter();
//        Assert.assertEquals(itemDetailsPage.getPageUrl(), "https://www.linkedin.com/company/sauce-labs/",
//                "Transition linkedin link not working");
    }
}
