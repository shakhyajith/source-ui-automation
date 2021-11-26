package pages.components;

import org.openqa.selenium.By;
import util.core.ElementHandler;

public class HeaderComponent {

    private final By cartCount = By.cssSelector(".shopping_cart_badge");


    public String getCartCount(){

        return  ElementHandler.getElement(cartCount).getText();
    }

}
