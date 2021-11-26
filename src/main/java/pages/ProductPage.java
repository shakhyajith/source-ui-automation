package pages;

import models.ProductData;
import org.openqa.selenium.By;
import util.core.ElementHandler;

public class ProductPage {
    private final By productLbl = By.cssSelector(".title");
    private final By inventories = By.cssSelector(".inventory_item");
    private final By inventoryName = By.cssSelector(".inventory_item_name");


    public String getProductLabel() {
        return ElementHandler.getElement(productLbl).getText();
    }

    public void selectProduct(ProductData productData) {
        ElementHandler.getElementFromList(inventories, element -> element.findElement(inventoryName).
                getText().equals(productData.getName()))
                .findElement(By.tagName("button")).click();
    }
}
