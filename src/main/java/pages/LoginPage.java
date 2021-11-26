package pages;

import models.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.core.ElementHandler;

public class LoginPage {

    private final By usernameTxt = By.id("user-name");
    private final By passwordTxt = By.id("password");
    private final By loginBtn = By.id("login-button");

    public void login(LoginData loginData){
        ElementHandler.openApplication("https://www.saucedemo.com/");
        ElementHandler.waitTill(ExpectedConditions.elementToBeClickable(loginBtn),1000);
        ElementHandler.sendKeys(loginData.getUsername(),usernameTxt);
        ElementHandler.sendKeys(loginData.getPassword(),passwordTxt);
        ElementHandler.click(loginBtn);
    }
}
