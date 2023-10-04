package com.nnga.testcases;

import com.nnga.commons.BaseSetup;
import com.nnga.pages.AdminPage;
import com.nnga.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTest extends BaseSetup {
    WebDriver driver;
    private AdminPage adminPage;
    private SignInPage signInPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test (priority = 0)
    public void signPage() {
        signInPage = new SignInPage(driver);
        adminPage = signInPage.SignIn("Admin", "admin123");
    }

    @Test (priority = 1)
    public void showAdminPage() {
        adminPage.openAdminPage();
    }
}
