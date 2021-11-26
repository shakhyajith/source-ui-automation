package pages;

import models.CustomerData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.core.ElementHandler;

public class CheckoutPage {

    private final By header = By.xpath("//span[@class='title']");
    private final By firstNameTxt = By.id("first-name");
    private final By lastNameTxt = By.id("last-name");
    private final By postalCodeTxt = By.id("postal-code");
    private final By continueBtn = By.id("continue");


    public void waitTillPageLoad() {
        ElementHandler.waitTill(ExpectedConditions.textToBe(header, "CHECKOUT: YOUR INFORMATION"), 100);
    }

    public void fillCustomerInformation(CustomerData customerData) {
        ElementHandler.sendKeys(customerData.getFirstName(), firstNameTxt);
        ElementHandler.sendKeys(customerData.getLastName(), lastNameTxt);
        ElementHandler.sendKeys(customerData.getPostalCode(), postalCodeTxt);
        ElementHandler.click(continueBtn);
    }


}
