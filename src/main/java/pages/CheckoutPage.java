package pages;

import models.CustomerData;
import models.OrderSummary;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.core.ElementHandler;

public class CheckoutPage {

    private final By header = By.xpath("//span[@class='title']");
    private final By firstNameTxt = By.id("first-name");
    private final By lastNameTxt = By.id("last-name");
    private final By postalCodeTxt = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    private final By inventoryName = By.cssSelector(".inventory_item_name");
    private final By inventoryPrice = By.cssSelector(".inventory_item_price");
    private final By summaryTax = By.cssSelector(".summary_tax_label");
    private final By summaryTotal = By.cssSelector(".summary_total_label");
    private final By finishBtn = By.cssSelector("finish");


    public void waitTillPageLoad() {
        ElementHandler.waitTill(ExpectedConditions.textToBe(header, "CHECKOUT: YOUR INFORMATION"), 100);
    }

    public void fillCustomerInformation(CustomerData customerData) {
        ElementHandler.sendKeys(customerData.getFirstName(), firstNameTxt);
        ElementHandler.sendKeys(customerData.getLastName(), lastNameTxt);
        ElementHandler.sendKeys(customerData.getPostalCode(), postalCodeTxt);
        ElementHandler.click(continueBtn);
    }

    public OrderSummary getOrderSummary() {
        String orderItemName = ElementHandler.getElement(inventoryName).getText();
        double price = Double.parseDouble(ElementHandler.getElement(inventoryPrice).getText().replace("$", ""));
        double tax = Double.parseDouble(ElementHandler.getElement(summaryTax).getText().replace("$", "").replace("Tax: ","").trim());
        double total = Double.parseDouble(ElementHandler.getElement(summaryTotal).getText().replace("$", "").replace("Total: ","").trim());
        return new OrderSummary(orderItemName, price, tax, total);
    }

    public void completeOrder(){
        ElementHandler.getElement(finishBtn).click();
    }


}
