package com.nnga.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nnga.base.BaseSetup;
import com.nnga.pages.SignInPage;
import com.nnga.base.ValidateHelper;

import static java.sql.DriverManager.getDriver;

public class SignInTest{
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private SignInPage signInPage;
    @BeforeTest
    public void Init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        validateHelper = new ValidateHelper(driver);
        signInPage = new SignInPage(driver);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void Test(){
        signInPage.SignIn("Admin", "admin123");
    }
    @AfterTest
    public void Finish(){
        validateHelper.Sleep(3000);
        driver.quit();
    }

}