package com.nnga.pages;

import com.nnga.commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import com.nnga.base.ValidateHelper;

public class SignInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By usernameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");

    private By loginButton = By.xpath("//button[normalize-space()='Login']");

    public SignInPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void SignIn(String email, String password){
        validateHelper.waitForPageLoaded();
        validateHelper.setText(usernameInput, email);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginButton);
    }
}
