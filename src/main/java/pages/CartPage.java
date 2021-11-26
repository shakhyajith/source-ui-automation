package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.core.ElementHandler;

public class CartPage {

    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By checkoutBtn = By.id("checkout");
    private final By header = By.xpath("//span[@class='title']");


    public void waitTillPageLoad() {
        ElementHandler.waitTill(ExpectedConditions.textToBe(header, "YOUR CART"), 100);
    }

    public String getItemName() {
        waitTillPageLoad();
        return ElementHandler.getElement(itemName).getText();
    }

    public Double getItemPrice() {
        waitTillPageLoad();
        return Double.parseDouble(ElementHandler.getElement(itemPrice).getText().replace("$", "").trim());
    }

    public void navigateToCheckout() {
        waitTillPageLoad();
        ElementHandler.click(checkoutBtn);
    }

}
