package com.nnga.projects.testcases;

import com.nnga.browsers.BaseSetupMulti;
import com.nnga.projects.pages.AdminPage;
import com.nnga.projects.pages.CreateAdminPage;
import com.nnga.projects.pages.SignInPage;
import com.nnga.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AdminTest extends BaseSetupMulti {
    WebDriver driver;
    private AdminPage adminPage;
    private SignInPage signInPage;
    private CreateAdminPage createAdminPage;

    @BeforeClass
    public void setUp() {
        driver = new BaseSetupMulti().setupDriver("chrom");
    }
    @Test(priority = 0)
    public void gotoBrower(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test (priority = 1, description = "Sign in page")
    public void signPage() {
        Log.info("sign");
        signInPage = new SignInPage(driver);
        adminPage = signInPage.SignIn("Admin", "admin123");
        Assert.assertTrue(false);
    }

    @Test (priority = 2)
    public void showAdminPage() {
        Log.info("showAdmin run");
        adminPage.openAdminPage();
        createAdminPage = adminPage.openAddAdminForm();
    }
    @Test(priority = 3)
    public void createAdmin(){
        createAdminPage.sendUserRole();
        createAdminPage.sendEmployeeName();
    }
}
