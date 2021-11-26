package pages.components;

import org.openqa.selenium.By;
import util.core.ElementHandler;

public class HeaderComponent {

    private final By cartCount = By.cssSelector(".shopping_cart_badge");
    private final  By shoppingCart = By.cssSelector(".shopping_cart_link");


    public String getCartCount() {
        return ElementHandler.getElement(cartCount).getText();
    }

    public void  navigateToCheckout(){
        ElementHandler.click(shoppingCart);
    }

}
