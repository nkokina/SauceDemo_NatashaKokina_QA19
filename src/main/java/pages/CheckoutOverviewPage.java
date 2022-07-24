package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends HomePage {
    @FindBy(className = "checkout_summary_container")
    WebElement checkoutOverview;
    @FindBy(className = "inventory_item_name")
    WebElement itemNameInCheckout;
    @FindBy(className = "inventory_item_desc")
    WebElement itemDescriptionInCheckout;
    @FindBy(className = "inventory_item_price")
    WebElement itemPriceInCheckout;
    @FindBy(className = "summary_subtotal_label")
    WebElement summarySubtotalLabel;
    @FindBy(className = "summary_tax_label")
    WebElement summaryTaxLabel;
    @FindBy(className = "summary_total_label")
    WebElement summaryTotalLabel;
    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getSummarySubtotalLabel() {
        return summarySubtotalLabel.getText();
    }

    public String getSummaryTaxLabel() {
        return summaryTaxLabel.getText();
    }

    public String getSummaryTotalLabel() {
        return summaryTotalLabel.getText();
    }

    public boolean isCheckoutOverviewDisplayed() {
        return checkoutOverview.isDisplayed();
    }

    public String getItemNameInCheckout() {
        return itemNameInCheckout.getText();
    }

    public String getItemDescriptionInCheckout() {
        return itemDescriptionInCheckout.getText();
    }

    public String getItemPriceInCheckout() {
        return itemPriceInCheckout.getText();
    }
}
