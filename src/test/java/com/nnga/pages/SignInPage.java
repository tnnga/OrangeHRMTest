package com.nnga.pages;

import com.nnga.resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;
    private Resources resources;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        resources = new Resources(driver);
    }

    private By usernameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");

    public AdminPage SignIn(String email, String password) {
        resources.waitForPageLoaded();
        resources.setText(usernameInput, email);
        resources.setText(passwordInput, password);
        resources.clickElement(loginButton);

        return new AdminPage(driver);
    }
}
