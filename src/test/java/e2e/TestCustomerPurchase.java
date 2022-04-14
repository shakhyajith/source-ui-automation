package e2e;

import e2e.base.TestBase;
import models.CustomerData;
import models.LoginData;
import models.OrderSummary;
import models.ProductData;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.components.HeaderComponent;
import util.core.ElementHandler;
import util.support.ExcelReader;

public class TestCustomerPurchase extends TestBase {
    String TestId = "T001";
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    HeaderComponent headerComponent = new HeaderComponent();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    LoginData validLogin = ExcelReader.getExcelData(LoginData.class, TestId);
    ProductData productData = ExcelReader.getExcelData(ProductData.class, TestId);
    CustomerData customerData = ExcelReader.getExcelData(CustomerData.class, TestId);

    @Test
    public void testUserLogin() {

        System.out.println(validLogin);
        loginPage.login(validLogin);
        Assert.assertEquals(productPage.getProductLabel(), "PRODUCTS");
    }

    @Test(dependsOnMethods = "testUserLogin")
    public void testSelectProduct() {
        productPage.selectProduct(productData);
        Assert.assertEquals(headerComponent.getCartCount(), "1");
    }

    @Test(dependsOnMethods = "testSelectProduct")
    public void testCart() {
        headerComponent.navigateToCheckout();
        Assert.assertEquals(cartPage.getItemName(), productData.getName());
        Assert.assertEquals(cartPage.getItemPrice(), productData.getPrice());
    }

    @Test(dependsOnMethods = "testCart")
    public void testCheckout() {
        cartPage.navigateToCheckout();
        checkoutPage.waitTillPageLoad();
        checkoutPage.fillCustomerInformation(customerData);
        OrderSummary summary = checkoutPage.getOrderSummary();

        Assert.assertEquals(summary.getOrderItemName(), productData.getName());
        Assert.assertEquals(summary.getOrderItemPrice(), productData.getPrice());
        Assert.assertEquals(summary.getOrderItemTax(), 1.28);
        Assert.assertEquals(summary.getOrderItemTotal(), (summary.getOrderItemTax() + productData.getPrice()));
    }

     @AfterSuite
    public void tearDown() {
        ElementHandler.quitDriver();
    }
}
