package e2e;

import models.LoginData;
import models.ProductData;
import org.apache.poi.hssf.record.HeaderRecord;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.components.HeaderComponent;
import util.core.ElementHandler;
import util.support.ExcelReader;

public class TestCustomerPurchase {
    String TestId = "T001";
    LoginData validLogin = ExcelReader.getExcelData(LoginData.class,TestId);
    ProductData productData = ExcelReader.getExcelData(ProductData.class,TestId);
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    HeaderComponent headerComponent = new HeaderComponent();


    @Test
    public void testUserLogin(){
        System.out.println(validLogin);
        loginPage.login(validLogin);
        Assert.assertEquals(productPage.getProductLabel(),"PRODUCTS");
    }
    @Test(dependsOnMethods = "testUserLogin")
    public void testSelectProduct(){
        productPage.selectProduct(productData);
        Assert.assertEquals(headerComponent.getCartCount(),"1");
    }

    @AfterSuite
    public void tearDown(){
        ElementHandler.quitDriver();
    }
}
