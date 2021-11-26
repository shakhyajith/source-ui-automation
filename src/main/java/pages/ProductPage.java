package pages;

import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.core.ElementHandler;

import java.util.Optional;

public class ProductPage {
    private final By productLbl = By.cssSelector(".title");
    private final By inventories = By.cssSelector(".inventory_item");
    private final By inventoryName = By.cssSelector(".inventory_item_name");


    public String getProductLabel() {
        return ElementHandler.getElement(productLbl).getText();
    }

    public void selectProduct(ProductData productData) {
        Optional<WebElement> pr = ElementHandler.getElements(inventories).stream().
                filter(element -> element.findElement(inventoryName).getText().equals(productData.getName())).
                findFirst();
        pr.ifPresent(element -> element.findElement(By.tagName("button")).click());
    }
}
