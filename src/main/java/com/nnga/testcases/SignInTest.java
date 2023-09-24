package com.nnga.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nnga.base.BaseSetup;
import com.nnga.pages.SignInPage;

public class SignInTest{
//
//    private WebDriver driver;
//    public SignInPage signInPage;
//
//    @BeforeClass
//    public void setUp() {
//        driver = getDriver();
//    }
//
//    @Test()
//    public void signIn() throws Exception {
//        System.out.println(driver);
//        signInPage = new SignInPage(driver);
//
//        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
//        Assert.assertTrue(signInPage.verifySignInPageText(), "Header page text not matching");
//
//        signInPage.signin("thaian@mailinator.com", "Demo@123", "123456");
//
//    }
}