public class saucedemo {

By.name("remove-sauce-labs-backpack");
By.id("login-button");
By.className("submit-button btn_action");
By.tagName("div");



By.xpath("//div[@id='shopping_cart_container']");
By.xpath("//div[text()='Sauce Labs Backpack']");
By.xpath("//img[contains(@alt,'Bike')]");
By.xpath("//div[contains(text(),'style with')]");
By.xpath("//*[text()='Sauce Labs Fleece Jacket']//ancestor::div[@id='root']");
By.xpath("//descendant-or-self::a//div['inventory_item_name']");
By.xpath("//following-sibling::*[5]/self::div['inventory_']");
By.xpath("//*[a="Twitter"]/parent::ul");
By.xpath("//div[contains(@id,'inventory_container')]/preceding-sibling::div[@id='header_container']");
By.xpath("//button[contains(@class,'btn_secondary btn_small') and contains(@id,'-labs-backpack')]");

By.cssSelector("#shopping_cart_container");
By.cssSelector(".app_logo");
By.cssSelector(".bm-item.menu-item");
By.cssSelector(".btn_small.btn.btn_inventory");
By.cssSelector("div");
By.cssSelector("div.inventory_item_label");
By.cssSelector("[id=item_4_img_link]");
By.cssSelector("[alt~=Bike]");
By.cssSelector("[id|=remove-sauce]");
By.cssSelector("[alt^=Test]");
By.cssSelector("[id$=menu-btn]");
By.cssSelector("[srcset*=menu]");
