package com.nnga.testcases;

import com.nnga.commons.BaseSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.nnga.pages.SignInPage;
import com.nnga.commons.ValidateHelper;

public class SignInTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private SignInPage signInPage;

    @BeforeClass
    public void setUpBrowser() {
        driver = getDriver();
    }

    @Test
    public void signPage() {
        signInPage = new SignInPage(driver);
        signInPage.SignIn("Admin", "admin123");
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}